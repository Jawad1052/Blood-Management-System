<%@ page session="false" %>
    <html>

    <head>
        <link rel="stylesheet" href="dstyle.css">
        <script language="JavaScript" type="text/javaScript">
                        function Validate() {
                       
                            if (document.search.Cnic.value == "") {
                                alert("Cnic Required!");
                                return false;
                            }
                        }
                    </script>
    </head>

    <body>
        <%HttpSession session=request.getSession(false);%>
            <% if(session==null) {response.sendRedirect("login.html");} else{ %>
                <form name="search" class="form" action="Search" method="POST" onsubmit="return Validate()">

                    <div class="main">
                        <h1>Search Record Form</h1>
                    </div>
                    <div class="mid">

                        <div>
                            CNIC:<br>
                            <input type="text" name="Cnic">
                        </div>


                        <button>Search Record</button>
                        <br><br>
                    </div>
                </form>
                <%}%>
    </body>

    </html>