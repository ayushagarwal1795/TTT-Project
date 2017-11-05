package com.ttt.serviceimpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ttt.DAO.TTTDAO;
import com.ttt.beans.InputData;
import com.ttt.beans.OutputData;
import com.ttt.providers.TTTDAOProvider;
import com.ttt.services.TTTServices;

public class TTTServiceImpl implements TTTServices {
	TTTDAO tTTDAO=null;

	public TTTServiceImpl() {
		
		tTTDAO =TTTDAOProvider.getDaoProvider();
	}

	@Override
	public ArrayList<OutputData> displayResult(InputData inputdata) throws SQLException {
		ArrayList<OutputData> arr;
		
		arr=tTTDAO.retrieveData(inputdata);
		
		return arr;
	}

}
