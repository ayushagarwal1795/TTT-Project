package com.ttt.providers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.ttt.DAO.TTTDAO;


public class TTTDAOProvider {
	
	
	
	

	public TTTDAOProvider() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public static TTTDAO getDaoProvider()
	{
		File file = null;
		FileReader fr = null;
		Properties properties = null;
		String provider = null;
		TTTDAO tTTDAO = null;

		file = new File("F://zensar 2 workspace new for banking/TTT/resources/rprovider.properties");
		try {
			fr = new FileReader(file);
			properties = new Properties();
			properties.load(fr);
			provider = properties.getProperty("provider");
			tTTDAO = (TTTDAO) Class.forName(provider).newInstance();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		return tTTDAO;
	}
	
	
	
}
