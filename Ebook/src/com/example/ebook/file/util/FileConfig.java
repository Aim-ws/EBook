package com.example.ebook.file.util;

import android.os.Environment;

public class FileConfig {
	public static final String ICON = "icon";
	public static final String NAME = "name";
	public static final String PATH = "path";
	public static final String TYPE = "type";
	
	public static final int FILE = 1;
	public static final int FOLDER = 2;
	public static final int UPTO = 3;
	public static final int ROOT = 4;
	
	public static String ROOT_DIR = "/";
	public static String CURRENT_DIR = Environment.getExternalStorageDirectory().getAbsolutePath();

}
