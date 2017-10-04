<%-- 
    Document   : addRawat
    Created on : Oct 2, 2017, 3:51:32 PM
    Author     : ADIB PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambah Data Rawat</title>
    </head>
    <body>
        <form action="${pageContext.servletContext.contextPath}/rawat/update-proses" method="post">
            <div>
                <label for="rawatPasienId">Pilih Pasien</label>
                <select name="rawatPasienId" id="rawatPasienId">
                    <c:forEach items="${listPasien}" var="d">
                        <option value="${d.id}">${d.nama}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="rawatDokterId">Pilih Dokter</label>
                <select name="rawatDokterId" id="rawatDokterId">
                    <c:forEach items="${listDokter}" var="d">
                        <option value="${d.id}">${d.nama}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="rawatRuangId">Pilih Ruang</label>
                <select name="rawatRuangId" id="rawatRuangId">
                    <c:forEach items="${listRuang}" var="d">
                        <option value="${d.id}">${d.no_ruangan}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
                
            </div>
        </form>
    </body>
</html>
