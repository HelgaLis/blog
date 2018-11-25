<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All authors</title>
</head>
<body>
<div>
<c:forEach var="au" items="${authors}">
<p>${au.id}</p>
<p>${au.name}</p>
<p>${au.age}</p>
<p>${au.gender}</p>
<a	href="<spring:url value="/authors/author?id=${au.id}"/>"> Info </a>
</c:forEach>
</div>
</body>
</html>