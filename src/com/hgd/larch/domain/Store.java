package com.hgd.larch.domain;
/**
 * 
 * @author ��
 *
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Store {

    public final static Store store = new Store();
    
    public Map<String, String> funcMap = new HashMap<>();
    
    public Vector<Integer> sizeParameter = new Vector<Integer>();
    
    public String var = "";
    public int start = 0;// ѭ����ʼ
    public int end = 0;// ѭ����������
    
    public int max = 0;
    public String expString = "";
    public String paraString = "";
    
    public String programOutput = "";
    
    public Store getStore() {
        return store;
    }
    
}
