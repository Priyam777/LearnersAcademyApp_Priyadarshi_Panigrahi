package learnersacademy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learnersacademy.models.LearnersAcademyDao;

/**
 * Servlet implementation class AssignTeacherClassServlet
 */
public class AssignTeacherClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignTeacherClassServlet() {
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
		String teacherName=request.getParameter("teacherName");
		PrintWriter out=response.getWriter();
		String message="";
		
		int rowsAdded=LearnersAcademyDao.assignTeacherClass(teacherName, className);
		System.out.println("rowsAdded:"+rowsAdded);
		if(rowsAdded==1){
		
	    message="<span style='color:red'>"+rowsAdded+ "class assigned to teacher</span>";
		}else if(rowsAdded==0){
	    message="<span style='color:red'>class already assigned to teacher.Please add another class</span>";
		}
		else if(rowsAdded==-1){
	     message="<span style='color:red'>Teacher doesn't exist.Please add teacher first and then assign classes.</span>";
		}
		else{
			message="<span style='color:red'>Class has been already assigned to some teacher.Please assign different class</span>";	 
		}
		request.getRequestDispatcher("AssignTeacherClass.jsp").include(request, response);
		out.print(message);
	}

}
