

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Index() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if((String)session.getAttribute("email") != null)
		{
			System.out.println((String)session.getAttribute("email"));
			response.sendRedirect("Login");	
		}
		else
		{
			response.sendRedirect("Userscreen.html");
		}
		
	}

	
	
}
