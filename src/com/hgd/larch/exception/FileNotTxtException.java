package com.hgd.larch.exception;

public class FileNotTxtException extends Exception{

	public FileNotTxtException() {
        super("不是TXT文件");
    }
	
	public FileNotTxtException(String message) {
        super(message);
    }

    public FileNotTxtException(Throwable cause) {
        super(cause);
    }

}
