package br.com.openvan.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {
	
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	public static List<Long> decodeIntList(String s) {
		String[] vet = s.split(",");
		List<Long> list = new ArrayList<>();

		for (int i = 0; i < vet.length; i++) {
			list.add((long) Integer.parseInt(vet[i]));
		}
		return list;
		//return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
	}

}
