package com.example.ebook.main;

import java.util.ArrayList;

import com.example.ebook.MainActivity;
import com.example.ebook.file.FileManagerActivity;
import com.example.ebook.main.adapter.MainAdapter;
import com.example.ebook.main.bean.EbookBean;

import android.content.Intent;

public class MainPresenter {
	private IMainView mIMainView;
	private MainActivity mContext;
	private MainModel mainModel;

	/**
	 * @param mIMainView
	 */
	public MainPresenter(IMainView mIMainView) {
		super();
		this.mIMainView = mIMainView;
	}

	public void init(MainActivity context) {
		// TODO Auto-generated method stub
		this.mContext = context;
		mainModel = new MainModel(context);
		ArrayList<EbookBean> beans = new ArrayList<EbookBean>();
		beans.add(new EbookBean());
		beans.add(new EbookBean());
		beans.add(new EbookBean());
		beans.add(new EbookBean());
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

}
