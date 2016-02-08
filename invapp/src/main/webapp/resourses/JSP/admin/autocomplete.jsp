<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:choose>
	<c:when test="${not empty list}">


		<c:forEach items="${requestScope.list}" var="list">

			<option>${list.accNumber}</option>
		</c:forEach>
	</c:when>



</c:choose>
