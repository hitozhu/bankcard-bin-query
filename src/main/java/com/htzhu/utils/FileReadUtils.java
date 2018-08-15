package com.htzhu.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import lombok.extern.slf4j.Slf4j;

/**
 * FileReadUtils
 *
 * @author htzhu
 * @date 2018/8/15 12:57
 **/
@Slf4j
public class FileReadUtils {

	/**
	 * 从项目中读取文件
	 *
	 * @param fileName 文件名
	 * @return 文件内容
	 */
	public static String readFileFromProject(String fileName) {
		InputStream is = FileReadUtils.class.getClassLoader().getResourceAsStream(fileName);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader reader = new BufferedReader(isr);

		StringBuffer sb = new StringBuffer(64);
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			log.error("ReadFileUtils#readFile: read file error {}", fileName);
			return sb.toString();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
		return sb.toString();
	}

}
