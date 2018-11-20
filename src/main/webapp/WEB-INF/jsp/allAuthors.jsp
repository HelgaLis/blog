<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</c:forEach>
</div>
</body>
</html>