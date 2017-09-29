
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form Rawat Pasien</h1>
        <form action="${pageContext.servletContext.contextPath}/rawat/add/proses" method="post">
            <div>
                <label for="idRawat">ID Rawat Pasien</label>
                <input type="number" name="idRawat" id="idRawat" maxlength="8">
            </div>
            
            <div>
                <label for="c">Pilih Pasien</label>
                <select name="pasienRawat" id="c" >
                    <c:forEach items="${listPasien}" var="p">
                     <option value="${p.id}">${p.nama}</option>  
                    </c:forEach>
                </select> 
            </div>
            <div>
                <label for="c">Pilih Dokter</label>
                <select name="dokterRawat" id="c" >
                    <c:forEach items="${listDokter}" var="d">
                     <option value="${d.id}">${d.nama}</option>  
                    </c:forEach>
                </select> 
            </div>
            <div>
                <label for="c">Pilih Ruang</label>
                <select name="ruangRawat" id="c" >
                    <c:forEach items="${listRuang}" var="r">
                     <option value="${r.id}">${r.no_ruangan}</option>  
                    </c:forEach>
                </select> 
            </div>
            <div>
                <label for="waktuRegisterRawat">Waktu Register</label>
                <input type="text" name="waktuRegisterRawat" id="waktuRegisterRawat">
            </div>
            <div>
                <label for="waktuCheckoutRawat">Waktu Pulang</label>
                <input type="text" name="waktuCheckoutRawat" id="waktuCheckoutRawat">
            </div>
            <div> 
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>

        </form>
    </body>
</html>
