function Validate() {
  var c = document.sign.Email.value;

  if (c.indexOf("@") <= 0) {
    alert("Invalid Email Format");
  }
  if (c.charAt(c.length - 4) != "." && c.charAt(c.length - 3) != ".") {
    alert("Invalid Email Format");
  }
  if (document.sign.Name.value == "") {
    alert("Full Name Required!");
    return false;
  }
  if (c == "") {
    alert("Email Required!");
    return false;
  }
  if (document.sign.Password.value == "") {
    alert("Password Required!");
    return false;
  }
  if (document.sign.Age.value == "") {
    alert("Age Required!!");
    return false;
  }
  if (!document.sign.Male[0].checked && !document.sign.Male[1].checked) {
    alert("Gender Required!");
    return false;
  }
}
