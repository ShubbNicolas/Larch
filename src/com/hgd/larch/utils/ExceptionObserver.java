package com.hgd.larch.utils;

import com.hgd.larch.utils.Observer;

public class ExceptionObserver implements Observer{
	 @Override
	    public void execute(Exception e) {
	        /*StackTraceElement[] trace = e.getStackTrace();
	        String exceptionMessage = "";
	        for (StackTraceElement s : trace) {
	            exceptionMessage += s + "\r\n";
	        }*/
	        String exceptionMessage = "";
	        exceptionMessage = e.getMessage();
	        Observer.store.programOutput += exceptionMessage;
	    }
}
