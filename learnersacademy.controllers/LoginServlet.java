package learnersacademy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import learnersacademy.models.Admin;
import learnersacademy.models.LearnersAcademyDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String adminName=request.getParameter("adminName");
		
		String password=request.getParameter("password");
		
		List<Admin> adminList=LearnersAcademyDao.getAdmin();
		System.out.println(adminList);
		if(adminList.size()==0){
			PrintWriter out=response.getWriter();
			String message="<span style='color:red'>Invalid credentials.Try again</span>";
			session.setAttribute("message", message);
			request.getRequestDispatcher("AdminLogin.jsp").include(request, response);
			out.print(message);
		}else{
		for(Admin a:adminList){
			System.out.println(a);
			if((a!=null)&& a.getAdminName().equalsIgnoreCase(adminName)&&
					a.getPassword().equalsIgnoreCase(password)){
				request.getRequestDispatcher("AdminHome.jsp").forward(request, response);
				
			}else{
				PrintWriter out=response.getWriter();
				String message="<span style='color:red'>Invalid credentials.Try again</span>";
				session.setAttribute("message", message);
				request.getRequestDispatcher("AdminLogin.jsp").include(request, response);
				out.print(message);
						
			}
				
		}
		}
	}	
	

}
