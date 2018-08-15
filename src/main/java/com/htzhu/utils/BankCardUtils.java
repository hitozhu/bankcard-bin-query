package com.htzhu.utils;

/**
 * BankCardUtils
 *
 * @author htzhu
 * @date 2018/8/15 16:25
 **/
public class BankCardUtils {
	/**
	 * 银行卡校验码校验，大部分银联卡都支持
	 * <pre>
	 *     1、获取银行卡校验码
	 *     2、从卡号右边第一位（最后一位校验码除外），每隔一位乘以 2 相加，在于未乘以 2 的数字相加
	 *     3、上一步的值得个位数求 10 的补数，即为校验码
	 * </pre>
	 *
	 * @param bankCard 银行卡
	 * @return 校验是否成功
	 */
	public static boolean validateCheckCode(String bankCard) {
		// 校验字符串是否都为数字
		if (!PatternUtils.checkNum(bankCard)) {
			return false;
		}
		// 1、获取银行卡校验码
		int checkCode = Integer.valueOf(bankCard.substring(bankCard.length() - 1));
		// 不含校验码的银行卡
		String cardNoCheckCode = bankCard.substring(0, bankCard.length() - 1);

		// 遍历以银行卡求和
		int sum = 0;
		for (int i = 0; i < cardNoCheckCode.length(); i++) {
			Integer temp = Integer.valueOf(
					cardNoCheckCode.substring(cardNoCheckCode.length() - i - 1, cardNoCheckCode.length() - i));
			if (i % 2 == 0) {
				temp *= 2;
				sum += temp % 10 + temp / 10;
			} else {
				sum += temp;
			}
		}
		int myCheckCode = sum % 10 == 0 ? 0 : 10 - (sum % 10);
		// 校验码匹配
		if (checkCode == myCheckCode) {
			return true;
		} else {
			return false;
		}
	}

}
