package me.ele.logan.admin.util;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class StringUtil extends StringUtils {

	/**
	* 返回一个对象的toString()
	* 
	* @param obj
	*            被处理的对象
	* @return 如果obj!=null 返回 obj.toString(),如果obj==null 返回 "";
	*/
	public static String notNullString(Object obj) {
		return obj == null ? "" : obj.toString();
	}

	/**
	 * 返回一个对象的toString()
	 * 
	 * @param obj
	 *            被处理的对象
	 * @param dft
	 *            当obj为null时的默认值
	 * @return 如果obj!=null 返回 obj.toString(),如果obj==null 返回 notNullString(dft);
	 */
	public static String notNullString(Object obj, Object dft) {
		return obj == null ? StringUtil.notNullString(dft) : obj.toString();
	}

	/**
	 * 去掉以 suffix 结尾的部分
	 * 
	 * @param original
	 *            原字符串
	 * @param suffix
	 *            后缀
	 * @return 返回去掉后缀的字符串
	 */
	public static String cutSuffix(String original, String suffix) {
		if (original == null) {
			return null;
		}
		if (original.endsWith(suffix)) {
			int pos = original.lastIndexOf(suffix);
			return original.substring(0, pos);
		}
		return original;
	}

	/**
	 * 
	 * <pre>
	 * 去掉以prefix开始的部分
	 * </pre>
	 *
	 * @param original
	 * @param prefix
	 * @return
	 */
	public static String cutPrefix(String original, String prefix) {
		if (original == null) {
			return null;
		}
		if (original.startsWith(prefix)) {
			int pos = original.indexOf(prefix);
			return original.substring(pos + 1, original.length());
		}
		return original;
	}

	/**
	 * 根据文本框的显示长度来输出相应的字符串,文本显示长度是中文1个占位,西文0.5个占位
	 * 
	 * @param original
	 *            原字串
	 * @param size
	 *            文本框的长度
	 * @return 结果字串
	 */
	public static String cutWithTextSize(String original, int size) {
		if (original == null) {
			return null;
		}
		if (size < 0) {
			return original;
		}
		if (size == 0) {
			return "";
		}

		if (original.length() > size * 2) {
			original = original.substring(0, size * 2);
		}
		int lenofByte = original.getBytes().length;
		char[] chars = original.toCharArray();
		int len = chars.length;
		while (lenofByte > size * 2) {
			if (chars[--len] > 256) {
				lenofByte -= 2;
			} else {
				lenofByte -= 1;
			}
		}
		return original.substring(0, len);
	}

	/**
	 * 字符串的首字符大写
	 * 
	 * @param original
	 *            原字符串
	 * @return 结果字串
	 */
	public static String upperCaseFirstCharacter(String original) {
		if (original == null) {
			return original;
		}
		if (original.equals("")) {
			return original;
		}
		char[] chrs = original.toCharArray();
		chrs[0] = Character.toUpperCase(chrs[0]);
		return new String(chrs);
	}

	/**
	 * 字符串的首字符小写
	 * 
	 * @param original
	 *            原字符串
	 * @return 结果字串
	 */
	public static String lowerCaseFirstCharacter(String original) {
		if (original == null) {
			return original;
		}
		if (original.equals("")) {
			return original;
		}
		char[] chrs = original.toCharArray();
		chrs[0] = Character.toLowerCase(chrs[0]);
		return new String(chrs);
	}

	/**
	 * 得到数据库中用来表识true和false的值
	 * 
	 * @param value
	 *            Boolean
	 * @return String
	 */
	public static String toSQLBooleanChar(Boolean value) {
		if (value == null) {
			return null;
		}
		if (value.booleanValue()) {
			return "Y";
		}
		return "N";
	}

	/**
	 * 解析字符串为boolean值
	 * 
	 * @param s
	 *            原字符串
	 * @param defaultValue
	 *            默认值
	 * @return 当 s=="true" 或 s=="yes" 时, 返回 true; 当 s==null, 返回 defaultValue;
	 *         否则, 返回 false;
	 */
	public static boolean parseBoolean(String s, boolean defaultValue) {
		boolean b = defaultValue;
		if (s != null) {
			if ("true".equalsIgnoreCase(s) || "yes".equalsIgnoreCase(s) || "y".equalsIgnoreCase(s)) {
				b = true;
			} else {
				b = false;
			}
		}
		return b;
	}

	/**
	 * 解析字符串为int值
	 * 
	 * @param s
	 *            原字符串
	 * @param defaultValue
	 *            默认值
	 * @return 当s可以被解析时,返回Integer.parseInt(s) 否则, 返回 defaultValue;
	 */
	public static int parseInt(String s, int defaultValue) {
		int i = defaultValue;
		try {
			i = Integer.parseInt(s);
		} catch (Exception ex) {
		}
		return i;
	}

	/**
	 * 解析字符串为long值
	 * 
	 * @param s
	 *            原字符串
	 * @param defaultValue
	 *            默认值
	 * @return 当s可以被解析时,返回Integer.parseInt(s) 否则, 返回 defaultValue;
	 */
	public static long parseLong(String s, long defaultValue) {
		long i = defaultValue;
		try {
			i = Long.parseLong(s);
		} catch (Exception ex) {
		}
		return i;
	}

	/**
	 * 解析字串为日期
	 * 
	 * @param s
	 *            String
	 * @return java.util.Date
	 * @throws java.text.ParseException
	 */
	public static java.util.Date parseDate(String s) throws java.text.ParseException {
		if (s == null) {
			return null;
		}
		java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT);
		return f.parse(s);
	}

	/**
	 * 解析字符串为float值
	 * 
	 * @param s
	 *            原字符串
	 * @param defaultValue
	 *            默认值
	 * @return 当s可以被解析时,返回Float.parseFloat(s) 否则, 返回 defaultValue;
	 */
	public static float parseFloat(String s, float defaultValue) {
		float i = defaultValue;
		try {
			i = Float.parseFloat(s);
		} catch (Exception ex) {
		}
		return i;
	}

	/**
	 * 解析字符串为double值
	 * 
	 * @param s
	 *            原字符串
	 * @param defaultValue
	 *            默认值
	 * @return 当s可以被解析时,返回Integer.parseInt(s) 否则, 返回 defaultValue;
	 */
	public static double parseDouble(String s, double defaultValue) {
		double i = defaultValue;
		try {
			i = Double.parseDouble(s);
		} catch (Exception ex) {
		}
		return i;
	}

	/**
	 * 将字符串转换为Integer对象
	 * 
	 * @param s
	 *            原字符串
	 * @return 当符合10进制整数,并且值不越界时,返回相应对象,否则返回null
	 */
	public static Integer toInteger(String s) {
		try {
			return Integer.valueOf(s);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 将字符串转换为Double对象
	 * 
	 * @param s
	 *            原字符串
	 * @return 当符合10进制浮点数,并且值不越界时,返回相应对象,否则返回null
	 */
	public static Double toDouble(String s) {
		try {
			return Double.valueOf(s);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 将字符串转换为Float对象
	 * 
	 * @param s
	 *            原字符串
	 * @return 当符合10进制浮点数,并且值不越界时,返回相应对象,否则返回null
	 */
	public static Float toFloat(String s) {
		try {
			return Float.valueOf(s);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 将字符串转换为Long对象
	 * 
	 * @param s
	 *            原字符串
	 * @return 当符合10进制整数,并且值不越界时,返回相应对象,否则返回null
	 */
	public static Long toLong(String s) {
		try {
			return Long.valueOf(s);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 将字符串转换为Boolean对象
	 * 
	 * @param s
	 *            原字符串
	 * @return 当 s=="true" 或 s=="yes" 时, 返回 Boolean.True; 否则, 返回 Boolean.False;
	 */
	public static Boolean toBoolean(String s) {
		if (s == null) {
			return null;
		}
		if ("true".equalsIgnoreCase(s) || "yes".equalsIgnoreCase(s) || "y".equalsIgnoreCase(s)) {
			return Boolean.TRUE;
		}
		Integer i = toInteger(s);
		if (i != null && i.intValue() > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public static BigDecimal toBigDecimal(String str) {
		try {
			return new BigDecimal(str);
		} catch (Exception ex) {
			return null;
		}

	}

	/**
	 * 字符串替换(在jdk1.4 中有实现,这里是对jdk1.4之前版本的支持);
	 * 
	 * @param str
	 *            原字符串
	 * @param target
	 *            被替换的字符串
	 * @param with
	 *            替换成的字符串
	 * @return 返回结果,当with为null时,被处理为空字符串;
	 */
	public static String replace(String str, String target, String with) {
		if (str == null) {
			return null;
		} else if (str.equals("")) {
			return "";
		} else if (target == null || target.equals("")) {
			return str;
		}
		if (with == null) {
			with = "";
		}
		int len = target.length();
		int pos = str.indexOf(target);
		if (pos == -1) {
			return str;
		} else {
			return str.substring(0, pos) + with + replace(str.substring(pos + len), target, with);
		}
	}

	/**
	 * 将 txt 文本以 HTML 格式输出,主要是对空格,换行和tab的替换,1tab=4空格
	 * 
	 * @param str
	 *            原字符串
	 * @return 格式化结果字符串, 当 str==null 时,返回""
	 */
	public static String htmlFormat(String str) {
		if (str == null) {
			return "";
		}
		char[] chars = str.toCharArray();
		int len = chars.length;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++) {
			if (chars[i] == 10) {
				sb.append("<br>");
			} else if (chars[i] == 32) {
				sb.append("&nbsp;");
			} else if (chars[i] == 9) {
				sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
			} else {
				sb.append(chars[i]);
			}
		}
		return sb.toString();
	}

	/**
	 * 得到字符串的字节数
	 * 
	 * @param str
	 *            字符串
	 * @return 字符串的字节数,str为null时返回0;
	 */
	public static int getByteCount(String str) {
		if (str == null) {
			return 0;
		}
		return str.getBytes().length;
	}

	/**
	 * 得到字符串的字符数
	 * 
	 * @param str
	 *            字符串
	 * @return 字符串的字符数,str为null时返回0;
	 */
	public static int getCharacterCount(String str) {
		if (str == null) {
			return 0;
		}
		return str.toCharArray().length;
	}

	/**
	 * 格式化输出日期
	 * 
	 * @param datetime
	 *            待格式化的日期
	 * @param pattern
	 *            格式化的样式,如 "yyyy.MM.dd 'at' hh:mm:ss z"
	 * @return 符合格式的字符串
	 * @see java.text.SimpleDateFormat.format(Date);
	 */
	public static String format(java.util.Date datetime, String pattern) {
		if (datetime == null) {
			return "";
		}
		SimpleDateFormat f = null;
		if (pattern != null) {
			f = new SimpleDateFormat(pattern);
		} else {
			f = new SimpleDateFormat();
		}
		return f.format(datetime);
	}

	/**
	 * 格式化输出日期
	 * 
	 * @param datetime
	 *            待格式化的日期
	 * @param pattern
	 *            格式化的样式,如 "yyyy.MM.dd 'at' hh:mm:ss z"
	 * @return 符合格式的字符串
	 * @see format(java.util.Date, String );
	 */
	public static String format(java.sql.Timestamp datetime, String pattern) {
		if (datetime == null) {
			return "";
		}
		return format(new java.util.Date(datetime.getTime()), pattern);
	}

	/**
	 * 格式化输出日期yyyymmdd
	 * 
	 * @param date
	 *            待格式化的日期
	 * @return 符合格式的字符串
	 */
	public static String format(java.util.Date date) {
		if (date == null) {
			return "";
		}
		String rs = format(date, "yyyy-MM-dd");
		rs = rs.replaceAll("-", "");
		return rs;
	}

	/**
	 * 格式化输出日期yyyymmdd
	 * 
	 * @param datetime
	 *            待格式化的日期
	 * @return 符合格式的字符串
	 */
	public static String format(java.sql.Timestamp datetime) {
		if (datetime == null) {
			return "";
		}
		return format(new java.util.Date(datetime.getTime()));
	}

	/**
	 * 格式化输出日期
	 * 
	 * @param datetime
	 *            待格式化的日期
	 * @param pattern
	 *            格式化的样式,如 "yyyy.MM.dd 'at' hh:mm:ss z"
	 * @return 符合格式的字符串
	 * @see format(java.util.Date, String );
	 */
	public static String format(java.util.Calendar datetime, String pattern) {
		if (datetime == null) {
			return "";
		}
		return format(datetime.getTime(), pattern);
	}

	/**
	 * 格式化输出数字
	 * 
	 * @param number
	 *            待格式化的数字
	 * @param pattern
	 *            格式化的样式,如 "$#,###"
	 * @return 符合格式的字符串
	 * @see java.text.DecimalFormat.format(long number);
	 */
	public static String format(long number, String pattern) {
		DecimalFormat f = null;
		if (pattern != null) {
			f = new DecimalFormat(pattern);
		} else {
			f = new DecimalFormat();
		}
		return f.format(number);
	}

	/**
	 * 格式化输出数字
	 * 
	 * @param number
	 *            待格式化的数字
	 * @param pattern
	 *            格式化的样式,如 "$#,###"
	 * @return 符合格式的字符串
	 * @see format(long, String);
	 */
	public static String format(Integer number, String pattern) {
		if (number == null) {
			return "";
		}
		return format(number.longValue(), pattern);
	}

	/**
	 * 格式化输出数字
	 * 
	 * @param number
	 *            待格式化的数字
	 * @param pattern
	 *            格式化的样式,如 "$#,###"
	 * @return 符合格式的字符串
	 * @see format(long, String);
	 */
	public static String format(int number, String pattern) {
		return format((long) number, pattern);
	}

	/**
	 * 格式化输出数字
	 * 
	 * @param number
	 *            待格式化的数字
	 * @param pattern
	 *            格式化的样式,如 "$#,###"
	 * @return 符合格式的字符串
	 * @see format(long, String);
	 */
	public static String format(Long number, String pattern) {
		if (number == null) {
			return "";
		}
		return format(number.longValue(), pattern);
	}

	/**
	 * 格式化输出数字
	 * 
	 * @param number
	 *            待格式化的数字
	 * @param pattern
	 *            格式化的样式,如 "#,##0.0#"
	 * @return 符合格式的字符串
	 * @see java.text.DecimalFormat.format(double);
	 */
	public static String format(double number, String pattern) {
		DecimalFormat f = null;
		if (pattern != null) {
			f = new DecimalFormat(pattern);
		} else {
			f = new DecimalFormat();
		}
		return f.format(number);
	}

	/**
	 * 格式化输出数字
	 * 
	 * @param number
	 *            待格式化的数字
	 * @param pattern
	 *            格式化的样式,如 "#,##0.0#"
	 * @return 符合格式的字符串
	 * @see format(Double, String)
	 */
	public static String format(Double number, String pattern) {
		if (number == null) {
			return "";
		}
		return format(number.doubleValue(), pattern);
	}

	/**
	 * 格式化输出数字
	 * 
	 * @param number
	 *            待格式化的数字
	 * @param pattern
	 *            格式化的样式,如 "#,##0.0#"
	 * @return 符合格式的字符串
	 * @see format(Double, String)
	 */
	public static String format(Float number, String pattern) {
		if (number == null) {
			return "";
		}
		return format(number.doubleValue(), pattern);
	}

	/**
	 * 格式化输出数字
	 * 
	 * @param number
	 *            待格式化的数字
	 * @param pattern
	 *            格式化的样式,如 "#,##0.0#"
	 * @return 符合格式的字符串
	 * @see format(Double, String)
	 */
	public static String format(float number, String pattern) {
		return format((double) number, pattern);
	}

	/**
	 * 将数组对象以字符串方式输出
	 * 
	 * @param objs
	 *            Object[]
	 * @param dlim
	 *            String 分隔符
	 * @return String
	 */
	//FIXME:该方法有问题，如果dlim 分隔符是多个字符，最后不能只sb.length() - 1
	public static String combine(Object[] objs, String dlim) {
		if (objs == null || objs.length == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < objs.length; i++) {
			sb.append(objs[i]).append(dlim);
		}
		return sb.substring(0, sb.length() - 1);
	}

	/**
	 * 将集合以字符串方式输出
	 * 
	 * @param col
	 *            Collection
	 * @param dlim
	 *            String 分隔符
	 * @return String
	 */
	@SuppressWarnings("rawtypes")
	//FIXME:该方法有问题，如果dlim 分隔符是多个字符，最后不能只sb.length() - 1
	public static String combine(Collection col, String dlim) {
		if (col == null || col.size() == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (Iterator iter = col.iterator(); iter.hasNext();) {
			sb.append((Object) iter.next()).append(dlim);
		}
		return sb.substring(0, sb.length() - 1);
	}

	@SuppressWarnings("rawtypes")
	//FIXME:该方法有问题，如果dlim 分隔符是多个字符，最后不能只sb.length() - 1
	public static String combine(Map map, String dlim) {
		if (map == null || map.size() == 0) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
			Object item = (Object) iter.next();
			sb.append(item).append(dlim);
		}
		return sb.substring(0, sb.length() - 1);
	}

	/**
	 * 判断一个字串是否为空字串, null或0长度
	 * 
	 * @param s
	 *            String
	 * @return boolean
	 */
	public static boolean isEmpty(String s) {
		if (s == null || s.trim().length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断一个字串是否为非空字串, null或0长度
	 *
	 * @param s
	 * @return
	 */
	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}

	/**
	 * 打印字符串的编码
	 * 
	 * @param s
	 *            String
	 * @param out
	 *            PrintStream
	 */
	public static void printStringCode(String s, java.io.PrintStream out) {
		if (s == null || s.length() == 0) {
			out.println("The String is empty");
			return;
		}
		out.print("The String is:");
		out.println(s);
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			out.print(Integer.toHexString((short) chars[i]));
			out.print(",");
		}
		out.println();
	}

	/**
	 * 得到本地编码的字符串
	 * 
	 * @param s
	 *            String
	 * @return String
	 */
	public static String nativeEncode(String s) {
		if (s == null) {
			return null;
		}
		try {
			return new String(s.getBytes("ISO-8859-1"));
		} catch (UnsupportedEncodingException ex) {
			return s;
		}
	}

	/**
	 * 本地编码转换为Unicode
	 * 
	 * @param s
	 *            String
	 * @return String
	 */
	public static String native2Unicode(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		byte[] buffer = new byte[s.length()];
		for (int i = 0; i < s.length(); i++) {
			buffer[i] = (byte) s.charAt(i);
		}
		return new String(buffer);
	}

	/**
	 * Unicode转本地编码
	 * 
	 * @param s
	 *            String
	 * @return String
	 */
	public static String unicode2Native(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		char[] buffer = new char[s.length() * 2];
		char c;
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 0x100) {
				c = s.charAt(i);
				byte[] buf = ("" + c).getBytes();
				buffer[j++] = (char) buf[0];
				buffer[j++] = (char) buf[1];
			} else {
				buffer[j++] = s.charAt(i);
			}
		}
		return new String(buffer, 0, j);
	}

	/**
	 * 金额转换所用方法 供NumToRMBStr调用
	 * 
	 * @param NumStr
	 *            String
	 * @return String
	 */
	public static String positiveIntegerToHanStr(String NumStr) { // 输入字符串必须正整数，只允许前导空格(必须右对齐)，不宜有前导零
		String hanDigiStr[] = new String[] { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };

		String hanDiviStr[] = new String[] { "", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万", "拾", "佰", "仟" };

		// String RMBStr = "";
		StringBuilder rmbStr = new StringBuilder();
		boolean lastzero = false;
		boolean hasvalue = false; // 亿、万进位前有数值标记
		int len, n;
		len = NumStr.length();
		if (len > 15) {
			return "数值过大!";
		}
		for (int i = len - 1; i >= 0; i--) {
			if (NumStr.charAt(len - i - 1) == ' ') {
				continue;
			}
			n = NumStr.charAt(len - i - 1) - '0';
			if (n < 0 || n > 9) {
				return "输入含非数字字符!";
			}
			if (n != 0) {
				if (lastzero) {
					// RMBStr += HanDigiStr[0]; // 若干零后若跟非零值，只显示一个零
					rmbStr.append(hanDigiStr[0]);
				}
				// 除了亿万前的零不带到后面
				// if( !( n==1 && (i%4)==1 && (lastzero || i==len-1) ) ) //
				// 如十进位前有零也不发壹音用此行
				if (!(n == 1 && (i % 4) == 1 && i == len - 1)) {
					// 十进位处于第一位不发壹音
					rmbStr.append(hanDigiStr[n]);
				}
				rmbStr.append(hanDiviStr[i]);// 非零值后加进位，个位为空
				hasvalue = true; // 置万进位前有值标记

			} else {
				if ((i % 8) == 0 || ((i % 8) == 4 && hasvalue)) { // 亿万之间必须有非零值方显示万
					rmbStr.append(hanDiviStr[i]);// “亿”或“万”
					hasvalue = false;
				}
			}
			if ((i % 8) == 0 || (i % 8) == 4) {
				hasvalue = false;
			}
			lastzero = (n == 0) && (i % 4 != 0); // 亿万前有零后不加零，如：拾万贰仟
		}

		if (rmbStr.length() == 0) {
			return hanDigiStr[0]; // 输入空字符或"0"，返回"零"
		}
		return rmbStr.toString();
	}

	/**
	 * 金额由数值型转为人民币大写
	 * 
	 * @param val
	 *            double
	 * @return String
	 */
	public static String numToRMBStr(double val) {
		String hanDigiStr[] = new String[] { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };

		String signStr = "";
		String tailStr = "";
		long fraction, integer;
		int jiao, fen;

		if (val < 0) {
			val = -val;
			signStr = "负";
		}
		if (val > 99999999999999.999 || val < -99999999999999.999) {
			return "数值位数过大!";
		}
		// 四舍五入到分
		long temp = Math.round(val * 100);
		integer = temp / 100;
		fraction = temp % 100;
		jiao = (int) fraction / 10;
		fen = (int) fraction % 10;
		if (jiao == 0 && fen == 0) {
			tailStr = "整";
		} else {
			tailStr = hanDigiStr[jiao];
			if (jiao != 0) {
				tailStr += "角";
			}
			if (integer == 0 && jiao == 0) {
				// 零圆后不写零几分
				tailStr = "";
			}
			if (fen != 0) {
				tailStr += hanDigiStr[fen] + "分";
			}
		}

		// 下一行可用于非正规金融场合，0.03只显示“叁分”而不是“零圆叁分”
		// if( !integer ) return SignStr+TailStr;

		return signStr + positiveIntegerToHanStr(String.valueOf(integer)) + "圆" + tailStr;
	}

	/**
	 * 将纯文本转换成html格式进行显示
	 * 
	 * @param text
	 * @return
	 */
	public static String textToHtml(String text) {
		if (isEmpty(text)) {
			return text;
		}
		text = StringEscapeUtils.escapeHtml(text);
		text = text.replaceAll(" ", "&nbsp;");
		text = text.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		text = text.replaceAll("\n", "<br />");
		return text;
	}

	/**
	 * 
	 * 将对象转换为指定长度的字符串,对象toString之后的长度小于length,则自动用defaultChar填充
	 * 
	 * @param o
	 * @param length
	 * @param defaultChar
	 * @return
	 */
	public static String convertToString(Object o, int length, String defaultChar) {
		String r = o.toString();
		int currentLength = r.length();
		if (currentLength < length) {
			StringBuffer sb = new StringBuffer(length);
			for (int i = 0; i < length - currentLength; i++) {
				sb.append(defaultChar);
			}
			sb.append(r);
			r = sb.toString();
		}
		return r;
	}

	/**
	 * 格式化输出日志
	 * @param logInfos
	 * @return
	 */
	public static String formatLog(Map<String, Object> logInfos) {
		String separator = System.getProperty("line.separator");
		StringBuffer formatInfos = new StringBuffer();
		if (null == logInfos || 0 == logInfos.size()) {
			return formatInfos.append("[]").append(separator).toString();
		}
		formatInfos.append("[");
		Set<String> attributes = logInfos.keySet();
		boolean flag = false;
		for (String attribute : attributes) {
			if (flag) {
				formatInfos.append(",");
				flag = true;
			}
			formatInfos.append(attribute).append(" = ").append(logInfos.get(attribute));
		}
		return formatInfos.append("]").append(separator).toString();
	}

	/**
	 * 取得一个字符串在另一个字符串中出现的次数
	 * @param source
	 * @param toFind
	 * @return
	 */
	public static int countStr(String source, String toFind) {
		if (source == null) {
			return 0;
		}
		int count = 0;
		int index = source.indexOf(toFind);
		while (index != -1) {
			source = source.substring(index + toFind.length());
			index = source.indexOf(toFind);
			count++;
		}
		return count;
	}

	/**
	 * 
	 * <pre>
	 * 在字符串中每隔一定长度(英文1个字符，中文2个字符)插入某个字符
	 * </pre>
	 *
	 * @param resource
	 * @param size
	 * @param insertStr
	 * @return
	 */
	public static String insertStr2Str(String resource, int size, String insertStr) {
		StringBuilder returnStr = new StringBuilder();

		char[] chars = resource.toCharArray();
		int i = 0;
		for (char c : chars) {
			returnStr.append(c);

			i = i + (c > 256 ? 2 : 1);
			if (i >= size) {
				returnStr.append(insertStr);
				i = 0;
			}
		}
		return returnStr.toString();
	}

	/**
	 * 
	 * <pre>
	 * 判断第一个参数是否等于后续的参数中的某一个
	 * </pre>
	 *
	 * @param value
	 * @param value1
	 * @param strs
	 * @return
	 */
	public static boolean isIn(String value, String... strs) {
		if (strs != null && strs.length > 0) {
			for (String str : strs) {
				if (str.equals(value)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * <pre>
	 * 判断第一个参数是否不等于后续的所有参数
	 * </pre>
	 *
	 * @param value
	 * @param value1
	 * @param strs
	 * @return
	 */
	public static boolean isNotIn(String value, String... strs) {
		return !isIn(value, strs);
	}

	/**
	 * 
	 * <pre>
	 * 将源string转成utf-8编码
	 * </pre>
	 *
	 * @param src 源字符串
	 * @return 转码后的字符串
	 */
	public static String stringToUtf8(String src) {
		if (isNotEmpty(src)) {
			/*
			 * 在现实环境中，使用的是utf-8环境，不采用此方法！
			try {
			    return new String(src.getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
			    System.out.println("The Character Encoding is not supported.");
			    e.printStackTrace();
			}*/
			return src;
		}
		return "";
	}

	/**
	 * 
	 * <pre>
	 * 将二进制形式的字符串转成对应的二进制值，以10进制形式返回，
	 * 如：输入101，则返回5。
	 * </pre>
	 *
	 * @param s
	 * @return
	 */
	public static Integer stringToBinValue(String s) {
		if (s == null) {
			return null;
		}

		int result = 0;
		int weight = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == '0') {
				weight = weight << 1;
			} else if (c == '1') {
				result += weight;
				weight = weight << 1;
			} else {
				return null;
			}
		}
		return result;
	}

	/**
	 * 
	 * <pre>
	 * 求出整数二进制值的字符串表述形式(仅支持非负数)
	 * </pre>
	 *
	 * @param i
	 * @param displayWidth 显示位数 不足高位补0
	 * @return
	 */
	public static String binValueToString(Integer i, Integer displayWidth) {
		if (i == null || i < 0) {
			return null;
		}
		StringBuilder result = new StringBuilder("");
		do {
			result.append(i % 2);
			i = i >> 1;
		} while (i != 0);

		if (displayWidth != null) {
			if (result.length() >= displayWidth) {
				return result.reverse().substring(result.length() - displayWidth);
			}

			for (int k = 0; k <= (displayWidth - result.length()); k++) {
				result.append("0");
			}
		}

		return result.reverse().toString();
	}

	/**
	 * 
	 * <pre>
	 * 替换掉模板中的占位符
	 * </pre>
	 *
	 * @param html
	 * @param placeholderResultArr
	 * @return
	 */
	public static String repalceHtml(String html, String[] placeholderResultArr) {
		for (int i = 0; i < placeholderResultArr.length; i++) {
			String result = placeholderResultArr[i];
			result = StringUtil.isBlank(result) ? "" : result;
			html = html.replace("{" + String.valueOf(i) + "}", result);
		}
		return html;
	}

	/**
	 * 
	 * <pre>
	 *去掉String数组中重复的字符串
	 * </pre>
	 *
	 * @param s
	 * @return
	 */
	public static String removeRepeat(String[] s) {
		HashSet<String> hs = new HashSet<String>();
		StringBuilder newString = new StringBuilder();
		for (int i = 0; i < s.length; i++) {
			if (hs.add(s[i])) {
				newString.append(s[i]).append(",");
			}
		}
		return cutSuffix(newString.toString(), ",");
	}

	public static String getNewLine() {
		return "\r\n";
	}

	/**
	 * 
	 * @param str
	 * @param separator 分隔符
	 * @return
	 */
	public static List<Long> strtoListLong(String str, String separator) {
		List<Long> idList = new ArrayList<Long>();
		if (StringUtils.isNotBlank(str)) {
			String[] arr = StringUtils.split(str, separator);
			for (String tempId : arr) {
				idList.add(Long.valueOf(tempId));
			}
		}
		return idList;
	}

    /**
     *
     * @param str
     * @param separator 分隔符
     * @return
     */
    public static List<String> strtoList(String str, String separator) {
        List<String> idList = new ArrayList<String>();
        if (StringUtils.isNotBlank(str)) {
            String[] arr = StringUtils.split(str, separator);
            for (String tempId : arr) {
                idList.add(String.valueOf(tempId));
            }
        }
        return idList;
    }

	/**
	 * <pre>
	 * list转化为 string,逗号分隔 
	 * </pre>
	 *
	 * @param src
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String listToString(List src) {
		StringBuffer returnValue = new StringBuffer("");
		if (CollectionUtil.isNotEmpty(src)) {
			for (Object s : src) {
				if (s != null) {
					returnValue.append(s.toString() + ",");
				}
			}
		}
		if (isNotEmpty(returnValue.toString())) {
			return returnValue.toString().substring(0, returnValue.toString().length() - 1);
		} else {
			return "";
		}
	}
}
