package com.example.ebook.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class EBookDaoImpl implements EBookDao{
	private DBHelper helper;
	
	/**
	 * @param helper
	 */
	public EBookDaoImpl(Context context) {
		super();
		helper = DBHelper.getInstance(context);
	}

	@Override
	public void insertBook(String path) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("insert into book(book_path,create_time) values(?,?)",new Object[]{path,System.currentTimeMillis()});
		db.close();
		Log.i("EBookDaoImpl", "insert");
	}

	@Override
	public void deleteBook(String path) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("delete from book where book_path = " + path);
		db.close();
		Log.i("EBookDaoImpl", "delete");
	}

	@Override
	public List<String> getBooks() {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select * from book", null);
		while (cursor.moveToNext()) {
			String path = cursor.getString(cursor.getColumnIndex("book_path"));
			list.add(path);
		}
		return list;
	}

}
