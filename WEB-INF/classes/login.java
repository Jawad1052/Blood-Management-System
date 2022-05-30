import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class login extends HttpServlet {

  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    
    PrintWriter out = response.getWriter();
	

    String email=request.getParameter("name");
    String password=request.getParameter("password");

	if( email =="" || password==""){
 		RequestDispatcher rd = request.getRequestDispatcher("login.html");	 
	 	rd.forward(request,response);
	}
	else{
    
    out.println("<html>");
    out.println("<head></head>");
    out.println("<body>");


    try{
    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/university";

    Connection con=DriverManager.getConnection(url,"root","root");

    Statement st=con.createStatement();
    
     String query="Select * from login where Email='"+email+"' AND Password='"+password+"' ";
     ResultSet rs = st.executeQuery( query );
     if(rs.next())
	  {
		HttpSession session=request.getSession();
        	session.setAttribute("key",email);  
	 	RequestDispatcher rd = request.getRequestDispatcher("/Main.jsp");	 
	 	rd.forward(request,response);	
	  }
     
     else{
		 RequestDispatcher rd = request.getRequestDispatcher("login.html");	 
	         rd.forward(request,response);
          }


out.println("</body></html>");
           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }
}
  }

}
