package cn.ekgc.addrbook.util;

import java.security.MessageDigest;

/**
 * <b>MD5 加密工具类</>
 * @author
 * @version 5.0.0
 */
public class MD5Util {
	private static final String KEY_MD5 = "MD5";
	public static String encrypt(String message) {
			StringBuffer sb = new StringBuffer();
			try {
				MessageDigest mDigest = MessageDigest.getInstance(KEY_MD5);
				byte[] inputData = message.getBytes("UTF-8");
				byte[] encryptionData = mDigest.digest(inputData);
				for(int i = 0;i < encryptionData.length;i++) {
					int value = ((int) encryptionData[i]) & 0xff;
					if(value < 16) {
						sb.append("0");
					}
					sb.append(Integer.toHexString(value));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return sb.toString().toUpperCase();
	}

	public static void main(String[] args) {
		System.out.println(MD5Util.encrypt("123456"));
	}
}
