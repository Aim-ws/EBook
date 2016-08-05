package com.example.ebook.main.adapter;

import java.util.List;

import com.example.ebook.R;
import com.example.ebook.base.CommonAdapter;
import com.example.ebook.file.util.FileUtils;
import com.example.ebook.main.bean.EbookBean;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends CommonAdapter<EbookBean>{

	public MainAdapter(List<EbookBean> datas, Context context) {
		super(datas, context);
		// TODO Auto-generated constructor stub
		initDebugTAG(MainAdapter.class);
	}
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDatas.size() + 1;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.row_main, null);
			viewHolder = new ViewHolder();
			viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_image);
			viewHolder.textView = (TextView) convertView.findViewById(R.id.tv_name);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		if (position == mDatas.size()) {
			viewHolder.imageView.setImageResource(R.drawable.ic_menu_selectall_holo_light);
			viewHolder.textView.setVisibility(View.INVISIBLE);
		}else{
			viewHolder.imageView.setImageResource(R.drawable.default_cover);
			viewHolder.textView.setVisibility(View.VISIBLE);
		}
		try {
			if (position < mDatas.size()) {
				EbookBean bean = mDatas.get(position);
				if (bean!=null) {
					String name = bean.name;
					if (!TextUtils.isEmpty(name)) {
						Log.i(TAG, name);
						viewHolder.textView.setText(FileUtils.getFileNameNoEx(name));
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return convertView;
	}
	
	static class ViewHolder{
		ImageView imageView;
		TextView textView;
	}

}
