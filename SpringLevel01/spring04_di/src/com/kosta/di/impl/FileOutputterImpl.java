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
		//특정 파일로 message를 출력하는 기능을 작성
		try {
			FileWriter fw = new FileWriter(path);
			fw.write(message);
			fw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
