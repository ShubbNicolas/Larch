package com.hgd.larch.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;


public class ReaderHelper {
    private static ReaderHelper helper;
    public String path = "";
    public String trait;
    public String Traitname;
    public String []assertContent;
    
    //Trait������
    public static int linecount=0;
    public int totalline=0;
    //���������ܹ��ж�����
    public String [] getline;
	//���д�ȡtxt�ļ��еĴ���
	public Stack<String> newStack =new Stack<String>();
	//��Źؼ���new����ز�������
	public Stack<String> addStack = new Stack<String>();	
	//�������add��������ز�������
	public Stack<String> lookupStack = new Stack<String>();
	//�������lookup��������ز�������
	public Stack<String> belongStack = new Stack<String>();
	//�������belongstack��������ز�������

    //ͨ�����ļ��Ի����ȡ�ļ�·��
	public void setPath(String path)
	{
		this.path=path;
	}
	//��ƺ���������ɨ��txt�ļ���ȡlarch��䲢���䵽���λ��
	public void Assign()
	{
		
        try {
			getline = readFile(path);
			totalline=linecount;
			int a=0;
			   while(linecount>0)
		        {	
			          /*System.out.println(getline[a].replace("��", ","));
				   
				      /String[] strs=temp.split(":");
					  for(String s : strs)
				      {
						  //System.out.print(s+" ");
					}*/  
				  if (getline[a].indexOf("trait")!=-1)
				  {
					  String temp= getline[a].replace("��", ",");
					
					  String[] strs=temp.split(" ");
					  Traitname=strs[0];
				  }
				  
				  else if(getline[a].indexOf("new")!=-1)
				  {
					  String temp= getline[a].replace("��", ",");
					  String temp2= deleteBlank(temp);
					  String[] strs=temp2.split(" |:|,");
					  newStack.push(strs[1]);
				  }
				  else if(getline[a].indexOf("add")!=-1)
				  {
					  String temp= getline[a].replace("��", ",");
					 String temp2= deleteBlank(temp);
					  String[] strs=temp2.split(" |:|,");  
					//for(String s : strs)
				     //{
						// System.out.print(s+" ");
			          // }
					//  for(int i=0;i<strs.length;i++)
					//  {
					//	  System.out.println(i+" : "+strs[i]);
					 // }
					// System.out.println("");
					  addStack.push(strs[1]);
					//  System.out.println(addStack.peek());
					  addStack.push(strs[2]);
					//  System.out.println(addStack.peek());
					  addStack.push(strs[3]);
					//  System.out.println(addStack.peek());
					  addStack.push(strs[4]);
					//  System.out.println(addStack.peek());
					  
				  }
				  else if(getline[a].indexOf("/belong")!=-1)
				  {
					  String temp= getline[a].replace("��", ",");
					  String temp2= deleteBlank(temp);
					  String[] strs=temp2.split(" |:|,");
					  belongStack.push(strs[1]);
					  belongStack.push(strs[2]);
					  belongStack.push(strs[3]);
			
				  }
				  else if(getline[a].indexOf("lookup")!=-1)
				  {
					  String temp= getline[a].replace("��", ",");
					  String temp2= deleteBlank(temp);
					  String[] strs=temp2.split(" |:|,");
					  lookupStack.push(strs[1]);
					  lookupStack.push(strs[2]);
					  lookupStack.push(strs[3]);
					  
				  }
				  else if(getline[a].indexOf("asserts")!=-1)
				  {
					 //String temp= getline[a].replace("��", ",");
					 assertContent=new String[linecount];
					  int n=0;
					  while(linecount>0)
					  {
						  
						  this.assertContent[n]=getline[a];
						  n++;
						  a++;
						  linecount--;
					  }
						  
				  }
					 // System.out.println("");
					  linecount--;
			          a++;
			  }
			   }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
	}
	/**
	 * ���ж�ȡ�ļ������ַ������鲢����
	 * @param path
	 * @return
	 * @throws IOException
	 */
	
	public static String[] readFile(String path) throws IOException {
        // ���ַ�����·��
        String[]txtline = new String[15];
      
        FileInputStream fis = new FileInputStream(path);

        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
           
           // if (line.lastIndexOf(";") < 0) {
                txtline[linecount]=line;
                linecount++;
            //}
        }
        br.close();
        isr.close();
        fis.close();
        return txtline;
    }
	
    /**
     * --ɾ����������ָ�����Ӵ�
     * @param str1 str2
     * @return
     */
	
    public String deleteSubString(String str1, String str2) {
		
		StringBuffer s1 = new StringBuffer(str1);
		
        String removeblank="aaa";
       
		int delCount = 0;
		int aaa=0;
		 //System.out.println("!!!!!"+aaa);
		//System.out.print(delCount);
		while (true) {

			int index = s1.indexOf(str2);

			if(index == -1) {
				break;
			}
			s1.delete(index, index+str2.length());

			delCount++;
			//System.out.print(delCount);
		}
        
		if(delCount!=0) 
		{
			 removeblank = s1.toString();
		}else {
		removeblank = str1;
		}
		return removeblank;
	}
    
    /**
     * --ɾ���������еĿո�
     * @param str1
     * @return
     */

	  public String deleteBlank(String str1)
	  {
		  String s1=str1; 
		  String blankoff=s1.replace(" ","");
		  return blankoff;  
	  }

}

	
	
	
	



