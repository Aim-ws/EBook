package com.example.ebook.file;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.ebook.file.adapter.FileManagerAdapter;

import android.content.Context;

public class FileManagerModel implements IFileManagerModel {
	private FileManagerAdapter managerAdapter;
	private ArrayList<HashMap<String, Object>> list;
	private Context mContext;

	public FileManagerModel(Context context) {
		// TODO Auto-generated constructor stub
		this.mContext = context;

	}

	@Override
	public FileManagerAdapter getFileManagerAdapter() {
		// TODO Auto-generated method stub
		if (managerAdapter == null) {
			managerAdapter = new FileManagerAdapter(getDatas(), mContext);
		}
		return managerAdapter;
	}

	@Override
	public ArrayList<HashMap<String, Object>> getDatas() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public void setFileManagerAdapter(FileManagerAdapter adapter) {
		// TODO Auto-generated method stub
		this.managerAdapter = adapter;
	}

	@Override
	public void setDatas(ArrayList<HashMap<String, Object>> data) {
		// TODO Auto-generated method stub
		if (list == null) {
			list = new ArrayList<HashMap<String,Object>>();
		}
		this.list.clear();
		this.list.addAll(data);
	}

	@Override
	public FileManagerAdapter createFileAdapter(Context context, ArrayList<HashMap<String, Object>> list) {
		// TODO Auto-generated method stub
		managerAdapter= new FileManagerAdapter(list, context);
		return managerAdapter;
	}

}
