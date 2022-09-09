

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddStudents() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
		Connection con = DatabaseConnection.getConnection();
		
		String name = request.getParameter("name");
		String rollno = request.getParameter("rollno");
		System.out.println(name+" "+rollno);
		
		PreparedStatement stmt = con.prepareStatement("insert into userslist values(?,?);");
		
		stmt.setString(1, name);
		stmt.setString(2, rollno);
		
		int res = stmt.executeUpdate();
		
		if(res > 0)
		{
			response.getWriter().println("student Registered successfully");
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
		
	response.sendRedirect("addstudent.html");
	}


}
