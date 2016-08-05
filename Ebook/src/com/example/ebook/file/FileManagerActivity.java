package com.example.ebook.file;

import com.example.ebook.R;
import com.example.ebook.base.BaseActivity;
import com.example.ebook.file.adapter.FileManagerAdapter;
import com.example.ebook.file.util.FileConfig;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class FileManagerActivity extends BaseActivity implements IFileManagerView, OnItemClickListener{
	private TextView tv_dir;
	private ListView mListView;
	private FileManagerPresenter mFileManagerPresenter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initDebugTAG(FileManagerActivity.class);
		try {
			Log.i(TAG, "打开本地书籍");
			setCustomActionBarVisible(true);
			setContentView(R.layout.activity_file_manager);
			setActionBarBackVisible(View.VISIBLE);
			setActionBarMenuVisible(View.INVISIBLE);
			setActionBarTitle("打开本地书籍");
			
			tv_dir = (TextView) findViewById(R.id.tv_dirname);
			mListView = (ListView) findViewById(R.id.lv);
			mFileManagerPresenter = new FileManagerPresenter(this);
			FileConfig.CURRENT_DIR = FileConfig.ROOT_DIR;
			mFileManagerPresenter.init(this,FileConfig.CURRENT_DIR);
			
			mListView.setOnItemClickListener(this);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
				
	}

	@Override
	public void updateView(FileManagerAdapter adapter) {
		// TODO Auto-generated method stub
		mListView.setAdapter(adapter);
	}

	@Override
	public void updateView() {
		// TODO Auto-generated method stub
		mFileManagerPresenter.getmFileManagerModel().getFileManagerAdapter().notifyDataSetChanged();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		mFileManagerPresenter.onItemClick(position);
	}

	@Override
	public void updateDir(String dirName, String path) {
		// TODO Auto-generated method stub
		FileConfig.CURRENT_DIR = path;
		tv_dir.setText(path);
	}
	
	@Override
	protected void onClickActionBarBack(View v) {
		// TODO Auto-generated method stub
		super.onClickActionBarBack(v);
		onBackPressed();
	}
	
}
