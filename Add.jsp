<%@ page session="false" %>
    <html>

    <head>
        <link rel="stylesheet" href="astyle.css">
        <script language="JavaScript" type="text/javaScript">
                function Validate() {
                    if ( document.add.Name.value == "" )
        	    {
        			alert("Full Name Required!");			
        			return false;
        	    }
                 if ( document.add.Email.value == "" )
        	    {
        			alert("Email Required!");			
        			return false;
        	    }
                if (document.add.Age.value == "") {
                        alert("Age Required!");
                        return false;
                    }
                if (!document.add.Male[0].checked && !document.add.Male[1].checked)
        	    {
        		alert("Gender Required!");
        		return false;
        	    }
                 if (document.add.Group.value == "") {
                        alert("Blood Group Required!");
                        return false;
                    }
                     if (document.add.Contact.value == "") {
                        alert("Contact Required!");
                        return false;
                    }
                     if (document.add.City.value == "") {
                        alert("City Required!");
                        return false;
                    }
                    if (document.add.Cnic.value == "") {
                        alert("Cnic Required!");
                        return false;
                    }
                }
            </script>
    </head>

    <body>
        <% HttpSession session=request.getSession(false);%>
            <%if(session==null){ response.sendRedirect("login.html"); } else{ %>
                <form name="add" class="form" action="Add" method="POST" onsubmit="return Validate()">

                    <div class="main">
                        <h1>Add Record Form</h1>
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
                            <button>Add Record</button>
                            <br><br>
                        </div>
                </form>
                <%}%>
    </body>

    </html>