

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet(
		description = "Login Servlet",
		urlPatterns = { "/LoginServlet"},
		initParams = {
				@WebInitParam(name = "username", value = "Ulan"),
				@WebInitParam(name = "password", value = "Nedovelir")
		})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init() throws ServletException{
		if(getServletContext().getInitParameter("dbURL").equals("jdbc:mysql://localhost/mysql_db")
				&& getServletContext().getInitParameter("dbUser").equals("root")
				&& getServletContext().getInitParameter("dbUserPwd").equals("Qwerty1992")) {
			getServletContext().setAttribute("DB_success", "True");
		}
		else throw new ServletException("DB Connection error");
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
		String r_username = request.getParameter("username");
		String r_pwd = request.getParameter("password");
		
		String userID = getServletConfig().getInitParameter("username");
		String password = getServletConfig().getInitParameter("password");
		log("User= " + r_username + "::password= "+r_pwd);
		if(userID.equals(r_username) && password.equals(r_pwd)) {
			Cookie loginCookie = new Cookie("user",userID);
			loginCookie.setMaxAge(30*60);
			response.addCookie(loginCookie);
			response.sendRedirect("welcome.jsp");
		}
		else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			PrintWriter out = response.getWriter();
			out.println("<font color = red> Either user name or  password is wrong. </font>");
			rd.include(request, response);
		}
	}

}
