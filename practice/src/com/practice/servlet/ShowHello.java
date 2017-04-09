package com.practice.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.practice.dao.StudentDao;
import com.practice.entity.Student;

/**
 * Servlet implementation class ShowHello
 */
public class ShowHello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public ShowHello() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentDao sd = new StudentDao();
		List<Student> findAll = sd.findAll();
		HttpSession session = request.getSession();
		session.setAttribute("stuList", findAll);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
