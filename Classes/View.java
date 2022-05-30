import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class View extends HttpServlet {
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    
	
	PrintWriter out = response.getWriter();
	HttpSession session=request.getSession(false);  
        if(session!=null)
	{
    		String group=request.getParameter("Group");
	if(group=="")
		{
		RequestDispatcher rd = request.getRequestDispatcher("/View.jsp");	 
	 	rd.forward(request,response);
		}
	else{
   
     	out.println("<html>");
    	out.println("<head><</head>");
    	out.println("<body>");
	out.println("<Table border=5>");

    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/university";

    Connection con=DriverManager.getConnection(url, "root", "root");

    Statement st=con.createStatement();

     String query = "Select * FROM profile Where BGroup='"+group+"'";

      ResultSet rs = st.executeQuery( query );
	int count=0;
	out.println("<h1><tr><th>Name:</th><th>Email:</th><th>Age:</th><th>Gender:</th><th>Blood Group:</th><th>Contact:</th><th>City:</th><th>CNIC:</th></tr> </h1>");
      while(rs.next()){

        String name = rs.getString("Name");
    	 String email = rs.getString("Email");
	String age  = rs.getString("Age");
	String gender  = rs.getString("Gender");
	String bgroup  = rs.getString("BGroup");
	String contact  = rs.getString("Contact");
	String city  = rs.getString("City");
	 String cnc  = rs.getString("CNIC");

	out.println("<h1><tr><td>"+name+"</td><td>"+email+"</td><td>"+age+"</td><td>"+gender+"</td><td>"+bgroup+"</td><td>"+contact+"</td><td>"+city+"</td><td>"+cnc+"</td></tr> </h1>");
	
	count++;
	}

	if(count==0){
		RequestDispatcher rd = request.getRequestDispatcher("/False.jsp");	 
	 	rd.include(request,response); 		}

	else{
		RequestDispatcher rd = request.getRequestDispatcher("/True.jsp");	 
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
	else{   
            response.sendRedirect("login.html");  
        }

  }

}
