package com.htzhu;

import com.htzhu.factory.BankInfoFactory;
import com.htzhu.utils.BankCardUtils;
import com.htzhu.vo.BankInfoPattern;
import com.htzhu.vo.BankInfoReg;
import com.htzhu.vo.BankInfoVO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.Test;

/**
 * BankInfoTest
 *
 * @author htzhu
 * @date 2018/8/15 13:07
 **/
public class BankInfoTest {


	public static Map<String, String> cardTypeMap = new HashMap<String, String>();

	static {
		cardTypeMap.put("DC", "储蓄卡");
		cardTypeMap.put("CC", "信用卡");
		cardTypeMap.put("SCC", "准贷记卡");
		cardTypeMap.put("PC", "预付费卡");
	}

	/**
	 * 银行卡 bin 查询
	 */
	@Test
	public void testBankInfo() {
		String bankCard = "6227001658260141376";

		List<BankInfoPattern> bankInfos = BankInfoFactory.getBankInfoVOList();

		for (BankInfoPattern bankInfo : bankInfos) {
			for (BankInfoReg bankInfoReg : bankInfo.getPatterns()) {
				if (Pattern.compile(bankInfoReg.getReg()).matcher(bankCard).matches()) {
					BankInfoVO infoVO = new BankInfoVO();
					infoVO.setBankName(bankInfo.getBankName());
					infoVO.setBankCode(bankInfo.getBankCode());
					infoVO.setCardType(bankInfoReg.getCardType());
					infoVO.setCardTypeName(cardTypeMap.get(bankInfoReg.getCardType()));
					System.out.println(infoVO);
				}
			}
		}
	}

	/**
	 * 银行卡校验码校验
	 */
	@Test
	public void testCheckCode() {
		String bankCard = "6259650871772098";
		Assert.assertTrue(BankCardUtils.validateCheckCode(bankCard));
	}


}
