<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer details</title>
<link type="text/css"
	  rel = "stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Customer relationship manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		<!-- Adding button for adding customer -->
		<input type="button" value="Add Customer" 
			   onClick="window.location.href='showFormForAdd'; return false"
			   class="add-button">
			   
			   <!--  onClick="window.location.href='showFormForAdd'; return false"  ==> this will call our spring controller mapping
			   																			for showFormForAdd --> 
		
			<table>
				<tr>
					<th> First name </th>
					<th> last name </th>
					<th> email </th>
					<th> Action</th>
				</tr>
				
				<!-- Loop over elements -->
				<c:forEach var="tempCustomer"  	items="${customers}">
				<!-- Create update link with customer id -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				
				<c:url var="deleteLink" value="/customer/delete	">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
					<tr> 
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td> 
							<!-- display update link -->
							<a href="${updateLink}"> Update </a>
							|
							<a href="${deleteLink}"
							   onclick = "if(!(confirm('Are you sure ?' ))) return false"> Delete</a>
						</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>


</body>
</html>