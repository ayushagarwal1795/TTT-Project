package com.ttt.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.ttt.DAO.TTTDAO;
import com.ttt.beans.InputData;
import com.ttt.beans.OutputData;
import com.ttt.connectionprovider.ConnectionProvider;

public class TTTDAOImpl implements TTTDAO {
	Connection connProvider=null;

	public TTTDAOImpl() {
		connProvider=ConnectionProvider.getConnection();
	}

	@Override
	public ArrayList<OutputData> retrieveData(InputData inputdata)
			throws SQLException {
		
		ArrayList<OutputData> arr=new ArrayList<OutputData>();
		int num=inputdata.getNum();
		
		
		String fileLocation="";
		
		
		
		Statement stmt=null;
		String query="select file_location from ttt where file_id='1'";
		
		stmt=connProvider.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			Map<String,Integer> frequencyMap;
			
			
			while(rs.next()){
				
				fileLocation=rs.getString("file_location");
				
			
			}
			
			File file=new File(fileLocation);
			try {
				BufferedReader br=new BufferedReader(new FileReader(file));
				String input=null;
				
			frequencyMap=new HashMap<>();
				
				
				try {
					while((input=br.readLine())!=null)
					{
					String	words[]=input.split("[ ><\n\t\r.,-;:!?(){}@_'/]"); //splitting the sentences in the file to extract words.
					
					for(int i=0;i<words.length;i++)							//storing frequency in hashmap
					{
						String key=words[i].toLowerCase();
						if(key.length()>0)
						{
							if(frequencyMap.get(key)==null)
							{
								frequencyMap.put(key, 1);
							}
							else
							{
								int count=frequencyMap.get(key).intValue();
								count++;
								frequencyMap.put(key,count);
							}
						}
					}

					}
					
					int frequencyArray[]=new int[frequencyMap.size()];
					String wordArray[]=new String[frequencyMap.size()];
					int cnt;
					cnt=0;
					
					if(num <=0 || num>frequencyArray.length )			//if number is out of range
					{
						return null;
					}
					
					Set<Map.Entry<String,Integer>> entrySet=frequencyMap.entrySet();
					for(Map.Entry<String, Integer> entry: entrySet)
					{
						
						wordArray[cnt]=entry.getKey();
						frequencyArray[cnt]=entry.getValue();
						cnt++;
						
					}
				
				
				for(int i=0;i<frequencyArray.length;i++)				//sorting the data in descending order
				{
					for(int j=0;j<frequencyArray.length-1;j++)
					{
						if(frequencyArray[j]<frequencyArray[j+1])
						{
							int tempFrequency=frequencyArray[j];
							frequencyArray[j]=frequencyArray[j+1];
							frequencyArray[j+1]=tempFrequency;
							
							String tempWord=wordArray[j];
							wordArray[j]=wordArray[j+1];
							wordArray[j+1]=tempWord;
						}
						
					}
				}
			
					
					
				
			
			
			
			for(int i=0;i<num;i++)
			{
				OutputData outputdata=new OutputData();
				outputdata.setWord(wordArray[i]);
				outputdata.setCount(frequencyArray[i]);
				arr.add(outputdata);
			}
			
				
				
				} 
				
				
				
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		return arr;
	}

	

}
