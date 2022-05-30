<%@ page session="false" %>
    <html>

    <head>
        <link rel="stylesheet" href="dstyle.css">
        <script language="JavaScript" type="text/javaScript">
                                function Validate() {
                                    if (document.delete.Cnic.value == "") {
                                        alert("Cnic Required!");
                                        return false;
                                    }
                                }
                            </script>
    </head>

    <body>
        <% HttpSession session=request.getSession(false);%>
            <%if(session==null) {response.sendRedirect("login.html");} else{%>
                <form name="delete" class="form" action="Delete" method="POST" onsubmit="return Validate()">

                    <div class="main">
                        <h1>Delete Record Form</h1>
                    </div>
                    <div class="mid">

                        <div>
                            CNIC:<br>
                            <input type="text" name="Cnic">
                        </div>


                        <button>Delete Record</button>
                        <br><br>
                    </div>
                </form>
                <%}%>
    </body>

    </html>