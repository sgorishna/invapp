<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>Home</title>
</head>
<body>
  <p ><b>Account number: </b> <c:out value="${supplierDetails.accNumber}" /></p>
  
   <p ><b> Name: </b> <c:out value="${supplierDetails.name}" /></p>
   
    <p > <b>Address:</b> <c:out value="${supplierDetails.address1} " />  <c:out value="${supplierDetails.address2} " /> <c:out value="${supplierDetails.address3} " />  <c:out value="${supplierDetails.address4} " /></p>
  
   <p > <b>Postcode:</b> <c:out value="${supplierDetails.postcode}" /></p>
  <p><a href="supplierlist">Back to supplier list</a></p>
  
  <p><a href="logout">Logout</a></p>
  
 
  
  
</body>
</html>