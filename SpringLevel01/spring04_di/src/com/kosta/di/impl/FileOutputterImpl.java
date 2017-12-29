package com.kosta.di.impl;

import java.io.FileWriter;
import java.io.IOException;

import com.kosta.di.Outputter;

public class FileOutputterImpl implements Outputter{
	private String path;
	
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public void output(String message) {
		//Ư�� ���Ϸ� message�� ����ϴ� ����� �ۼ�
		try {
			FileWriter fw = new FileWriter(path);
			fw.write(message);
			fw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
