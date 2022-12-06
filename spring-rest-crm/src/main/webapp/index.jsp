<%@ page isELIgnored="false"%>
<html>
<body>
<h2>Welcome to our REST API for CRM Project</h2>
<h3>CRUD Operations:</h3>
<a href="${pageContext.request.contextPath }/customers">POST /Customer -> CREATE</a> <br>
<a href="${pageContext.request.contextPath }/customers">GET /Customers ->READ</a><br>
<a href="${pageContext.request.contextPath }/customers/1">GET /Customer/customers/{id} ->READ Single Data </a><br>
<a href="${pageContext.request.contextPath }/customers/1">PUT /Customer /customers/{id} ->Update </a><br>
<a href="${pageContext.request.contextPath }/customers/1">DELETE /Customer /customers/{id} ->Delete </a><br>
</body>
</html>
