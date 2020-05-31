package filesreaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {
	public static String[] propertiesfilereader(String [] data)
	{
		Properties property = new Properties();
		String [] datafile =new String[data.length];

				
						 try {
								InputStream input = new FileInputStream("configurations.properties");
							
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
