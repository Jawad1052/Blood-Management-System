<%@ page session="false" %>
    <html>

    <head>
        <link rel="stylesheet" href="ustyle.css">
        <script language="JavaScript" type="text/javaScript">
                        function Validate() {
                            if ( document.update.Name.value == "" )
                	    {
                			alert("Full Name Required!");			
                			return false;
                	    }
                         if ( document.update.Email.value == "" )
                	    {
                			alert("Email Required!");			
                			return false;
                	    }
                        if (document.update.Age.value == "") {
                                alert("Age Required!");
                                return false;
                            }
                        if (!document.update.Male[0].checked && !document.update.Male[1].checked)
                	    {
                		alert("Gender Required!");
                		return false;
                	    }
                         if (document.update.Group.value == "") {
                                alert("Blood Group Required!");
                                return false;
                            }
                             if (document.update.Contact.value == "") {
                                alert("Contact Required!");
                                return false;
                            }
                             if (document.update.City.value == "") {
                                alert("City Required!");
                                return false;
                            }
                            if (document.update.Cnic.value == "") {
                                alert("Cnic Required!");
                                return false;
                            }
                        }
                    </script>
    </head>

    <body>
        <%HttpSession session=request.getSession(false);%>
            <% if(session==null) {response.sendRedirect("login.html");} else{ %>
                <form name="update" class="form" action="Update" method="POST" onsubmit="return Validate()">

                    <div class="main">
                        <h1>Update Record Form</h1>
                        <i>
                            <h4>Update On CNIC basis</h4>
                        </i>
                    </div>
                    <div class="mid">
                        <div>
                            Full-Name:<br>
                            <input type="text" name="Name">
                        </div>
                        <div>
                            <div>

                                Email:<br>
                                <input name="Email" type="text">
                            </div>

                            <div>
                                Age:<br>
                                <input type="text" name="Age">
                            </div>
                            <br>

                            <div>
                                Gender: <br><br>
                                <span>
                                    <input type="radio" id="male" name="Gender" value="Male"><label class="male"
                                        for="male">Male</label>
                                </span>
                                <span>
                                    <input type="radio" id="female" name="Gender" value="Female"><label class="female"
                                        for="female">Female</label>
                                </span>
                            </div>
                            <div>
                                <br><br>
                                Blood Group:<br>
                                <input type="text" name="Group">
                            </div>
                            <div>
                                Contact:<br>
                                <input type="text" name="Contact">
                            </div>
                            <div>
                                City:<br>
                                <input type="text" name="City">
                            </div>
                            <div>
                                CNIC:<br>
                                <input type="text" name="Cnic">
                            </div>
                            <br>
                            <button>Update Record</button>
                            <br><br>
                        </div>
                </form>
                <%}%>
    </body>

    </html>