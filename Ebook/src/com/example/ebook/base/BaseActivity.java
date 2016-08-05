package com.example.ebook.base;

import com.example.ebook.R;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class BaseActivity extends Activity {
	protected String TAG = BaseActivity.class.getSimpleName();
	private boolean isVisibleCustomActionBar = true;
	private RelativeLayout mActionBar;
	private TextView mActionBarTitle;
	private FrameLayout mActionBarBack;
	private FrameLayout mActionBarMenu;
	private ImageView mActionBarImageBack;
	private ImageView mActionBarImageMenu;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
		setContentView(LayoutInflater.from(getApplicationContext()).inflate(layoutResID, null));
	}

	@Override
	public void setContentView(View view) {
		// TODO Auto-generated method stub
		setContentView(view, null);
	}

	@Override
	public void setContentView(View view, LayoutParams params) {
		// TODO Auto-generated method stub
		boolean hasTitle = isCustomActionBarVisible();
		if (hasTitle) {
			requestWindowFeature(Window.FEATURE_CUSTOM_TITLE); // 自定义title
			if (params == null) {
				super.setContentView(view);
			} else {
				super.setContentView(view, params);
			}
			Window window = getWindow();
			window.setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.activity_action_bar); // 设置title
			initActionBar();
		} else {
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			if (params == null) {
				super.setContentView(view);
			} else {
				super.setContentView(view, params);
			}
		}
	}
	
	/**
	 * 设置TAG标签
	 * @param T
	 */
	protected void initDebugTAG(Class<?> T){
		TAG = T.getSimpleName();
	}

	/**
	 * 初始化ActionBar
	 */
	protected void initActionBar() {
		// TODO Auto-generated method stub
		mActionBar = (RelativeLayout) findViewById(R.id.id_action_bar);
		mActionBarBack = (FrameLayout) findViewById(R.id.iv_parent_back);
		mActionBarMenu = (FrameLayout) findViewById(R.id.iv_parent_menu);
		mActionBarImageBack = (ImageView) findViewById(R.id.iv_back);
		mActionBarImageMenu = (ImageView) findViewById(R.id.iv_menu);
		mActionBarTitle = (TextView) findViewById(R.id.tv_action_title);
		
		setActionBarMenuVisible(View.INVISIBLE);
		initViewClickListener();
	}

	private void initViewClickListener() {
		// TODO Auto-generated method stub
		mActionBarImageBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onClickActionBarBack(v);
			}
		});
		mActionBarImageMenu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onClickActionBarMenu(v);
			}
		});
	}

	protected void onClickActionBarMenu(View v) {
		// TODO Auto-generated method stub

	}

	protected void onClickActionBarBack(View v) {
		// TODO Auto-generated method stub

	}

	/**
	 * 是否显示ActionBar
	 * 
	 * @return the isVisibleCustomActionBar
	 */
	public boolean isCustomActionBarVisible() {
		return isVisibleCustomActionBar;
	}

	/**
	 * @param isVisibleCustomActionBar
	 *            the isVisibleCustomActionBar to set
	 */
	public void setCustomActionBarVisible(boolean isVisibleCustomActionBar) {
		this.isVisibleCustomActionBar = isVisibleCustomActionBar;
	}
	public void setCustomActionBarVisible(boolean isVisibleCustomActionBar,Class<?> T) {
		this.isVisibleCustomActionBar = isVisibleCustomActionBar;
		initDebugTAG(T);
	}

	/**
	 * @param mActionBar
	 *            the mActionBar to set
	 */
	public void setActionBarVisible(int visibility) {
		mActionBar.setVisibility(visibility);
	}

	/**
	 * @param mActionBarTitle
	 *            the mActionBarTitle to set
	 */
	public void setActionBarTitle(String mActionBarTitle) {
		this.mActionBarTitle.setText(mActionBarTitle);
	}

	/**
	 * 
	 * @param size
	 */
	public void setActionBarTitleSize(float size) {
		this.mActionBarTitle.setTextSize(size);
	}

	public void setActionBarTitleColor(int color) {
		this.mActionBarTitle.setTextColor(color);
	}

	public void setActionBarTitleColor(ColorStateList color) {
		this.mActionBarTitle.setTextColor(color);
	}

	/**
	 * @param mActionBarBack
	 *            the mActionBarBack to set
	 */
	public void setActionBarBackVisible(int visibility) {
		this.mActionBarBack.setVisibility(visibility);
	}

	/**
	 * @param mActionBarMenu
	 *            the mActionBarMenu to set
	 */
	public void setActionBarMenuVisible(int visibility) {
		this.mActionBarMenu.setVisibility(visibility);
	}

	/**
	 * @param mActionBarImageBack
	 *            the mActionBarImageBack to set
	 */
	public void setActionBarImageBack(int resId) {
		this.mActionBarImageBack.setImageResource(resId);
	}

	/**
	 * @param mActionBarImageMenu
	 *            the mActionBarImageMenu to set
	 */
	public void setActionBarImageMenu(int resId) {
		this.mActionBarImageMenu.setImageResource(resId);
	}

}
