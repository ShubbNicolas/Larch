package com.hgd.larch.exception;

public class FileNotTxtException extends Exception{

	public FileNotTxtException() {
        super("����TXT�ļ�");
    }
	
	public FileNotTxtException(String message) {
        super(message);
    }

    public FileNotTxtException(Throwable cause) {
        super(cause);
    }

}
