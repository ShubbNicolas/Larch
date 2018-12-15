package com.hgd.larch.exception;

public class FileNotTxtException extends Exception{

	public FileNotTxtException() {
        super("Test file is not .txt!");
    }
	
	public FileNotTxtException(String message) {
        super(message);
    }

    public FileNotTxtException(Throwable cause) {
        super(cause);
    }

}
