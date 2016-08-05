package com.example.ebook.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	private static final String DATA_NAME = "ebook.db";
	private static final int VERSION = 1;
	private static final String CREATE_EBOOK = "create table book(_id integer primary key autoincrement,book_path text,create_time long)";
	private static DBHelper instance;

	public DBHelper(Context context) {
		super(context, DATA_NAME, null, VERSION);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 获取DBHelper对象 单利模式
	 * 
	 * @return
	 */
	public static DBHelper getInstance(Context context) {
		if (instance == null) {
			instance = new DBHelper(context);
		}
		return instance;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_EBOOK);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
