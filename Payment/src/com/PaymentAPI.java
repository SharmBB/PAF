package com;


import java.io.IOException;
import java.util.HashMap; 
import java.util.Map; 
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class InvestorsAPI
 */
@WebServlet("/PaymentAPI")
public class PaymentAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Payment itemObj = new Payment();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String output = itemObj.insertinvestor(request.getParameter("Benefactor"), 
				 request.getParameter("Payer"), 
				request.getParameter("Amount"),
				request.getParameter("Account_No"),
				request.getParameter("Bank")); 
				response.getWriter().write(output);
				
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request) 
	{ 
	 Map<String, String> map = new HashMap<String, String>(); 
	try
	 { 
		 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
		 String queryString = scanner.hasNext() ? 
		 scanner.useDelimiter("\\A").next() : ""; 
		 scanner.close(); 
		 String[] params = queryString.split("&"); 
		 
	 for (String param : params) 
	 {
			 String[] p = param.split("=");
			 map.put(p[0], p[1]); 
		 } 
		 } 
		catch (Exception e) 
		 { 
		 } 
		return map;
	 }

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request); 
		 String output = itemObj.updatePayment(paras.get("hidItemIDSave").toString(), 
		 paras.get("Benefactor").toString(), 
		 paras.get("Payer").toString(), 
		 paras.get("Amount").toString(), 
		 paras.get("Account_No").toString(),
		 paras.get("Bank").toString()); 
		 response.getWriter().write(output);
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 Map paras = getParasMap(request); 
		 String output = itemObj.deleteinvestor(paras.get("Payment_ID").toString()); 
		 response.getWriter().write(output); 
	}

}
