<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <c:choose>
		<c:when test="${requestScope.RESULT != null}"> 
			<br>
			<h3 align="center">Result search:</h3>

	
	<p>
	<table border=1>
		<thead>
			<tr>
				<th>Account number</th>
				<th>Name</th>
				
				<th>Address3</th>
				
				<th>Postcode</th>

				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.RESULT}" var="customer">
				<tr>
					<td><c:out value="${customer.accNumber}" /></td>
					<td><c:out value="${customer.name}" /></td>
					
					<td><c:out value="${customer.address3}" /></td>
					
					<td><c:out value="${customer.postcode}" /></td>



				</tr>
			</c:forEach>
		</tbody>
	</table>

	

	 	</c:when>
	</c:choose>
 


