package com.htzhu.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PatternUtils
 *
 * @author htzhu
 * @date 2018/8/15 16:26
 **/
public class PatternUtils {

	/**
	 * 字符串数字校验
	 *
	 * @param num 被校验的字符串
	 * @return 字符串是否都是数字类型
	 */
	public static boolean checkNum(String num) {
		String numFormat = "\\d+";
		Pattern p = Pattern.compile(numFormat);
		Matcher m = p.matcher(num);
		return m.matches();
	}

}
