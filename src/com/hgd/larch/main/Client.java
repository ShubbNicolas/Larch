package com.hgd.larch.main;

import com.hgd.larch.exception.FileNotTxtException;
import com.hgd.larch.main.Execute;
import com.hgd.larch.main.FileInput;

public class Client {
	
	public static void main(String[] args) {
		String path = "C:\\java_project/test.txt";
		FileInput fi  = new FileInput();
		fi.setFile_path(path);
		try {
			fi.execute();
		} catch (FileNotTxtException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Execute execute = new Execute();
		try {
			execute.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
