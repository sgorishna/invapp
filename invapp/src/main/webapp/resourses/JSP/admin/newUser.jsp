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
  

    <form method="POST" action='newuser' name="forNewUser" >
      
             Login : <input
            type="text" name="login"
             /> <br />
             Password : <input
            type="password" name="password"
             /> <br /> 
         Name : <input
            type="text" name="name"
            /> <br /> 
        Role :  <input TYPE="radio" NAME="role" VALUE="1" CHECKED>
             ADMIN
            <br>
            <INPUT TYPE="radio" NAME="role" VALUE="2">
             USER
            <br>
        
        Status :  <input TYPE="radio" NAME="active" VALUE="1" CHECKED>
            ACTIVE
            <br>
            <INPUT TYPE="radio" NAME="active" VALUE="0">
             NON ACTIVE
            <br>
        
         <br /> 
         
         <input
            type="submit" value="Submit" />
    </form>
</body>
</html>