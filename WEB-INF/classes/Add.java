import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class Add extends HttpServlet {
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    
	PrintWriter out = response.getWriter();

	HttpSession session=request.getSession(false);  
        if(session!=null)
	{

        
          
    String name=request.getParameter("Name");
    String email=request.getParameter("Email");
    String age=request.getParameter("Age");
    String gender=request.getParameter("Gender");
    String group=request.getParameter("Group");
    String contact=request.getParameter("Contact");
    String city=request.getParameter("City");
     String cnic=request.getParameter("Cnic");


 	if(name=="" || email =="" ||age=="" || gender ==""|| group =="" || contact =="" || city=="" || cnic ==""){
 		RequestDispatcher rd = request.getRequestDispatcher("/Add.jsp");	 
	 	rd.forward(request,response);
	}
	else{

    out.println("<html>");
    out.println("<head></head>");
    out.println("<body>");

try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/university";

    Connection con=DriverManager.getConnection(url, "root", "root");

    Statement st=con.createStatement();

     
     String query = "INSERT INTO profile VALUES('"+ name + "','" +email+ "','" +age+ "','" +gender+ "','" +group+ "','" +contact+ "','"+city+"','"+cnic+"') ";

      int rs = st.executeUpdate( query );

     if(rs>0)
	{
	  RequestDispatcher rd = request.getRequestDispatcher("/True.jsp");	 
	  rd.include(request,response);
	}

	else{
	        RequestDispatcher rd = request.getRequestDispatcher("/False.jsp");	 
	        rd.include(request,response); 		
	    }

     out.println("</body></html>");

           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }
}  
}
	else
            {   
                 response.sendRedirect("login.html");  
            }
}

  }

