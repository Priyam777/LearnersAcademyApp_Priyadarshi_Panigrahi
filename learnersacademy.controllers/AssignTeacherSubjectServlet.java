package learnersacademy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learnersacademy.models.LearnersAcademyDao;

/**
 * Servlet implementation class AssignTeacherSubjectServlet
 */
public class AssignTeacherSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignTeacherSubjectServlet() {
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
		String subjectName=request.getParameter("subjectName");
		String teacherName=request.getParameter("teacherName");
		PrintWriter out=response.getWriter();
		String message="";
		
		int rowsAdded=LearnersAcademyDao.assignTeacherSubject(teacherName, subjectName);
		System.out.println("rowsAdded:"+rowsAdded);
		if(rowsAdded==5){
			message="<span style='color:red'>subject doesn't exist.Please add subject first</span>";
	    //message="<span style='color:red'>"+rowsAdded+ "subject assigned to teacher</span>";
		}else if(rowsAdded==0){
	    message="<span style='color:red'>subject already assigned to teacher.Please add another subject</span>";
		}
		else if(rowsAdded==1){
			//message="<span style='color:red>subject doesn't exist.Please add subject first,/span>";
			message="<span style='color:red'>"+rowsAdded+ "subject assigned to teacher</span>";
		}
		else{
	     message="<span style='color:red'>Teacher doesn't exist.Please add teacher first and then assign subjects.</span>";
		}
		request.getRequestDispatcher("AssignTeacherSubject.jsp").include(request, response);
		out.print(message);
	}

}
