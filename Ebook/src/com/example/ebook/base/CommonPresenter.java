package com.example.ebook.base;

public class CommonPresenter {
	protected String TAG = CommonPresenter.class.getSimpleName();
	/**
	 * ����TAG��ǩ
	 * @param T
	 */
	protected void initDebugTAG(Class<?> T){
		TAG = T.getSimpleName();
	}

}
