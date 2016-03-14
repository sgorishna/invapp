<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>Home</title>
</head>
<body onload=" myFunction()">

<c:choose>
<c:when test="${requestScope.uploadFileStatus == false}">
<script type="text/javascript" >

function myFunction() {
	alert("The File Is In The Wrong Format! Please, choose .csv file");
}


</script>
</c:when>
</c:choose>
 
 <h4>Upload sales invoice detail</h4>
 <form action="newSalesInvoiceDetail" method="post" enctype="multipart/form-data">
Select File to Upload:<input type="file" name="fileName">
<br>
<input type="submit" value="Upload">
</form>

  
</body>


</html>