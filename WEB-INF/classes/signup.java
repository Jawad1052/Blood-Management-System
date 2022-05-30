import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class signup extends HttpServlet {
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    
	PrintWriter out = response.getWriter();

    String name=request.getParameter("Name");
    String email=request.getParameter("Email");
    String password=request.getParameter("Password");
    String age=request.getParameter("Age");
    String gender=request.getParameter("Male");

	if(name=="" || email =="" ||password=="" || age ==""|| gender ==""){
 		RequestDispatcher rd = request.getRequestDispatcher("signup.html");	 
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

     String quer="Select Email from login where Email='"+email+"' ";

     ResultSet rst = st.executeQuery( quer );
     if(rst.next()){

      out.println("<h1>Email Already in Used</h1>");  
}
else{

	String query = "INSERT INTO login VALUES('"+ email + "','" +password+ "','" +name+ "','" +age+ "','" +gender+ "') ";

        int rs = st.executeUpdate( query );

     if(rs>0){

 	RequestDispatcher rd = request.getRequestDispatcher("login.html");	 
	 rd.forward(request,response);
	}

	else{
	out.println("<h1>Record could not be inserted.</h1>"); 		}
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
