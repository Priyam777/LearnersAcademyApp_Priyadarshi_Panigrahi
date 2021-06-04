package learnersacademy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learnersacademy.models.LearnersAcademyDao;

/**
 * Servlet implementation class AddTeacherServlet
 */
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacherServlet() {
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
		String teacherName=request.getParameter("teacherName");
		PrintWriter out=response.getWriter();
		String message="";
		
		int rowsAdded=LearnersAcademyDao.addTeachers(teacherName);
		System.out.println("rowsAdded:"+rowsAdded);
		if(rowsAdded!=-1){
		
	    message="<span style='color:red'>"+rowsAdded+ "Teacher added</span>";
		}else
		{
	     message="<span style='color:red'>Teacher already exists.</span>";
		}
		request.getRequestDispatcher("AddTeacher.jsp").include(request, response);
		out.print(message);
		
	}

}
