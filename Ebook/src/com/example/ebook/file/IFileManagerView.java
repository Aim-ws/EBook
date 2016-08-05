package com.example.ebook.file;

import com.example.ebook.file.adapter.FileManagerAdapter;

public interface IFileManagerView {
	
	void updateView(FileManagerAdapter adapter);
	
	void updateView();
	
	void updateDir(String dirName,String path);

}
