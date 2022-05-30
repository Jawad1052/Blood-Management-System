import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class Delete extends HttpServlet {
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    
	PrintWriter out = response.getWriter();
	HttpSession session=request.getSession(false);  
        if(session!=null)
	{
    		String cnic=request.getParameter("Cnic");
	if(cnic=="")
		{
		RequestDispatcher rd = request.getRequestDispatcher("/Delete.jsp");	 
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

     
     String query = "DELETE FROM profile WHERE CNIC = '" + cnic + "'";

      int rs = st.executeUpdate( query );

     if(rs>0){

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
else{   
            response.sendRedirect("login.html");  
        }
  }

}
