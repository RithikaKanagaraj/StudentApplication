

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Register() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if((String)session.getAttribute("email") != null)
		{
			response.sendRedirect("Userscreen.html");
			return;
		}
		
		response.sendRedirect("Register.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try {
		Connection con = DatabaseConnection.getConnection();
		
		HttpSession session = request.getSession();
		
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		PreparedStatement stmt = con.prepareStatement("insert into users values(?,?,?);");
		
		stmt.setString(1, name);
		stmt.setString(2, email);
		stmt.setString(3, password);
		
		int res = stmt.executeUpdate();
		
		if(res > 0)
		{
			session.setAttribute("email", email);
			response.sendRedirect("Userscreen.html");
		}
		else
		{
			response.getWriter().println("Something went wrong");
		}
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
		
	}

}
