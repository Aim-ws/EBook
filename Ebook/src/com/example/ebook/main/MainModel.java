package com.example.ebook.main;

import java.util.ArrayList;
import java.util.List;

import com.example.ebook.main.adapter.MainAdapter;
import com.example.ebook.main.bean.EbookBean;

import android.content.Context;

public class MainModel implements IMainModel{
	private MainAdapter mAdapter;
	private List<EbookBean> beans;
	private Context mContext;
	/**
	 * @param mContext
	 */
	public MainModel(Context mContext) {
		super();
		this.mContext = mContext;
	}
	@Override
	public MainAdapter getMainAdapter() {
		// TODO Auto-generated method stub
		if (mAdapter == null) {
			mAdapter = new MainAdapter(getDatas(), mContext);
		}
		return mAdapter;
	}
	@Override
	public List<EbookBean> getDatas() {
		// TODO Auto-generated method stub
		if (beans == null) {
			beans = new ArrayList<EbookBean>();
		}
		return beans;
	}
	@Override
	public void setMainAdapter(MainAdapter adapter) {
		// TODO Auto-generated method stub
		this.mAdapter = adapter;
	}
	@Override
	public void setDatas(List<EbookBean> beans) {
		// TODO Auto-generated method stub
		this.beans = beans;
	}
	
	

}
