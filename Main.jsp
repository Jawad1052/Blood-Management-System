<%@ page session="false" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="fmain.css">
    </head>

    <body>
        <% HttpSession session=request.getSession(false);%>
            <% if(session==null) {response.sendRedirect("login.html");} else{ %>
                <!-- <form class="login-form" method="post" action="main"> -->
                <button class="bn632-hover bn28"><a href="Add.jsp">Add Donor Record</a></button>
                <button class="bn632-hover bn28"><a href="Search.jsp">Search Donor Record</a></button>
                <button class="bn632-hover bn28"><a href="Update.jsp">Update Donor Record</a></button>
                <button class="bn632-hover bn28"><a href="Delete.jsp">Delete Donor Record</a></button>
                <button class="bn632-hover bn28"><a href="View.jsp">View Donors List</a></button>
                <button class="bn632-hover bn28"><a href="logout.jsp">Logout</a></button>
                <!-- </form> -->
                <% } %>


    </body>

    </html>