<%@ page session="false" %>
    <html>

    <head>
        <link rel="stylesheet" href="dstyle.css">
        <script language="JavaScript" type="text/javaScript">
                                function Validate() {
                               
                                    if (document.view.Group.value == "") {
                                        alert("Blood Group Required!");
                                        return false;
                                    }
                                }
                            </script>
    </head>

    <body>
        <%HttpSession session=request.getSession(false);%>
            <% if(session==null) {response.sendRedirect("login.html");} else{ %>
                <form name="view" class="form" action="View" method="POST" onsubmit="return Validate()">

                    <div class="main">
                        <h1>Donors Blood List</h1>
                    </div>
                    <div class="mid">

                        <div>
                            Blood Group:<br>
                            <input type="text" name="Group">
                        </div>
                        <button>View List</button>
                        <br><br>
                    </div>
                </form>
                <%}%>
    </body>

    </html>