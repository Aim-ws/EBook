package com.example.ebook.db;

import java.util.List;

public interface EBookDao {
	
	void insertBook(String path);
	
	void deleteBook(String path);
	
	boolean existBook(String path);
	
	List<String> getBooks();

}
