package com.ttt.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.ttt.beans.InputData;

/**
 * Servlet Filter implementation class CheckInputFilter
 */

public class CheckInputFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckInputFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(request.getParameter("number").equals(""))
		{
			System.out.println("dofilter");
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			out.println("The field can not be left blank");
			RequestDispatcher rd=request.getRequestDispatcher("/Index.html");
			System.out.println("dofilter2");
			rd.include(request, response);
		}
		else{
			
			InputData inputdata=new InputData(Integer.parseInt(request.getParameter("number")));
			request.setAttribute("inputdata", inputdata);
			chain.doFilter(request, response);
			}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
