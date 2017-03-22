package com.charlieaffs.ifs.utils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.charlieaffs.data.Constants;
import com.charlieaffs.data.external.GeoLocation;
import com.charlieaffs.data.tradeit.dao.CountryDao;
import com.charlieaffs.data.tradeit.model.Country;
import com.charlieaffs.ifs.configuration.SpringContextProvider;
import com.charlieaffs.ifs.logging.TILogger;
import com.maxmind.geoip.LookupService;

public class CountryUtils {
	
	private final static Set<String> testIps = new HashSet<>();
	
	private static CountryDao countryDao;
	private static LookupService lookUp;

    static {
    	testIps.add(Constants.IP_LOCAL_HOST);
    	testIps.add("10.0.0.3");
    	testIps.add("10.0.0.10");
    	
    	countryDao = SpringContextProvider.getCountryDao();
    	
        try {
            lookUp = new LookupService(
                    SpringContextProvider.getApplicationContext()
                    	.getResource("classpath:GeoLiteCity.dat")
                    	.getFile(),
                    LookupService.GEOIP_MEMORY_CACHE);

            TILogger.getLog().info("GeoIP Database loaded: " + lookUp.getDatabaseInfo());
        } catch (IOException e) {
        	lookUp = null;
            TILogger.getLog().error("Could not load geo ip database: " + e.getMessage());
        }
    }

	public static Country getCountryFromIp(String ip) {
		Country result = null;
		if(lookUp != null) {
			if(testIps.contains(ip)) {
				ip = Constants.IP_ISRAEL;
			} 
			
			GeoLocation	location = GeoLocation.map(lookUp.getLocation(ip));
			
			if(location != null) {
				String countryCode = location.getCountryCode();
				if(Formatter.notEmpty(countryCode)) {
					result = countryDao.findByIso2(countryCode);
				}
				
				if(result == null) {
					String countryName = location.getCountryName();
					if(Formatter.notEmpty(countryName)) {
						result = countryDao.findByName(countryName);
					}
				}
			}
		}
		return result;
	}
	
	public static Country findById(Integer id) {
		return countryDao.findById(id);
	}
	
}
