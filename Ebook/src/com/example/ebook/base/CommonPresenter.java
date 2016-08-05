package com.example.ebook.base;

public class CommonPresenter {
	protected String TAG = CommonPresenter.class.getSimpleName();
	/**
	 * …Ë÷√TAG±Í«©
	 * @param T
	 */
	protected void initDebugTAG(Class<?> T){
		TAG = T.getSimpleName();
	}

}
