package com.example.ebook.base;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

public abstract class CommonAdapter<T> extends BaseAdapter {
	public static String TAG = CommonAdapter.class.getSimpleName();
	protected LayoutInflater mInflater;
	protected List<T> mDatas;
	protected Context mContext;
	/**
	 * …Ë÷√TAG±Í«©
	 * @param T
	 */
	protected void initDebugTAG(Class<?> T){
		TAG = T.getSimpleName();
	}
	
	

	/**
	 * @param mDatas
	 * @param mContext
	 */
	public CommonAdapter(List<T> datas, Context context) {
		super();
		this.mDatas = datas;
		this.mContext = context;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDatas.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	

}
