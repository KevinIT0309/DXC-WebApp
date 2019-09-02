package com.techzone.springmvc.util;

import org.springframework.stereotype.Service;
import java.text.Normalizer;
import java.util.regex.Pattern;

@Service
public class ConvertUnicodeUtil {
	
	public String removeAccent(String s) {
		 String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		 Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		 return pattern.matcher(temp).replaceAll("").replace('đ','d').replace('Đ','D');
	}

}
