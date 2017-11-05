package com.ttt.services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ttt.beans.InputData;
import com.ttt.beans.OutputData;

public interface TTTServices {
	
	public ArrayList<OutputData> displayResult(InputData inputdata) throws SQLException;

}
