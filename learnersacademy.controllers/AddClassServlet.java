package learnersacademy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learnersacademy.models.LearnersAcademyDao;

/**
 * Servlet implementation class AddClassServlet
 */
public class AddClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClassServlet() {
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
		String className=request.getParameter("className");
		PrintWriter out=response.getWriter();
		String message="";
		
		int rowsAdded=LearnersAcademyDao.addClasses(className);
		System.out.println("rowsAdded:"+rowsAdded);
		if(rowsAdded!=-1){
		
	    message="<span style='color:red'>class added successfully</span>";
		}else
		{
	     message="<span style='color:red'>Class already exists.Try another class</span>";
		}
		request.getRequestDispatcher("AddClasses.jsp").include(request, response);
		out.print(message);
	}

}
