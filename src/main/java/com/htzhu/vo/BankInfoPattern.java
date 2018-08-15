package com.htzhu.vo;

import java.util.List;
import lombok.Data;

/**
 * BankInfoVO
 *
 * @author htzhu
 * @date 2018/8/15 12:52
 **/
@Data
public class BankInfoPattern {

	private String bankName;
	private String bankCode;
	private List<BankInfoReg> patterns;

}
