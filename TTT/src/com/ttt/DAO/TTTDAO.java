package com.ttt.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ttt.beans.InputData;
import com.ttt.beans.OutputData;

public interface TTTDAO {
	
	public ArrayList<OutputData> retrieveData(InputData inputdata)throws SQLException;

}
