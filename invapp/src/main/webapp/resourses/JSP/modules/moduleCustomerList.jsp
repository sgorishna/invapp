<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2 align="center">List of customers</h2>
<p >
<form action="customerlist" method="post" style="text-align: center;">
	<select name="recordsPerPage">
		<option value="5">5</option>
		<option value="10">10</option>
		<option value="25">25</option>
		<option value="50">50</option>
		<option value="100">100</option>

	</select> <input type="submit" value="Submit" />

</form>
<p>
<table border=1 align="center">
	<thead>
		<tr>
			<th>Account number</th>
			<th>Name</th>

			<th>Address3</th>

			<th>Postcode</th>


		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.customers}" var="customer">
			<tr>
				<td><c:out value="${customer.accNumber}" /></td>
				<td><c:out value="${customer.name}" /></td>

				<td><c:out value="${customer.address3}" /></td>

				<td><c:out value="${customer.postcode}" /></td>



			</tr>
		</c:forEach>
	</tbody>
</table>

<p>
	<%--For displaying Previous link except for the 1st page --%>
	<c:if test="${requestScope.currentPage != 1}">
		<td><a href="customerlist?page=${requestScope.currentPage - 1}">Previous</a></td>
	</c:if>
</p>

<p>
	<%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>
<table border="1" cellpadding="5" cellspacing="5">
	<tr>


		<c:choose>
			<c:when test="${requestScope.numberOfPages <= 15}">

				<c:forEach begin="1" end="${requestScope.numberOfPages}" var="i">
					<c:choose>
						<c:when test="${requestScope.currentPage eq i}">
							<td>${i}</td>
						</c:when>
						<c:otherwise>
							<td><a href="customerlist?page=${i}">${i}</a></td>
						</c:otherwise>
					</c:choose>

				</c:forEach>

			</c:when>

			<c:otherwise>
				<!-- to get last number of page -->
				<c:set var="var" value="0" scope="page" />

				<!-- to stop display numbers of pages when get last number of page -->
				<c:choose>
					<c:when
						test="${requestScope.currentPage + 14 > requestScope.numberOfPages}">

						<c:forEach begin="${requestScope.currentPage}"
							end="${requestScope.numberOfPages}" var="i" varStatus="status">
							<c:set var="var" value="${status.index}" scope="page" />

							<c:choose>
								<c:when test="${requestScope.currentPage eq i}">
									<td>${i}</td>

								</c:when>
								<c:otherwise>
									<td><a href="customerlist?page=${i}">${i}</a></td>
								</c:otherwise>
							</c:choose>

						</c:forEach>
					</c:when>
					<c:otherwise>
						<!-- othervise -->
						<c:forEach begin="${requestScope.currentPage}"
							end="${requestScope.currentPage + 14}" var="i" varStatus="status">

							<c:set var="var" value="${status.index}" scope="page" />
							<c:choose>
								<c:when test="${requestScope.currentPage eq i}">
									<td>${i}</td>

								</c:when>
								<c:otherwise>
									<td><a href="customerlist?page=${i}">${i}</a></td>
								</c:otherwise>
							</c:choose>


						</c:forEach>
					</c:otherwise>

				</c:choose>
				<!-- to stop display 3 dots and last number of page -->

				<c:if test="${var != requestScope.numberOfPages}">

					<td><a href="customerlist?page=${var+1}">...</a></td>
					<td><a href="customerlist?page=${requestScope.numberOfPages}">${requestScope.numberOfPages}</a></td>
				</c:if>



			</c:otherwise>
		</c:choose>

	</tr>
</table>


<p>
	<%--For displaying Next link --%>
	<c:if test="${requestScope.currentPage <= requestScope.numberOfPages}">
		<td><a href="customerlist?page=${requestScope.currentPage + 1}">Next</a></td>
	</c:if>
</p>


