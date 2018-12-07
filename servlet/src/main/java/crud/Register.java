package crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		ServletContext cx = getServletContext();
		String driverName = cx.getInitParameter("driverName");
		Connection conn;
		try {
			//Loading Drivers for mysql
			Class.forName(driverName);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jcg","root","Qwerty1992");
			PreparedStatement ps = conn.prepareStatement("insert into student(name,email,password) values(?,?,?)");
			//ps.setInt(1, 0);
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, password);
			int i = ps.executeUpdate();
			if(i>0) {
				out.println("You are successfully registered");
			}
			else {
				out.println("<h2>Something Went wrong here</h2>");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			out.close();
		}
		
	}

}
