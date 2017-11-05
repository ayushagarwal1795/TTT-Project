package com.ttt.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ttt.beans.InputData;
import com.ttt.beans.OutputData;
import com.ttt.providers.TTTServiceProvider;
import com.ttt.services.TTTServices;

/**
 * Servlet implementation class CheckInputController
 */

public class CheckInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CheckInputController() {
        super();
        // TODO Auto-generated constructor stub
    }

    TTTServices tTTServices=TTTServiceProvider.getServiceProvider();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		ArrayList<OutputData> arr = new ArrayList<OutputData>();
		InputData inputdata = (InputData) request.getAttribute("inputdata");
	
			try {
				arr = tTTServices.displayResult(inputdata);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(arr==null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
			else{
		
		request.setAttribute("details", arr);

		
		RequestDispatcher r = request.getRequestDispatcher("DisplayResult.jsp");
		r.forward(request, response);
			}
	}

}
