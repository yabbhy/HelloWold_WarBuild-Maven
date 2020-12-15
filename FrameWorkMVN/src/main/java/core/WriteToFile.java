package core;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {

	public static void main(String[] args) {
		writeToFile();
		
		File fileToWrite = null;
		FileOutputStream fos = null;
		String contentToWrite = "This is a test text to write to a file\n Hopefully it will work..\n I am happy\n Yuppie it works..!";
		
		
		try {
			fileToWrite = new File("./src/testFile.txt");
//			boolean flag = fileToWrite.setReadOnly(); //if used this line will prevent writing to a file
//			boolean flag1 = fileToWrite.setWritable(true); //if used this line will allow writing to a file
			fos = new FileOutputStream(fileToWrite);
			
			 /* This logic will check whether the file
			   * exists or not. If the file is not found
			   * at the specified location it would create
			   * a new file*/
			if(!fileToWrite.exists()) {
				fileToWrite.createNewFile();
			}
			 /*String content cannot be directly written into
			   * a file. It needs to be converted into bytes
			   */
			byte[] bytes = contentToWrite.getBytes();
			
			fos.write(bytes);
			fos.flush();
				
			System.out.println("File Written Succesfully");
			
		} catch (FileNotFoundException e) {
			e.getMessage();
			System.out.println("Unable to write to a File");
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}finally {
			try {
				if(fos != null) {
					fos.close();
				}
			}catch(IOException e) {
				System.out.println("Error in closing the Stream");
			}
		}

	}
	
	private static String writeToFile() {
		File f = new File("./src/testFile.txt");
		FileInputStream fis  = null;
		BufferedInputStream bis = null;
		
		try {
			fis = new FileInputStream(f);
			 bis = new BufferedInputStream(fis);
			
			
			while(bis.available()>0) {
				System.out.println((char)bis.read());
				
			}
		} catch (FileNotFoundException e) {
            System.out.println("The specified file not found" + e);

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try{
	               if(bis != null && fis!=null)
	               {
	       	          fis.close();
	                  bis.close();
	               }      
	             }catch(IOException ioe)
	              {
	                  System.out.println("Error in InputStream close(): " + ioe);
	              } 
		}
		return null;
		
	}

}
