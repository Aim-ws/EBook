package com.example.ebook.main;

import java.util.ArrayList;
import java.util.List;

import com.example.ebook.MainActivity;
import com.example.ebook.base.CommonPresenter;
import com.example.ebook.db.EBookDaoImpl;
import com.example.ebook.file.FileManagerActivity;
import com.example.ebook.file.util.FileUtils;
import com.example.ebook.main.adapter.MainAdapter;
import com.example.ebook.main.bean.EbookBean;

import android.content.Intent;
import android.util.Log;

public class MainPresenter extends CommonPresenter{
	private IMainView mIMainView;
	private MainActivity mContext;
	private MainModel mainModel;
	private EBookDaoImpl mDaoImpl;

	/**
	 * @param mIMainView
	 */
	public MainPresenter(IMainView mIMainView) {
		super();
		this.mIMainView = mIMainView;
		initDebugTAG(MainPresenter.class);
	}

	public void init(MainActivity context) {
		// TODO Auto-generated method stub
		this.mContext = context;
		mainModel = new MainModel(context);
		mDaoImpl = new EBookDaoImpl(context);
		List<String> list = mDaoImpl.getBooks();
		ArrayList<EbookBean> beans = new ArrayList<EbookBean>();
		for (String path : list) {
			EbookBean bean = new EbookBean();
			bean.path = path;
			bean.name = FileUtils.getFileName(path);
			beans.add(bean);
			bean = null;
		}
		mainModel.setDatas(beans);
		mainModel.setMainAdapter(new MainAdapter(beans, context));
		mIMainView.updateView(mainModel.getMainAdapter());

	}

	public void onItemClick(int position) {
		// TODO Auto-generated method stub
		int count = mainModel.getDatas().size();
		if (position == count) {
			Intent intent = new Intent(mContext, FileManagerActivity.class);
			mContext.startActivityForResult(intent, MainActivity.REQUEST_FILE);
		}
	}

	public MainModel getMainModel() {
		return mainModel;
	}

	public EBookDaoImpl getmDaoImpl() {
		return mDaoImpl;
	}

	public void addEBook(Intent data) {
		// TODO Auto-generated method stub
		try {
			String path = data.getStringExtra("path");
			Log.i(TAG, path);
			EbookBean bean = new EbookBean();
			bean.name = FileUtils.getFileName(path);
			bean.path = path;
			mainModel.getDatas().add(0, bean);
			mainModel.getMainAdapter().notifyDataSetChanged();
			if (!mDaoImpl.existBook(path)) {
				mDaoImpl.insertBook(path);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	

}
