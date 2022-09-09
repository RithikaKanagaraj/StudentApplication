//
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//public class Attendance extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    
//    public Attendance() {
//        super();
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();  
//        response.setContentType("text/html");  
//        out.println("<html><body>");
//        
//        System.out.println("Here");
//		   
//        String url = "jdbc:mysql:// localhost:3306/todoApp";
//		String user = "root";
//		String pass = "123";
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection	con = DriverManager.getConnection(url, user, pass);
//			
//			System.out.println("Here 1");
//			
//		PreparedStatement stmt = con.prepareStatement("Select * from userslist;");
//			
//		
//			ResultSet rs = stmt.executeQuery();
//			 out.println("<table border=1 width=50% height=50%>");  
//             out.println("<tr><th>StudentName</th><th>Rollno</th><th>Status</th><tr>");  
//             while (rs.next()) 
//             { 
//             
//                 String n = rs.getString("Student_name");  
//                 String nm = rs.getString("rollno");  
//                 System.out.println(n + " " + nm);
//                 out.println("<tr><td>" + n + "</td><td>" + nm + "</td></tr>");  
//             }  
//             out.println("</table>");  
//             out.println("</html></body>");  
//           //  con.close();  
//            }  
//		
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
////			
////		response.sendRedirect("Userscreen.html");
//		
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        
//	}
//	}
