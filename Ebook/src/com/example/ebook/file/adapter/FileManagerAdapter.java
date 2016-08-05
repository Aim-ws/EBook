package com.example.ebook.file.adapter;

import java.util.HashMap;
import java.util.List;

import com.example.ebook.R;
import com.example.ebook.base.CommonAdapter;
import com.example.ebook.file.util.FileConfig;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FileManagerAdapter extends CommonAdapter<HashMap<String, Object>>{

	public FileManagerAdapter(List<HashMap<String, Object>> datas, Context context) {
		super(datas, context);
		// TODO Auto-generated constructor stub
		initDebugTAG(FileManagerAdapter.class);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.row_file_manager, null);
			viewHolder = new ViewHolder();
			viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_file);
			viewHolder.textView = (TextView) convertView.findViewById(R.id.tv_file);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		HashMap<String, Object> hashMap = mDatas.get(position);
		String name = (String) hashMap.get(FileConfig.NAME);
		int resId = (Integer) hashMap.get(FileConfig.ICON);
		viewHolder.textView.setText(name);
		viewHolder.imageView.setImageResource(resId);
		return convertView;
	}
	
	static class ViewHolder{
		ImageView imageView;
		TextView textView;
	}

}
