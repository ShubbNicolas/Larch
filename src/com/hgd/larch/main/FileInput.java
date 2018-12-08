package com.hgd.larch.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.hgd.larch.exception.FileNotTxtException;
import com.hgd.larch.utils.ExceptionObserver;
import com.hgd.larch.utils.GetNextWordHelper;
import com.hgd.larch.utils.ProgramHelper;
import com.hgd.larch.utils.Observer;

public class FileInput {
	
	public final static FileInput fileinput = new FileInput();

    private File file = null;
    private String file_path = "";

    private Observer observer = new ExceptionObserver();
    
    public FileInput getFileInput() {
        return fileinput;
    }

    private boolean isTxt(String postfix) {
        if ("txt".equals(postfix.toLowerCase())) {
            return true;
        }
        return false;
    }

    public void execute() throws FileNotTxtException {
        ProgramHelper phelper = ProgramHelper.getHelper();
        GetNextWordHelper ghelper = new GetNextWordHelper();
        char[] tempArray = new char[1024];
        File tempFile = null;
        if (file != null) {
            tempFile = file;
        } else if (!"".equals(file_path) && !"".equals(file_path.trim()) && file_path != null) {
            tempFile = new File(file_path);
        } else {
            //throw Exception;
        }
        String fileName = tempFile.getName();
        int index = fileName.lastIndexOf(".");
        boolean isTxt = isTxt(fileName.substring(index + 1));
        if (!isTxt) {
            observer.execute(new FileNotTxtException());
            throw new FileNotTxtException("不是TXT文件");
        }
        FileReader fr;
        int size = 0;
        try {
            fr = new FileReader(tempFile);
            BufferedReader br = new BufferedReader(fr);
            size = br.read(tempArray, 0, 1024);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.arraycopy(tempArray, 0, phelper.program, 0, size);
    }
    
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

}
