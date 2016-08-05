package com.example.ebook.file;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.ebook.MainActivity;
import com.example.ebook.base.CommonPresenter;
import com.example.ebook.file.adapter.FileManagerAdapter;
import com.example.ebook.file.util.FileConfig;
import com.example.ebook.file.util.FileUtils;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

public class FileManagerPresenter extends CommonPresenter {
	private IFileManagerView mIFileManagerView;
	private FileManagerModel mFileManagerModel;
	private FileManagerActivity mContext;

	public FileManagerPresenter(IFileManagerView fileManagerView) {
		// TODO Auto-generated constructor stub
		this.mIFileManagerView = fileManagerView;
		initDebugTAG(FileManagerPresenter.class);
	}

	public void init(FileManagerActivity context, String path) {
		// TODO Auto-generated method stub
		this.mContext = context;
		mFileManagerModel = new FileManagerModel(context);
		try {
			mFileManagerModel.setDatas(FileUtils.getFileLists(path));
			mFileManagerModel.setFileManagerAdapter(new FileManagerAdapter(mFileManagerModel.getDatas(), context));
			mIFileManagerView.updateView(mFileManagerModel.getFileManagerAdapter());
			mIFileManagerView.updateDir(FileUtils.getFileName(path), path);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void onItemClick(int position) {
		// TODO Auto-generated method stub
		try {
			HashMap<String, Object> map = mFileManagerModel.getDatas().get(position);
			String path = (String) map.get(FileConfig.PATH);
			int type = (Integer) map.get(FileConfig.TYPE);
			Log.i(TAG, path + "---" + type);
			if (type == FileConfig.FOLDER) {
				ArrayList<HashMap<String, Object>> arrayList = FileUtils.getFileLists(path);
				mFileManagerModel.getDatas().clear();
				mFileManagerModel.setDatas(arrayList);
				mIFileManagerView.updateDir(FileUtils.getFileName(path), path);
				mIFileManagerView.updateView();
			}
			if (type == FileConfig.UPTO) {
				String parent = FileUtils.getParentFilePath(FileConfig.CURRENT_DIR);
				Log.i(TAG, parent);
				if (!TextUtils.isEmpty(parent)) {
					ArrayList<HashMap<String, Object>> arrayList = FileUtils.getFileLists(parent);
					mFileManagerModel.getDatas().clear();
					mFileManagerModel.setDatas(arrayList);
					mIFileManagerView.updateDir(FileUtils.getFileName(parent), parent);
					mIFileManagerView.updateView();
				}
			}
			if (type == FileConfig.FILE) {
				Intent intent = new Intent(mContext, MainActivity.class);
				intent.putExtra("path", path);
				mContext.setResult(Activity.RESULT_OK, intent);
				mContext.finish();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public FileManagerModel getmFileManagerModel() {
		return mFileManagerModel;
	}

}
