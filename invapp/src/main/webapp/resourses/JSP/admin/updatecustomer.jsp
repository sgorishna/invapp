<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>Add new customer</title>
</head>
<body>


	<form method="POST" action='updatecustomer' name="formUpdateCustomer">
		Customer account number : <input type="text" readonly="readonly"
			name="accNumber" value="<c:out value="${customer.accNumber}" />" />
		<br /> name : <input type="text" name="name"
			value="<c:out value="${customer.name}" />" /> <br /> address1 : <input
			type="text" name="address1"
			value="<c:out value="${customer.address1}" />" /> <br /> address2 :
		<input type="text" name="address2"
			value="<c:out value="${customer.address2}" />" /> <br /> address3 :
		<input type="text" name="address3"
			value="<c:out value="${customer.address3}" />" /> <br /> address4 :
		<input type="text" name="address4"
			value="<c:out value="${customer.address4}" />" /> <br /> postcode :
		<input type="text" name="postcode"
			value="<c:out value="${customer.postcode}" />" /> <br />



		<input type="submit" value="Submit" />
	</form>
</body>
</html>