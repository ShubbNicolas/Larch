package com.hgd.larch.domain;

import java.util.HashMap;

public class KeyWord {
public static HashMap<String, Integer> keyWordMap;
	
	private static KeyWord keyWord;
	

	public KeyWord(){
		keyWordMap = new HashMap<String , Integer>();
		keyWordMap.put("trait", KeyWordType.TRAIT.ordinal());
		keyWordMap.put("introduces", KeyWordType.INTRODUCES.ordinal());
		keyWordMap.put("asserts", KeyWordType.ASSERTS.ordinal());
		keyWordMap.put("generated", KeyWordType.GENERATED.ordinal());
		keyWordMap.put("partitioned", KeyWordType.PARTITIONED.ordinal());
		keyWordMap.put("by", KeyWordType.BY.ordinal());
		keyWordMap.put("implies", KeyWordType.IMPLIES.ordinal());
		keyWordMap.put("converts", KeyWordType.CONVERTS.ordinal());
		keyWordMap.put("exempting", KeyWordType.EXEMPTING.ordinal());
		keyWordMap.put("assumes", KeyWordType.ASSUMES.ordinal());
		keyWordMap.put("if", KeyWordType.IF.ordinal());
		keyWordMap.put("then", KeyWordType.THEN.ordinal());
		keyWordMap.put("else", KeyWordType.ELSE.ordinal());
		keyWordMap.put("for", KeyWordType.FOR.ordinal());
		keyWordMap.put("none", KeyWordType.NONE.ordinal());
		keyWordMap.put("uncertain", KeyWordType.UNCERTAIN.ordinal());		
	}
	
	public static synchronized KeyWord getKeyWord(){
		if(keyWord == null){
			keyWord = new KeyWord();
		}
		return keyWord;
	}

}
