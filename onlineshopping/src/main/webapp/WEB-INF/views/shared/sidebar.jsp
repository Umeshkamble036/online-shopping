<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 class="my-4">Shop Name</h1>

<div class="list-group">
	<c:forEach items="${categeories}" var="categeory">
		<a href="${contextRoot}/show/categeory/${categeory.id}/products"
			class="list-group-item" id="a_${categeory.name}">${categeory.name}</a>
	</c:forEach>
</div>