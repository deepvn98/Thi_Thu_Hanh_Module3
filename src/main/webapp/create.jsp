<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/6/2021
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>them moi</title>
</head>
<body>
<form action="" method="post">
    <h2 style="color: mediumblue">Student Create Form </h2>
    <table >
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>quality</th>
            <th>color</th>
            <th>describes</th>
            <th>category</th>
            <th>Action</th>
        </tr>
        <tr>
            <td><input type="text" name="name" placeholder="Name"></td>
            <td><input type="number" name="price" placeholder="price"></td>
            <td><input type="number" name="quality" placeholder="quality"></td>
            <td><input type="text" name="color" placeholder="color"></td>
            <td><input type="text" name="describes" placeholder="describes"></td>
            <td>
                <select name="category" id="" multiple>
                    <a:forEach items="${category}" var="category">
                        <option value="${category.id}">${category.name}</option>
                    </a:forEach>
                </select>
            </td>
            <td><input type="submit" value="create"></td>
        </tr>
    </table>
</form>


</body>
</html>
