package com.htzhu.factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.htzhu.utils.FileReadUtils;
import com.htzhu.vo.BankInfoPattern;
import java.util.List;

/**
 * BankInfoFactory
 *
 * @author htzhu
 * @date 2018/8/15 12:55
 **/
public class BankInfoFactory {

	private static final Gson gson = new GsonBuilder().create();

	private static List<BankInfoPattern> bankInfoVOList = null;

	public static List<BankInfoPattern> getBankInfoVOList() {
		if (bankInfoVOList == null) {
			synchronized (BankInfoFactory.class) {
				bankInfoVOList = create();
			}
		}
		return bankInfoVOList;
	}

	private static List<BankInfoPattern> create() {
		String json = FileReadUtils.readFileFromProject("bank-info.json");

		return gson.fromJson(json, new TypeToken<List<BankInfoPattern>>() {
		}.getType());
	}


}
