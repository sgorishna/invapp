<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>Add new customer</title>
</head>
<body>
  

    <form method="POST" action='updateuser' name="formUpdateUser" >
   User ID : <input type="text" readonly="readonly" name="idUser"
            value="<c:out value="${user.idUser}" />" /> <br /> 
      
             Login : <input
            type="text" name="login"  value="<c:out value="${user.login}" />"
             /> <br />
             Password : <input
            type="text" name="password" value="<c:out value="${user.password}" />"
             /> <br /> 
         Name : <input
            type="text" name="name" value="<c:out value="${user.name}" />"
            /> <br /> 
        Role :  <input TYPE="radio" NAME="role" VALUE="1" CHECKED>
             ADMIN
            <br>
            <INPUT TYPE="radio" NAME="role" VALUE="2">
             USER
             
         
         <input
            type="submit" value="Submit" />
    </form>
</body>
</html>