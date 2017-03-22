package com.charlieaffs.ifs.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.charlieaffs.data.Constants;
import com.charlieaffs.data.tradeit.dao.BrokerRegistrationDao;
import com.charlieaffs.data.tradeit.dao.UserDao;
import com.charlieaffs.data.tradeit.model.BrokerRegistration;
import com.charlieaffs.data.tradeit.model.User;
import com.charlieaffs.ifs.configuration.SpringContextProvider;
import com.charlieaffs.ifs.external.handlers.BrokerLeadHandler;

@Component("brokerController")
public class BrokerControllerImpl implements BrokerController {
	
	@Autowired
	private BrokerRegistrationDao brDao;

	public static enum LeadHandlerType {
		TRADE_12("trade12LeadHandler", Constants.TRADE_12_CODE),
		U_BINARY("uBinaryLeadHandler", Constants.UBINARY_CODE),
		OPTECK("opteckLeadHandler", Constants.OPTECK_CODE);
		
		private final String beanName;
		private final int brokerId;
		
		private LeadHandlerType(String beanName, int brokerId) {
			this.beanName = beanName;
			this.brokerId = brokerId;
		}
		
		public String getBeanName() {
			return beanName;
		}
		
		public int getBrokerId() {
			return brokerId;
		}
		
		public static LeadHandlerType findByBrokerId(int brokerId) {
			switch (brokerId) {
				case Constants.TRADE_12_CODE:
					return LeadHandlerType.TRADE_12;
				case Constants.UBINARY_CODE:
					return LeadHandlerType.U_BINARY;
				case Constants.OPTECK_CODE:
					return LeadHandlerType.OPTECK;
				default:
					return null;
			}
		}
		
		public static LeadHandlerType[] findByBrokerIds(Integer[] brokerIds) {
			Set<LeadHandlerType> types = new HashSet<>();
			for(int id : brokerIds) {
				LeadHandlerType type = findByBrokerId(id);
				if(type != null) {
					types.add(type);
				}
			}
			return types.toArray(new LeadHandlerType[types.size()]);
		}
		
		public static Integer[] brokerIdValues() {
			LeadHandlerType[] types = values();
			Integer[] brokerIds = new Integer[types.length];
			for(int i = 0; i < types.length; i++) {
				brokerIds[i] = types[i].brokerId;
			}
			return brokerIds;
		}
	}
	
	private BrokerRegistration[] register(User user, String ip, LeadHandlerType[] handlerTypes) {
		BrokerRegistration[] results = new BrokerRegistration[handlerTypes.length];
		for(int i = 0; i < handlerTypes.length; i++) {
			BrokerLeadHandler handler = (BrokerLeadHandler) SpringContextProvider.getBean(handlerTypes[i].beanName);
			results[i] = handler.registerLead(user, ip);
		}
		return results;
	}

	@Override
	public BrokerRegistration[] registerWithBrokers(User user, String ip) {
		LeadHandlerType[] handlerTypes = LeadHandlerType.values();
		return register(user, ip, handlerTypes);
	}

	@Override
	public BrokerRegistration[] registerOldUsersWithBrokers(Integer[] userIds, Integer[] brokerIds) {
		if(brokerIds == null || brokerIds.length == 0) {
			brokerIds = LeadHandlerType.brokerIdValues();
		}
		
		UserDao userDao = SpringContextProvider.getBean(UserDao.class);
		List<User> users = userDao.findUsers(userIds);
		if(users != null && !users.isEmpty()) {
			Map<Integer, String> ipsByIds = brDao.mapIpsToUserIds(userIds);
			BrokerRegistration[] results = new BrokerRegistration[userIds.length * brokerIds.length];
			int index = 0;
			for(int j = 0; j < users.size(); j++) {
				User user = users.get(j);
				String ip = null;
				if(user != null) {
					ip = ipsByIds.get(user.getId());
					if(ip != null) {
						for(int i = 0; i < brokerIds.length; i++) {
							LeadHandlerType handlerType = LeadHandlerType.findByBrokerId(brokerIds[i]);
							if(handlerType != null) {
								BrokerLeadHandler handler = (BrokerLeadHandler) SpringContextProvider.getBean(handlerType.beanName);
								
								BrokerRegistration result = handler.registerLead(user, ip);
								if(result != null) {
									results[index++] = result;
								} else {
									results[index++] = new BrokerRegistration("could not register lead with handler for broker with id: " + brokerIds[i]);
								}
							} else {
								results[index++] = new BrokerRegistration("no lead handler exists for broker with id: " + brokerIds[i]);
							}
						}
					}
				}
				if(user == null || ip == null) {
					results[index] = new BrokerRegistration("Could not register user with id: " + userIds[j] + ", " 
							+ (user == null ? "(could not find user) " : "") 
							+ (ip == null ? "(could not find ip)" : ""));
					index += brokerIds.length;
				}
			}
			return results;
		} else {
			return new BrokerRegistration[] {new BrokerRegistration("no users with requested ids...")};
		}
	}

	@Override
	public BrokerRegistration[] registerWithBrokers(User user, String ip, Integer[] brokerIds) {
		return register(user, ip, LeadHandlerType.findByBrokerIds(brokerIds));
	}

}
