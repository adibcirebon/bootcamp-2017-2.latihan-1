
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Daftar Dokter</h1>
        <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>Kode</th>
                <th>Nama Dokter</th>
                <th>Spesialis</th>
                <th>Aksi</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${listDokter}" var="d" varStatus="index">
            <tr>
                <td>${index.count}</td>  
                <td>${d.id}</td>
                <td>${d.nama}</td>
                <td>${d.spesialis}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/dokter/update?id=${d.id}">Edit </a>
                    &nbsp;
                    <!--<form action="${pageContext.servletContext.contextPath}/kelas/delete" method="post">
                        <input type="hidden" name="kelasId" value="${k.id}">
                        <button type="submit">Hapus</button>
                        </input>
                    </form>-->
                    <a href="${pageContext.servletContext.contextPath}/dokter/delete?dokterId=${j.id}"}>Hapus</a>
                    
                </td>
            </tr>
        </c:forEach>
        </tbody>
        </table>
    </body>
</html>

