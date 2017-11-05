package com.ttt.providers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.ttt.services.TTTServices;

public class TTTServiceProvider {
	
	
	
	public static TTTServices getServiceProvider(){
		File file = null;
		FileReader fr = null;
		Properties properties = null;
		String provider = null;
		TTTServices tTTServices = null;
		try {
			file = new File("F://zensar 2 workspace new for banking/TTT/resources/provider.properties");
			fr = new FileReader(file);
			properties = new Properties();
			properties.load(fr);
			provider = properties.getProperty("provider");
			tTTServices = (TTTServices) Class.forName(provider).newInstance();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return tTTServices;
	}
	
	
	
	
	
	

	public TTTServiceProvider() {
		// TODO Auto-generated constructor stub
	}

}
