package com.example.ebook.main;

import java.util.List;

import com.example.ebook.main.adapter.MainAdapter;
import com.example.ebook.main.bean.EbookBean;

public interface IMainModel {
	
	MainAdapter getMainAdapter();
	
	List<EbookBean> getDatas();
	
	void setMainAdapter(MainAdapter adapter);
	
	void setDatas(List<EbookBean> beans);

}
