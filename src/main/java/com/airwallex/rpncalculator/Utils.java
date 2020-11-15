package com.airwallex.rpncalculator;

import java.io.InputStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Utils {
	private static Logger logger = LoggerFactory.getLogger(Utils.class);
	
	public static final String UNARY = "unary";
	public static final String BINARY = "binary";
	public static final String FUNCTIONAL = "functional";
	
	public static final String ADD = "+";
	public static final String SUBTRACT = "-";
	public static final String MULTIPLY = "*";
	public static final String DIVIDE = "/";
	
	public static final String SQRT = "sqrt";
	public static final String UNDO = "undo";
	public static final String CLEAR = "clear";
	
	private static InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream("config/config.properties"); 
	private static Properties properties = new Properties();
	
	static {
		try {
			properties.load(inputStream);
		} catch (Exception e) {
			logger.error(e.toString());
			System.exit(1);
		}
	}
	
	public static Double toDouble(String element) {
		try {
			return Double.valueOf(element);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * Format a Double number to a string, only keeping 10 decimal places (or less if it causes no loss of precision).
	 * @param num The Double number to format.
	 * @return Formatted string.
	 */
	public static String formatNumber(Double num) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##########");
		decimalFormat.setRoundingMode(RoundingMode.DOWN);
		return decimalFormat.format(num);
	}
	
	public static String getValueFromConfigFile(String key) {
		String value = properties.getProperty(key);
		
		if (value == null) {
			throw new RuntimeException("Key '" + key + "' not found in config file");
		}
		
		return value;
	}

}
