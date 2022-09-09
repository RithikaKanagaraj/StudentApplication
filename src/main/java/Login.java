import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        public Login() {
        super();
        
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if((String)session.getAttribute("email") != null)
		{
			response.sendRedirect("Userscreen.html");
			return;
		}
		
		response.sendRedirect("login.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {					
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		HttpSession session = request.getSession();
		
		System.out.println((String)session.getAttribute("email"));
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement stmt=con.prepareStatement("select * from users where email=? and pass=?");  
			stmt.setString(1, email);
			stmt.setString(2, pass);
			ResultSet rs=stmt.executeQuery(); 
			
		
		if(rs.next()) {
			//response.getWriter().print("Logged In");
			session.setAttribute("email", email);

			response.sendRedirect("Userscreen.html");
		}
		else
		{
			response.getWriter().println("Wrong credentials");
		}
		
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	
	}
}
