package me.ele.logan.admin.util;

import java.util.Collection;

public class CollectionUtil {

	public static boolean isNullOrEmpty(Collection<?> c) {
		return (null == c || c.isEmpty());
	}

	public static boolean isNotEmpty(Collection<?> c) {
		return (null != c && c.size() > 0);
	}
}
