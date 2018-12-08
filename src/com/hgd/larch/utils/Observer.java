package com.hgd.larch.utils;

import com.hgd.larch.domain.Store;

public interface Observer {
	
	public Store store = new Store().getStore();
	    
	public void execute(Exception e);
}
