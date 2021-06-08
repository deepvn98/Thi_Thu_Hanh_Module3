<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/6/2021
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xoá sản phẩm</title>
</head>
<body>
<form action="" method="post">
    <h2 style="color: mediumblue">Product Create Form </h2>
    <table >
        <tr>
            <%--            <th>ID</th>--%>
            <th>Name</th>
            <th>Price</th>
            <th>quality</th>
            <th>color</th>
            <th>describes</th>
            <th>category</th>
            <th>Action</th>
        </tr>

        <tr>
            <%--            <td><input type="text" name="id" value="${product.id}"></td>--%>
            <td><input type="text" name="name" value="${product.name}"></td>
            <td><input type="number" name="price"value="${product.price}" ></td>
            <td><input type="number" name="quality" value="${product.quantity}"></td>
            <td><input type="text" name="color"value=" ${product.color}" ></td>
            <td><input type="text" name="describes" value="${product.describes}"></td>
            <td>
                <select name="category" id="" multiple>
                    <a:forEach items="${category}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </a:forEach>
                </select>
            </td>
            <td><input type="submit" value="remove"></td>
        </tr>
    </table>
</form>

</body>
</html>
