package ui;

import org.apache.commons.lang.StringUtils;

public class UiUtils {

	public static boolean isSmallLength(String name, String fieldName, int length) {
		// TODO Auto-generated method stub
		if (name==null){
			return true;
		}
		
		if (length < name.length()){
			System.out.printf("%s는 %s문자 이하로  입력해주세요.%n", fieldName,length);
			return false;
		}
		return true;
	}

	public static boolean isNumeric(String str, String fieldName) {
		// TODO Auto-generated method stub
		if (!StringUtils.isNumeric(str)){
			System.out.printf("%s는 숫자로 입력해 주세요.%n",fieldName);
			return false;
		}
		return true;
	}

}