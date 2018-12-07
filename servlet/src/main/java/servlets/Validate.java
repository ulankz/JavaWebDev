package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validate
 */
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Validate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			if (password.equals("123")) {
				
// 			1)	Manages session with HttpSession				
//				HttpSession session = request.getSession();
//				session.setAttribute("username", name);

//			2) Using Cookie for session Management
//				Cookie ck = new Cookie("username",name);
//				response.addCookie(ck);
//				response.sendRedirect("Welcome");
				
				//RequestDispatcher rd = request.getRequestDispatcher("Welcome");
				//rd.forward(request, response);
				
//			3) Using URL Rewriting
				response.sendRedirect("Welcome?username=" + name);
				
			} else {
				out.println("<font color = 'red'> <b> You have entered incorrect password</b></font>");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
		} finally {
			out.close();
		}
	}
}
