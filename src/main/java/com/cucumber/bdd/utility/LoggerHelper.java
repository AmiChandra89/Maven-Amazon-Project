package com.cucumber.bdd.utility;

import com.cucumber.bdd.utility.GenericUtility;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {
	private static boolean root = false;

	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class clas) {
		if (root) {
			return Logger.getLogger(clas);
		}
		PropertyConfigurator.configure(GenericUtility.getResourcePath("configs/log4j.properties"));
		root = true;
		return Logger.getLogger(clas);
	}
}
