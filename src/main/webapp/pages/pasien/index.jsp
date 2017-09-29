
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Daftar Pasien</h1>
        <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>Kode</th>
                <th>Nama Pasien</th>
                <th>Alamat</th>
                <th>Tanggal Lahir</th>
                <th>Aksi</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${listPasien}" var="d" varStatus="index">
            <tr>
                <td>${index.count}</td>  
                <td>${p.id}</td>
                <td>${p.nama}</td>
                <td>${p.alamat}</td>
                <td>${p.tanggal_lahir}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/pasien/update?id=${p.id}">Edit </a>
                    &nbsp;
                    <!--<form action="${pageContext.servletContext.contextPath}/kelas/delete" method="post">
                        <input type="hidden" name="kelasId" value="${k.id}">
                        <button type="submit">Hapus</button>
                        </input>
                    </form>-->
                    <a href="${pageContext.servletContext.contextPath}/pasien/delete?pasienId=${p.id}"}>Hapus</a>
                    
                </td>
            </tr>
        </c:forEach>
        </tbody>
        </table>
    </body>
</html>

