package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Welcome
 */
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		try {
//		1) Using HttpsSession
//			String user = (String) session.getAttribute("username");
//			out.println("<h2>Hello "+user+"</h2>");
//			//response.sendRedirect("http://www.google.com");
//		2) Using Cookies
//			Cookie[] cks = request.getCookies();
//			out.println("Welcome " + cks[0].getValue());
//		3) Using URL Rewriting
			String username = request.getParameter("username");
			out.println("<h2>Welcome "+username+"</h2>");
		}
		finally {
			out.close();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<h2>Welcome user "+request.getParameter("username")+"</h2>");
		}
		finally {
			out.close();
		}
	}

}
