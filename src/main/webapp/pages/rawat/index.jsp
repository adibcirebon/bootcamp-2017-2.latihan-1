

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DAFTAR RAWAT PASIEN</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <td> Kode </td>
                    <td> Nama Pasien </td>
                    <td> Nama Dokter </td>
                    <td> Nama Ruang </td>
                    <td> Waktu Registrasi </td>
                    <td> Waktu Pulang </td>
                    <td> Aksi </td>
                </tr> 
            </thead>
            <tbody>
                <c:forEach items="${listRawat}" var="rwt">
                    <tr>
                        <td>${rwt.id}</td>
                        <td>${rwt.pasien.nama}</td>
                        <td>${rwt.dokter.nama}</td>
                        <td>${rwt.ruang.nama}</td>
                        <td>${rwt.register}</td>
                        <td>${rwt.checkout}</td>
                        
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
