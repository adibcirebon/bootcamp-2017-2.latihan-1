
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Daftar Ruang</h1>
        <a href="${pageContext.servletContext.contextPath}/ruang/new">Add</a>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Kode</th>
                    <th>No Ruangan</th>
                    <th>Kosong</th>
                    <th>Aksi</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listRuang}" var="r" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${r.id}</td>
                        <td>${r.no_ruangan}</td>
                        <td>${r.kosong}</td>
                        <td>
                            <a href="${pageContext.servletContext.contextPath}/ruang/update?id=${r.id}">Update</a>
                            &nbsp;
                            <a href="${pageContext.servletContext.contextPath}/ruang/delete?id=${r.id}">Delete</a>
                            
<!--                            <form action="${pageContext.servletContext.contextPath}/ruang/delete" method="post">
                                <input type="hidden" name="ruangId" value="${r.id}">
                                <button type="submit">Hapus</button>
                                </input>
                            </form>-->
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
