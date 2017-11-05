<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ttt.beans.OutputData"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body id="resultBackground">




<span id="content2">The most repeated words are.</span>

<span id="link"><a href="Index.html"> < Click here to go back</a>	</span>

<br><br><br><br>

<table class="table">

						<tr>
							<th>S.no</th>
							<th>Word</th>
							<th>Count</th>
							


						</tr>


						
							<%
								ArrayList<OutputData> arr = (ArrayList<OutputData>) request.getAttribute("details");

								for (int i = 0; i < arr.size(); i++) {
							%>
						
						<tr>
						<td>
								<%
									out.println(i+1);;
								%>
							</td>
							<td>
								<%
									out.println(arr.get(i).getWord());;
								%>
							</td>
							<td>
								<%
									out.println(arr.get(i).getCount());
								%>
							</td>
							


						</tr>
						<%
							}
						%>
					</table>
					
	<center><a href="Index.html"> < Click here to go back</a>	</center>			


</body>
</html>