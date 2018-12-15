package com.hgd.larch.utils;

import java.util.HashMap;
import com.hgd.larch.domain.KeyWord;
import com.hgd.larch.domain.KeyWordType;
import com.hgd.larch.domain.Operator;
import com.hgd.larch.domain.WordType;
import com.hgd.larch.utils.ProgramHelper;

public class ProgramHelper {
	private static ProgramHelper helper;

	public final int maxLength = 3000;
	public char[] program;
	public int index;
	public String currentWord;
	public int currentKey;
	public int currentType;
	public Operator op;
	public KeyWord keyWord;
	//�洢��ֵ�ͱ���
	public HashMap<String,Double> numberMap=new HashMap<String,Double>();
		
	public ProgramHelper(){
		currentWord = "";
		currentKey = KeyWordType.NONE.ordinal();
		currentType = WordType.NONE.ordinal();
		program = new char[maxLength];
		index = 0;
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
