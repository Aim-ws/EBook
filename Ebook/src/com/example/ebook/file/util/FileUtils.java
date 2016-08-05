package com.example.ebook.file.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.example.ebook.R;

import android.text.TextUtils;

public class FileUtils {
	private static FileCompare fileCompare = new FileCompare();

	public static ArrayList<HashMap<String, Object>> getFileLists(String path) {
		ArrayList<HashMap<String, Object>> dirs = new ArrayList<HashMap<String, Object>>();
		ArrayList<HashMap<String, Object>> files = new ArrayList<HashMap<String, Object>>();
		File firFile = new File(path);
		if (firFile.exists()) {
			if (firFile.isDirectory()) {
				if (!path.equals(FileConfig.ROOT_DIR)) {
					HashMap<String, Object> value = new HashMap<String, Object>();
					value.put(FileConfig.ICON, R.drawable.arrow_back);
					value.put(FileConfig.NAME, "...返回上一级");
					value.put(FileConfig.PATH, path);
					value.put(FileConfig.TYPE, FileConfig.UPTO);
					dirs.add(value);
					value = null;
				}

				File[] files2 = firFile.listFiles();
				if (files2 == null) {
					return dirs;
				}
				for (File file : files2) {
					String file_path = file.getAbsolutePath();
					String file_name = getFileName(file_path);

					/**
					 * 隐藏文件处理
					 */
					if (isHitFiles(file_name)) {
						continue;

					}

					if (file.isDirectory()) {
						HashMap<String, Object> value = new HashMap<String, Object>();
						value.put(FileConfig.ICON, R.drawable.folder);
						value.put(FileConfig.NAME, file_name);
						value.put(FileConfig.PATH, file_path);
						value.put(FileConfig.TYPE, FileConfig.FOLDER);
						dirs.add(value);
						value = null;
					} else {
						String last_name = getFileLastName(file_name);
						int type = getFileType(last_name);
						if (type == 1) {
							HashMap<String, Object> value = new HashMap<String, Object>();
							value.put(FileConfig.ICON, R.drawable.txt);
							value.put(FileConfig.NAME, file_name);
							value.put(FileConfig.PATH, file_path);
							value.put(FileConfig.TYPE, FileConfig.FILE);
							files.add(value);
							value = null;
						}
					}
				}
				Collections.sort(files, fileCompare);
				Collections.sort(dirs, fileCompare);
				dirs.addAll(files);
			}
		}
		return dirs;

	}

	private static boolean isHitFiles(String file_path) {
		// TODO Auto-generated method stub
		return file_path.substring(0, 1).equals(".");
	}

	public static int getFileType(String file_name) {
		// TODO Auto-generated method stub
		if (TextUtils.isEmpty(file_name)) {
			return -1;
		}
		if ("txt".equals(file_name)) {
			return 1;
		}
		return -1;
	}

	public static String getFileLastName(String file_name) {
		// TODO Auto-generated method stub
		if (!file_name.contains(".")) {
			return "";
		}
		return file_name.substring(file_name.lastIndexOf(".") + 1);
	}

	public static String getFileName(String file_path) {
		// TODO Auto-generated method stub
		return file_path.substring(file_path.lastIndexOf('/') + 1, file_path.length());
	}

	public static String getParentFilePath(String path) {
		// TODO Auto-generated method stub
		File file = new File(path);
		if (file.exists()) {
			return file.getParent();
		}
		return null;
	}

	/**
	 * 
	 * @param filename
	 * @return
	 */
	public static String getFileNameNoEx(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length()))) {
				return filename.substring(0, dot);
			}
		}
		return filename;
	}

}
