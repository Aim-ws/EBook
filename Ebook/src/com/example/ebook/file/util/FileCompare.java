package com.example.ebook.file.util;

import java.util.Comparator;
import java.util.HashMap;

public class FileCompare implements Comparator<HashMap<String, Object>>{

	@Override
	public int compare(HashMap<String, Object> lhs, HashMap<String, Object> rhs) {
		// TODO Auto-generated method stub
		String n1= (String) lhs.get(FileConfig.NAME);
        String n2= (String) rhs.get(FileConfig.NAME);
        return n1.toUpperCase().compareTo(n2.toUpperCase());
	}

}
