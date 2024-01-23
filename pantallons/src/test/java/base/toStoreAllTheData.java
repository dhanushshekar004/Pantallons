package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class toStoreAllTheData {
	public static String deviceToken;
	public static String excelFilePath="";
	
	public String gett() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("SER//token.ser"));
		deviceToken=(String) ois.readObject();
		
		
		return deviceToken;
		
	}
	
	
	
	
	
	
	public  void sett(String deviceToken) throws FileNotFoundException, IOException {
		
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("SER//token.ser"));
		oos.writeObject(deviceToken);
		
	}

}
