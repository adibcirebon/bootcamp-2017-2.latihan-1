

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
                    <td> Kode Dokter </td>
                    <td> Nama Dokter </td>
                    <td> No Ruangan </td>
                    <td> Tanggal Registrasi </td>
                    <td> Tanggal Pulang </td>
                    <td> Aksi </td>
                </tr> 
            </thead>
            <tbody>
                <c:forEach items="${listRawat}" var="rawat">
                    <tr>
                        <td>${rawat.id}</td>
                        <td>${rawat.pasien.nama}</td>
                        <td>${rawat.dokter.nama}</td>
                        <td>${rawat.ruang.nama}</td>
                        <td>${rawat.register}</td>
                        <td>${rawat.checkout}</td>
                        
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
