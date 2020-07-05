package com.binvi.springboot.demo03.jdk.java.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/7/3 22:57
 */
public class DateTest {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat();
		String str = format.format(new Date());
		Date date = format.parse(str);
		System.out.println(str);
		System.out.println(date);
		String strr = "Wed Jul 03 23:34:00 CST 2019";
		Date now = new Date();// new Date(strr);
		System.out.println(now);
	}

}
