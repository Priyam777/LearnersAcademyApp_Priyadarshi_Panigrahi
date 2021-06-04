package learnersacademy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learnersacademy.models.LearnersAcademyDao;

/**
 * Servlet implementation class MasterReportServlet
 */
public class MasterReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterReportServlet() {
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
		
		List teacherNames=LearnersAcademyDao.getMasterReportTeacher(className);
		request.setAttribute("teacherNames", teacherNames);
		request.setAttribute("className",className);
		List subjectNames=LearnersAcademyDao.getMasterReportSubject(className);
		request.setAttribute("subjectNames", subjectNames);
		List studentNames=LearnersAcademyDao.getMasterReportStudent(className);
		request.setAttribute("studentNames", studentNames);
		request.getRequestDispatcher("MasterReport.jsp").include(request, response);
	}

}
