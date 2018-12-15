package com.hgd.larch.utils;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class OpenFile {
	public String getPath()
	{
		
		 JFileChooser fileChooser = new JFileChooser();
		  //���õ�ǰĿ¼
		  //�ļ��Ի�����ʾ���ǵ�ǰ��Ŀ�ļ�Ŀ¼
		  fileChooser.setCurrentDirectory(new File("."));
		  fileChooser.setAcceptAllFileFilterUsed(false);
		  //�����ļ��Ի���������Ҫ��ʾ���ļ�
		  final String[][] fileENames = { 
				 
				  { ".larch", "larch(*.larch)" },
				  { ".txt", "�ı��ļ�(*.txt)" },
		           };
		  // ��ʾ�����ļ�
		  fileChooser.addChoosableFileFilter(new FileFilter() {
		   public boolean accept(File file) {
			 String p= file.getPath();
			 System.out.println(p);
		    return true;
		   }
		   public String getDescription() {
		    return "�����ļ�(*.*)";
		   }
		  });
		  // ѭ�������Ҫ��ʾ���ļ�
		  for (final String[] fileEName : fileENames) {
		   
		   fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
		 
				    public boolean accept(File file) { 
				 
				     if (file.getName().endsWith(fileEName[0]) || file.isDirectory()) {
				 
				      return true;
				     }
				 
				     return false;
				    }
		 
				    public String getDescription() {
				 
				     return fileEName[1];
				    }
		     });
		  } 
		  fileChooser.showDialog(null, null);
		  //ͨ��filechooser��ȡ�ļ�������
		  File p=fileChooser.getSelectedFile();
		  //ͨ��getAbsolutePath��ȡ�ļ��ľ���·��
		  String path = p.getAbsolutePath();
		  return path;
	}

}
