package com.crm.autodesk.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Ranjitha
 *
 */

public class JavaUtility {
	
	/**
	 * 
	 * it is used to generate random number
	 * @int randomdata
	 * 
	 * 
	 */
	public int getRanDomNumber() {
		Random random = new Random();
		int intRandom=random.nextInt();
		return intRandom;
	}
	
	/**
	 * used to get system time and date in IST format
	 * @return
	 * 
	 */
public String getSystemDateAndTime(){
	Date date = new Date();
	return date.toString();
}

/**
 * used to get system date in yyyy-mm-dd format
 * @return
 * 
 */
public String getSystemDateWithFormat() {
	Date date = new Date();
	String dateAndTime = date.toString();
	String YYYY = dateAndTime.split(" ")[5];
	String DD = dateAndTime.split(" ")[2];
	int MM = date.getMonth()+1;
	String finalFormate = YYYY+"-"+MM+"-"+DD;
	return finalFormate;
	
}
}
