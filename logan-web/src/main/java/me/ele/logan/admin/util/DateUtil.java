package me.ele.logan.admin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

	public static final String default_pattern = "yyyy-MM-dd HH:mm:ss";
	public static final String default_pattern_minutes = "yyyyMMddHHmm";
	public static final String default_pattern_ms = "yyyyMMddHHmmssSSS";
	private static final Pattern PARSE_DAYS = Pattern.compile("^([0-9]+)d$");
	private static final Pattern PARSE_HOURS = Pattern.compile("^([0-9]+)h$");
	private static final Pattern PARSE_MINUTES = Pattern.compile("^([0-9]+)mi?n$");
	private static final Pattern PARSE_SECONDS = Pattern.compile("^([0-9]+)s$");

	// 根据yyyyMMddHHmmssSSS将date类型转化为string
	public static String defaultFormatMSDate(Date date) {
		if (null == date)
			return null;
		return getDate(date, default_pattern_ms);
	}

	// 根据yyyyMMddHHmm将date类型转化为string
	public static String defaultFormatMinutesDate(Date date) {
		if (null == date)
			return null;
		return getDate(date, default_pattern_minutes);
	}

	// 根据yyyy-MM-dd HH:mm:ss 将date类型转化为string
	public static String defaultFormatDate(Date date) {
		if (null == date)
			return null;
		return getDate(date, default_pattern);
	}

	public static String getDate(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 字符串转换成日期
	 * 
	 * @param str
	 * @return date
	 * @return formatStr
	 * @throws java.text.ParseException
	 */
	public static Date strToDate(String str, String formatStr) throws ParseException {
		if (formatStr == null) {
			formatStr = "yyyy-MM-dd";
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return format.parse(str);
	}

	/**
	 * 字符串转换成日期时间
	 *
	 * @param str
	 * @return date
	 * @throws java.text.ParseException
	 */
	public static Date strToDateTime(String str) throws ParseException {
		return strToDateTime(str, null);
	}

	/**
	 * 字符串转换成日期时间
	 *
	 * @param str
	 * @return date
	 * @return formatStr
	 * @throws java.text.ParseException
	 */
	public static Date strToDateTime(String str, String formatStr) throws ParseException {
		if (formatStr == null) {
			formatStr = default_pattern;
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return format.parse(str);
	}

	/**
	 * 
	 * 设置给定日期的时分秒
	 * 
	 * @param c
	 *            需要调整的日期
	 * @param hour
	 *            设定的小时值
	 * @param minute
	 *            设定的分钟值
	 * @param second
	 *            设定的秒值
	 * 
	 */
	public static void setHMS(Calendar c, int hour, int minute, int second) {
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, minute);
		c.set(Calendar.SECOND, second);
	}

	/**
	 * 
	 * 设置给定日期的时分秒毫秒
	 * 
	 * @param c
	 *            需要调整的日期
	 * @param hour
	 *            设定的小时值
	 * @param minute
	 *            设定的分钟值
	 * @param second
	 *            设定的秒值
	 * @param milliSecond
	 *            设定的毫秒秒值
	 */
	public static void setHMSM(Calendar c, int hour, int minute, int second, int milliSecond) {
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, minute);
		c.set(Calendar.SECOND, second);
		c.set(Calendar.MILLISECOND, milliSecond);
	}

	/**
	 * 
	 * <pre>
	 * 取得N天前的日期
	 * </pre>
	 * 
	 * @param days
	 * @return
	 */
	public static Date getDateBefore(int days) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -days);
		setHMSM(c, 0, 0, 0, 0);
		return c.getTime();
	}

	/**
	 * 
	 * <pre>
	 * 取得N天后的日期
	 * </pre>
	 * 
	 * @param days
	 * @return
	 */
	public static Date getDateAfterDay(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		setHMSM(c, 0, 0, 0, 0);
		return c.getTime();
	}

	/**
	 * 取得某天前 x天、y小时、z分钟、s的日期
	 * 
	 * @param date
	 * @param day
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	public static Date getDateBefore(Date date, int day, int hour, int minute, int second) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, -day);
		c.add(Calendar.HOUR_OF_DAY, -hour);
		c.add(Calendar.MINUTE, -minute);
		c.add(Calendar.SECOND, -second);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 
	 * <pre>
	 * 取得当天日期
	 * </pre>
	 * 
	 * @return
	 */
	public static Date getToday() {
		Calendar c = Calendar.getInstance();
		setHMSM(c, 0, 0, 0, 0);
		return c.getTime();
	}

	/**
	 * 
	 * <pre>
	 * 取得当天日期
	 * </pre>
	 * 
	 * @return
	 */
	public static Date getTodayHHmmss() {
		Calendar c = Calendar.getInstance();
		return c.getTime();
	}

	/**
	 * 
	 * <pre>
	 * 取得明天日期
	 * </pre>
	 * 
	 * @return
	 */
	public static Date getTomorrow() {
		return getDateBefore(-1);
	}

	/**
	 * 时间转换
	 * 
	 * @param d
	 * @return
	 */
	public static Date addHour(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.HOUR, 23);
		c.add(Calendar.MINUTE, 59);
		c.add(Calendar.SECOND, 59);
		return c.getTime();
	}

	public static boolean isSameYearMonthDay(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);
		int year1 = c1.get(Calendar.YEAR);
		int year2 = c2.get(Calendar.YEAR);
		int month1 = c1.get(Calendar.MONTH);
		int month2 = c2.get(Calendar.MONTH);
		int day1 = c1.get(Calendar.DAY_OF_MONTH);
		int day2 = c2.get(Calendar.DAY_OF_MONTH);
		if (year1 == year2 && month1 == month2 && day1 == day2) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * 获得当月天数
	 */
	public static int getDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	public static int getNowDay() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DATE);
	}

	/**
	*
	* <pre>
	* 取得N月后的日期
	* </pre>
	*
	* @param days
	* @return
	*/
	public static Date getDateAfter(int months) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, months);
		setHMSM(c, 0, 0, 0, 0);
		return c.getTime();
	}

	/**
	*
	* <pre>
	* 取得当月1日
	* </pre>
	*
	* @return
	*/
	public static Date getMonthFirstDay() {
		Calendar c = Calendar.getInstance();
		setHMSM(c, 0, 0, 0, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}

	/**
	 * 
	 * <pre>
	 * 取得当月16日
	 * </pre>
	 *
	 * @return
	 */
	public static Date getMonthSixteenDay() {
		Calendar c = Calendar.getInstance();
		setHMSM(c, 0, 0, 0, 0);
		c.set(Calendar.DAY_OF_MONTH, 16);
		return c.getTime();
	}

	/**
	*
	* <pre>
	* 取得下个月1日
	* </pre>
	*
	* @return
	*/
	public static Date getNextMonthFirstDay() {
		Calendar c = Calendar.getInstance();
		setHMSM(c, 0, 0, 0, 0);
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}

	/**
	 *
	 * <pre>
	 * 取得下个月16日
	 * </pre>
	 *
	 * @return
	 */
	public static Date getNextMonthSixteenDay() {
		Calendar c = Calendar.getInstance();
		setHMSM(c, 0, 0, 0, 0);
		c.add(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 16);
		return c.getTime();
	}

	/**
	 *
	 * <pre>
	 * 取得N月后的当天日期
	 * </pre>
	 *
	 * @param days
	 * @return
	 */
	public static Date getNowDateAfter(int months, Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, months);
		setHMSM(c, 0, 0, 0, 0);
		return c.getTime();
	}

	/**
	 * 截取日期yyyy-mm-dd
	 * @param date
	 * @return
	 */
	public static Date formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			return date;
		}
	}

	/**
	 * 增加时间
	 * 
	 * @param date
	 * @param field
	 * @param amount
	 * @return
	 */
	public static Date add(Date date, Integer field, Integer amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}

	/**
	 * 增加时间
	 * 
	 * @param date
	 * @param duration
	 * @return
	 */
	public static Date add(Date date, String duration) {
		return add(date, Calendar.SECOND, parseDuration(duration));
	}

	/**
	 * 解析持续时间<br>
	 * 样例：3d, 4h, 5mn, 6s
	 * 
	 * @param duration
	 * @return
	 */
	public static int parseDuration(String duration) {
		// 初始化
		if (StringUtil.isEmpty(duration))
			duration = "30d";
		Matcher matcher = null;

		// 判断周期类型并转换成秒数
		if ((matcher = PARSE_DAYS.matcher(duration)).matches()) {
			return Integer.parseInt(matcher.group(1)) * 60 * 60 * 24;
		} else if ((matcher = PARSE_HOURS.matcher(duration)).matches()) {
			return Integer.parseInt(matcher.group(1)) * 60 * 60;
		} else if ((matcher = PARSE_MINUTES.matcher(duration)).matches()) {
			return Integer.parseInt(matcher.group(1)) * 60;
		} else if ((matcher = PARSE_SECONDS.matcher(duration)).matches()) {
			return Integer.parseInt(matcher.group(1));
		} else {
			throw new IllegalArgumentException("invalid duration pattern '" + duration + "'.");
		}
	}

	/**
	 * <pre>
	 * 根据传入的日期得到天
	 * </pre>
	 *
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		return dayOfMonth;
	}

    public static String getWeek(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public static long getNow12() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTimeInMillis();
    }

    public static boolean isTomorrow(Date date) {
        Calendar today = Calendar.getInstance();
        Calendar old = Calendar.getInstance();
        old.setTime(date);

        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        old.set(Calendar.HOUR_OF_DAY, 0);
        old.set(Calendar.MINUTE, 0);
        old.set(Calendar.SECOND, 0);
        old.set(Calendar.MILLISECOND, 0);

        long intervalMilli = old.getTimeInMillis() - today.getTimeInMillis();
        int xcts = (int) (intervalMilli / (24 * 60 * 60 * 1000));
        if (1 >= xcts) {
            return true;
        }
        return false;

    }
}
