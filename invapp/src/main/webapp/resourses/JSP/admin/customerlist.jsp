<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show all customers</title>
</head>

<p align="right"><a href="adminpanel" >Admin panel</a></p>
<p align="right">
		<a href="logout">Logout</a>
	</p>

<body onload="myFunction()">

<c:choose>
<c:when test="${sessionScope.uploadFileStatus == true}">

<script type="text/javascript" >

function myFunction() {
	alert("The file was uploaded successfully");
}


</script>

</c:when>
</c:choose>

<c:choose>
<c:when test="${ empty requestScope.customers}">

<h3 align="center" style="color: red">There are no records to display </h3>

 <p align="center"><a href="newCustomerInvoice">Upload customer invoice</a></p>
 
 
</c:when>
<c:otherwise>
 <jsp:include page="../modules/searchForm.jsp" />
 
 <p>
	
	<a href="deleteAll" onclick="return confirm('Are you sure you want to clear all?');">
							Clear all </a>
	
 
 <jsp:include page="../modules/moduleCustomerList.jsp" />


	</c:otherwise>
</c:choose>


	<script type="text/javascript">
		
	</script>
</body>
</html>