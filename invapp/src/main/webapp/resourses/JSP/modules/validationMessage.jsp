<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${requestScope.VALIDATION_MESSAGE != null }">

		<p align="center" style="color: red">${requestScope.VALIDATION_MESSAGE }</p>
		
	</c:when>
	
</c:choose>


