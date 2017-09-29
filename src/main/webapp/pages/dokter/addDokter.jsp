<%-- 
    Document   : addDokter
    Created on : Sep 27, 2017, 2:33:31 PM
    Author     : ADIB PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form Dokter</h1>
        <form action="${pageContext.servletContext.contextPath}/dokter/new" method="post">
            <div>
                <label for="DokterName">Nama Dokter</label>
                <input type="text" name="dokterName" id="dokterName">
            </div>
            <div>
                <label for="DokterSpesialis">Spesialis</label>
                <input type="text" name="dokterSpesialis" id="dokterSpesialis">
            </div>
            <div> 
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
            
        </form>
    </body>
</html>
