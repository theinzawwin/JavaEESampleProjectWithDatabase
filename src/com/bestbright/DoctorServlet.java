package com.bestbright;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bestbright.dao.DoctorDao;
import com.bestbright.model.Doctor;

/**
 * Servlet implementation class DoctorServlet
 */
//@WebServlet("/DoctorServlet")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public DoctorDao doctorDao;
    public DoctorServlet() {
    	
        super();
        doctorDao=new DoctorDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("name");
		String phone= request.getParameter("phone");
		doctorDao.saveDoctor(new Doctor(0, name, phone));
		response.setContentType("text/html");
		response.getWriter().print("<h3>Welcome "+name+"</h3>");
		RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
		request.setAttribute("name", name);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
