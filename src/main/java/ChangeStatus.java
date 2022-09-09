

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChangeStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ChangeStatus() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			Connection con = DatabaseConnection.getConnection();
			
			String rollno=request.getParameter("rollno");
			String status=request.getParameter("status");
			
			PreparedStatement st=con.prepareStatement("select * from statuslist where rollno=?;");
			st.setString(1, rollno);
			
			ResultSet check=st.executeQuery();
			PreparedStatement stmt;
			if(check.next()) {
				stmt = con.prepareStatement("update statuslist set status=? where rollno=?;");
				stmt.setString(2, rollno);
				stmt.setBoolean(1, status.equals("yes"));
				
			}
			else {
			stmt = con.prepareStatement("insert into statuslist values(?,?);");
			stmt.setString(1, rollno);
			stmt.setBoolean(2, status.equals("yes"));
			}
			
			System.out.println(rollno+" "+status);
			int res = stmt.executeUpdate();
			
//			if(res > 0)
//			{
//				response.getWriter().println("User Registered successfully");
//			}
//			else
//			{
//				response.getWriter().println("Something went wrong");
//			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		doGet(request, response);
		response.sendRedirect("attendance.jsp");
		}
		
		
		
		
		
		
		
		
		
		
	}


