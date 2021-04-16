package sn.unipro.gestionInscription.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static Date createDate(int day, int month, int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		return cal.getTime();
	}

}
