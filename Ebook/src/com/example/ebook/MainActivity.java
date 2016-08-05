package com.example.ebook;

import com.example.ebook.base.BaseActivity;
import com.example.ebook.file.util.FileUtils;
import com.example.ebook.main.IMainView;
import com.example.ebook.main.MainPresenter;
import com.example.ebook.main.adapter.MainAdapter;
import com.example.ebook.main.bean.EbookBean;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends BaseActivity implements IMainView, OnItemClickListener{
	public static final int REQUEST_FILE = 0x01;
	private GridView mGridView;
	private MainPresenter mMainPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setCustomActionBarVisible(true);
		setContentView(R.layout.activity_main);
		setActionBarBackVisible(View.INVISIBLE);
		setActionBarMenuVisible(View.INVISIBLE);
		mGridView = (GridView) findViewById(R.id.gv);
		mGridView.setOnItemClickListener(this);
		
		mMainPresenter = new MainPresenter(this);
		mMainPresenter.init(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		mMainPresenter.onItemClick(position);
	}

	@Override
	public void updateView(MainAdapter adapter) {
		// TODO Auto-generated method stub
		mGridView.setAdapter(adapter);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REQUEST_FILE) {
			String path = data.getStringExtra("path");
			Log.i(TAG, path);
			EbookBean bean = new EbookBean();
			bean.name = FileUtils.getFileName(path);
			bean.path = path;
			mMainPresenter.getMainModel().getDatas().add(0, bean);
			mMainPresenter.getMainModel().getMainAdapter().notifyDataSetChanged();
		}
	}
	
}
