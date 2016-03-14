<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form method="POST" action='customerSearch'>

	Search by account number : <input type="text" name="accNumber"
		id="searchByCustomerAccountNumber" /> <input type="submit" value="Submit" />
</form>


<form method="POST" action='customerSearch' style="text-align: center;">


	Search by name : <input type="text" name="name" id="searchByCustomerName" /> <input
		type="submit" value="Submit" />
</form>




