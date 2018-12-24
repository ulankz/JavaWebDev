

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String userID = "admin";
    private final String password = "password";
    
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		if(userID.equals(user) && password.equals(pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("user","Volya");
			
			session.setMaxInactiveInterval(30*60);
			Cookie userNameCookie = new Cookie("user",user);
			userNameCookie.setMaxAge(30*60);
			response.addCookie(userNameCookie);
			response.sendRedirect("welcome.jsp");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			PrintWriter out = response.getWriter();
			out.println("<font color = red> Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
	}

}
