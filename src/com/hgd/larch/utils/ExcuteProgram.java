package com.hgd.larch.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExcuteProgram {
    public char []Ind=new char[10];
    public char []Val=new char[10];
    public static int linecount2=0;
    public int totalline=0;
    public String path = "";
    public String [] getline;
    public String [] Funname=new String [10];
    public String newCreate;
	//���д�ȡtxt�ļ��еĴ���
     
	public void setPath(String path)
	{
		this.path=path;
	}
	//��ƺ���������ɨ��txt�ļ���ȡlarch��䲢���䵽���λ��
	public void Run()

	{
        try {
			getline = readFile(path);
			totalline=linecount2;
			int a=0;
			   while(linecount2>0)
		        {	
				   
				   if (getline[a].indexOf("new")!=-1)
				   {
					   String[] strs=getline[a].split(" ");
					   newCreate=strs[1];
				   }
				   	   
			       else if (getline[a].indexOf("Ind(")!=-1)
					  {
					      //String temp=deleteBlank(getline[a]);
					     // String[] strs=temp.split(" |'|,|(|)");
					      String temp=getline[a].substring(4, (getline[a].length()-1));
					      String temp2=deleteBlank(temp);
					      String temp3=deleteDot(temp2);
					      System.out.println(": "+temp3+" ");
					      String[] strs=temp3.split(",");
					      int nnn=0;
						  for(String s : strs)
					      {
							  nnn++;
							  System.out.println(nnn+": "+s+" ");
						  }
					      for(int i=0;i<strs.length;i++)
					      {

					    	  Ind[i]=strs[i].charAt(0);
					      }
					  } 
				   else if(getline[a].indexOf("Val(")!=-1)
				     {
					   String temp=getline[a].substring(4, (getline[a].length()-1));
					      String temp2=deleteBlank(temp);
					      String temp3=deleteDot(temp2);
					      String[] strs=temp3.split(",");
					      for(int i=0;i<strs.length;i++)
					      {
					    	  Val[i]=strs[i].charAt(0);
					      }
					  } 
				   
				   else if(getline[a].indexOf("add(")!=-1)
				   {
					      String temp=getline[a].substring(4, (getline[a].length()-1));
					      String temp2=deleteBlank(temp);
					      String temp3=deleteDot(temp2);
					      String[] strs=temp3.split(",");
					      String var1=strs[1];
					      String var2=strs[2];
					      System.out.println("add("+var1+","+var2+")");
					      //Operation(var1,var2);     
				   }
				   
				   else if(getline[a].indexOf("lookup(")!=-1)
				   {
					   String temp=getline[a].substring(4, (getline[a].length()-1));
					      String temp2=deleteBlank(temp);
					      String temp3=deleteSubString(getline[a],"lookup(");			    
					     // String[] strs=temp3.split(",");
					      String var1=temp3;
					      System.out.println("lookup("+var1+")");
					   
				   }
				   linecount2--;
			          a++;
		        }
			 
	
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
	}
	
/**
 * �����ж�ȡtxt�ļ�
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
                    txtline[linecount2]=line;
                    linecount2++;
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
    		
            String subString;
            int length=s1.length();
            s1.delete(length-1, length);
    		int delCount = 0;
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
            
    		if(delCount!=0) {

    			 subString = s1.toString();

    		}else {

    			subString = str1;

    		}
    		return subString;

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
	  
	  /**
	   * --ɾ���������еĿո�
	   * @param str1
	   * @return
	   */
	          
	  public String deleteDot(String str1)  
	   {
	  	 String s1=str1; 	 
	  	 String dotoff=s1.replace("'","");
	  	    return dotoff;  
	   }
}
