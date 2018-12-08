package com.hgd.larch.utils;

import java.util.HashMap;
import com.hgd.larch.domain.KeyWord;
import com.hgd.larch.domain.KeyWordType;
import com.hgd.larch.domain.Operator;
import com.hgd.larch.domain.WordType;
import com.hgd.larch.utils.ProgramHelper;

public class ProgramHelper {
	private static ProgramHelper helper;

	public final int maxLength = 1000;
	public char[] program;
	public int index;
	public String currentWord;
	public int currentKey;
	public int currentType;
	public HashMap<String,Integer> markLoc;
	public Operator op;
	public KeyWord keyWord;
	//存储数值型变量
	public HashMap<String,Double> numberMap=new HashMap<String,Double>();
	//存储字符型变量
	public HashMap<String,String> stringMap=new HashMap<String,String>();
		
	public ProgramHelper(){
		currentWord = "";
		currentKey = KeyWordType.NONE.ordinal();
		currentType = WordType.NONE.ordinal();
		program = new char[maxLength];
		index = 0;
		markLoc = new HashMap<String,Integer>();
		op = Operator.getOperator();
		keyWord = KeyWord.getKeyWord();
	}
	
	public static synchronized ProgramHelper getHelper(){
		if(helper == null){
			helper = new ProgramHelper();
		}
		return helper;
	}
	
	public void getNextWordHelper(){
		currentWord = "";
		currentKey = KeyWordType.NONE.ordinal();
		currentType = WordType.NONE.ordinal();
	}
	
	public int getKeyWordType(String word){
		//System.out.println(KeyWord.getKeyWord().keyWordMap.get(word));
		if(KeyWord.keyWordMap.get(word) != null){
			return KeyWord.keyWordMap.get(word);
		}
		return KeyWordType.UNCERTAIN.ordinal();
	}
}
