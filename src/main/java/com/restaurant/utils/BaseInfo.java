package com.restaurant.utils;

import java.util.Calendar;

public class BaseInfo {
	public static String getSeason() {
		int seasonNumber = Calendar.getInstance().get(Calendar.MONTH);
		return seasonNumber >= 3 && seasonNumber <= 5 ? "春" : seasonNumber >= 6 && seasonNumber <= 8 ? "夏" : seasonNumber >= 9 && seasonNumber <= 11 ? "秋" : seasonNumber >= 12 && seasonNumber <=2 ? "冬" : "冬";
	}
}
