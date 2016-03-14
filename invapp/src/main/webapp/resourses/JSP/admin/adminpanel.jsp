<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show all users</title>
</head>
<body >


    <table border=1>
        <thead>
            <tr>
                <th>User id</th>
                <th>Login</th>
                <th>Password</th>
                <th>Name</th>
                <th>Role</th>
               
                <th>Active</th>
                
                <th colspan=3>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.users}" var="user">
                <tr>
                    <td><c:out value="${user.idUser}" /></td>
                    <td><c:out value="${user.login}" /></td>
                     <td><c:out value="${user.password}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.role}" /></td>
                    
                    <td><c:choose>
                     <c:when test="${user.active==1}">
                     ACTIVE
                     </c:when>
                    <c:otherwise>
                    NON ACTIVE
                    
                    </c:otherwise>
                    </c:choose>
                   </td>
                    
                    <td><a href="updateuser?idUser=${user.idUser}">Update</a></td>
                    
                    <td><c:choose>
                    
                    <c:when test="${user.idUser==sessionScope.CURRENT_SESSION_ACCOUNT.idUser}">
                    Current Account
                    </c:when>
                    <c:otherwise>
                    <a href="delete?idUser=${user.idUser}" onclick="return confirm('Are you sure you want to delete this account?');">   Delete </a>
                    </c:otherwise>
                    </c:choose>
                    </td>
                     
                      <td><c:choose>
                      <c:when test="${user.idUser==sessionScope.CURRENT_SESSION_ACCOUNT.idUser}">
                      Current Account
                      </c:when>
                     <c:when test="${user.active==1}">
                     <a href="deactivate?idUser=${user.idUser}" > DEACTIVATE</a>
                     </c:when>
                    <c:otherwise>
                     <a href="activate?idUser=${user.idUser}" >ACTIVATE</a>
                    
                    </c:otherwise>
                    </c:choose>
                   </td>
                  
                     
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="newuser">Register new user</a></p>
    <p><a href="newCustomerList">Upload customer list</a></p>
    
     <p><a href="newSupplierList">Upload supplier list</a></p>
     
       <p><a href="newSalesInvoice">Upload sales invoice</a></p>
       
        <p><a href="newSalesInvoiceDetail">Upload sales invoice detail</a></p>
    
    <p><a href="customerlist">List of customers</a></p>
    
    <p><a href="supplierlist">List of suppliers</a></p>
    
     <p><a href="logout">Logout</a></p>
    
    <script type="text/javascript"> </script>
</body>
</html>