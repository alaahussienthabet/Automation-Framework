package filesreaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propertyfilereader {
	public static String[] properitesfilereader(String [] data)
	{
		String datafile[] =new String[data.length];
				Properties property = new Properties();
				
						 try {
								InputStream input = new FileInputStream("configration.properties");
							
									property.load(input);
						 }
							catch (IOException e) { 
								e.printStackTrace();


								}
						 
						 
						 
						 for(int i = 0 ; i < data.length ; i++) {
							 
							 
							 datafile[i] = property.getProperty(data[i]);
							
							}
						 
		return datafile;
	}
}
