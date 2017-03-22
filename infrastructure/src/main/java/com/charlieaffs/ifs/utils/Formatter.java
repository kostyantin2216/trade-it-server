package com.charlieaffs.ifs.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.charlieaffs.data.tradeit.dao.CountryDao;
import com.charlieaffs.data.tradeit.dao.LogDao;
import com.charlieaffs.data.tradeit.model.Country;
import com.charlieaffs.data.tradeit.model.Log;
import com.charlieaffs.data.tradeit.model.User;
import com.charlieaffs.ifs.configuration.SpringContextProvider;
import com.charlieaffs.ifs.logging.TILogger;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class Formatter {

	public final static String FORMAT_PARSE_DATE_OBJECT = "YYYY-MM-DDTHH:MM:SS.MMMZ";
	public final static String FORMAT_DEFAULT = "yyyy/MM/dd HH:mm:ss z";
	
	public static String formatToString(Date date) {
		return formatToString(FORMAT_DEFAULT, date);
	}

	public static String formatToString(String format, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String formatToString(String format, long time) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(time);
	}

	/**
	 * Uses the Default format of yyyy/MM/dd HH:mm:ss z.
	 *
	 * Caution!! Can return null.
	 * @param dateString The String to be turned into a Date Object.
	 * @return The Date Object of the date String param.
	 */
	public static Date formatToDate(String dateString) {
		return formatToDate(FORMAT_DEFAULT, dateString);
	}

	/**
	 * Caution!! Can return null.
	 * @param format String indicating to which format the dateString should be formatted to.
	 * @param dateString The date String to be formatted into a Date Object.
	 * @return The Date Object of the date String param.
	 */
	public static Date formatToDate(String format, String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			TILogger.getLog().error("Could not format: " + dateString + " to the format of: " + format + " in DateUtils.formatToDate()", e);
			return null;
		}
	}
	
	public static boolean isEmpty(String str) {
		return !notEmpty(str);
	}
	
	public static boolean notEmpty(String str) {
		return str != null && str.trim().length() > 0;
	}
	
	public static boolean isEmpty(List<?> list) {
		return !notEmpty(list);
	}
	
	public static boolean notEmpty(List<?> list) {
		return list != null && !list.isEmpty();
	}
	
	public static boolean isBoolean(Object obj) {
		String objStr = obj.toString().trim();
		return objStr.equalsIgnoreCase("true") || objStr.equals("1");
	}
	
	public static String capitalizeFirstLetter(String string) {
		if(string.length() > 1) {
            return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
        } else {
            return string.toUpperCase();
        }
	}
	
	public static <K, V> String mapToString(Map<K, V> map) {
		StringBuilder sb = new StringBuilder();
		
		Iterator<Entry<K, V>> itr = map.entrySet().iterator();
		boolean hasNext = itr.hasNext();
		while(hasNext) {
			Entry<K, V> entry = itr.next();
			sb.append(entry.getKey() + "=" + entry.getValue());
			
			hasNext = itr.hasNext();
			if(hasNext) {
				sb.append("&");
			}
		}
		
		return sb.toString();
	}
	
	public static String getIso2(User user) {
		CountryDao countryDao = SpringContextProvider.getCountryDao();
		Country country = null;
		
		Integer countryId = user.getCountryId();
		if(countryId != null) {
			country = countryDao.findById(countryId);
		}
		
		if(country == null) {
			String countryName = user.getCountry();
			if(countryName != null) {
				country = countryDao.findByName(countryName);
			}
		}
		
		if(country != null) {
			return country.getIso2();
		}
		return null;
	}
	
	public static PhoneNumber getPhoneNumber(User user) throws NumberParseException {
		String telephone = user.getTelephone();
		if(!telephone.startsWith("+")) {
			telephone = "+" + telephone;
		}
		
		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		return phoneUtil.parse(telephone, getIso2(user));
	}
	
	public static void saveLog(Log log) {
		LogDao logDao = SpringContextProvider.getLogDao();
		logDao.save(log);
	}
	
	public static String mapToString(Map<String, String> map, boolean encodeStrings) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		
		Iterator<Entry<String, String>> itr = map.entrySet().iterator();
		boolean hasNext = itr.hasNext();
		while(hasNext) {
			Entry<String, String> entry = itr.next();
			sb.append(entry.getKey()).append("="); 
			
			if(encodeStrings) {
				sb.append(URLEncoder.encode(entry.getValue(), "utf-8"));
			} else{
				sb.append(entry.getValue());
			}
			
			hasNext = itr.hasNext();
			if(hasNext) {
				sb.append("&");
			}
		}
		
		return sb.toString();
	}

	public static String MD5(String md5) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] array = md.digest(md5.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; ++i) {
			sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString();
	}

}
