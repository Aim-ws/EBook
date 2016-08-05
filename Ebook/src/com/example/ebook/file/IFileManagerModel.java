package com.example.ebook.file;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.ebook.file.adapter.FileManagerAdapter;

import android.content.Context;

public interface IFileManagerModel {
	
	FileManagerAdapter getFileManagerAdapter();
	
	ArrayList<HashMap<String, Object>> getDatas();
	
	void setFileManagerAdapter(FileManagerAdapter adapter);
	
	void setDatas(ArrayList<HashMap<String, Object>> list);
	
	FileManagerAdapter createFileAdapter(Context context,ArrayList<HashMap<String, Object>> list);

}
