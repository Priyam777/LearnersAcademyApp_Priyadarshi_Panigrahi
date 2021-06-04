package learnersacademy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learnersacademy.models.LearnersAcademyDao;

/**
 * Servlet implementation class AddSubjectsServlet
 */
public class AddSubjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubjectsServlet() {
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
		// TODO Auto-generated method stub
		String className=request.getParameter("className");
		String subjectName=request.getParameter("subjectName");
		String message="";
		PrintWriter out=response.getWriter();
		
		int rowsAdded=LearnersAcademyDao.addSubjects(className, subjectName);
		
		if(rowsAdded==1){
		message="<span style='color:red'>"+rowsAdded+ "subject added</span>";
		}else{
			message="<span style='color:red'>subject already exists.</span>";
		}
		request.getRequestDispatcher("AddSubject.jsp").include(request, response);
		out.print(message);
		
		
		
		
	}

}
