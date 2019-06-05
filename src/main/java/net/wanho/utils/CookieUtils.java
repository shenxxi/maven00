package net.wanho.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {
	
	public static Cookie getCookieByName(String name, Cookie[] cookies) {
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (name.equals(cookies[i].getName())) {
					return cookies[i];
				}
			}
		}
		return null;
	}
}
