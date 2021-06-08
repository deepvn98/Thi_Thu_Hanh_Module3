<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/6/2021
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sachs sanr phaamr</title>
</head>
<body>
<h2><a href="">Link Thêm mới</a></h2>
<br><br>
<h2 style="color: mediumblue">Danh sach sanr pham</h2>
<table border="1 solid" width="50%">
    <tr>
        <th>Name</th>
        <th>price</th>
        <th>quantity</th>
        <th>color</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach items="${product}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.color}</td>
            <td>
                <c:forEach items="${.getCourses()}" var="">
                    <span>${.name}</span>
                </c:forEach>
            </td>




        </tr>
    </c:forEach>

</table>


</body>
</html>
