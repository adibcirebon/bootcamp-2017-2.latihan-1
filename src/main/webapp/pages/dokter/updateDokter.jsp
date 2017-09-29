<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form Dokter</h1>
        <form action="${pageContext.servletContext.contextPath}/dokter/update" method="post">
            <input type="hidden" value="${d.id}" name="dokterId">
            <div>
                <label for="dokterName">Nama Dokter</label>
                <input type="text" name="dokterName" id="dokterName" value="${d.nama}">
            </div>
            <div>
                <label for="dokterSpesialis">Spesialis</label>
                <input type="text" name="dokterSpesialis" id="dokterSpesialis" value="${d.spesialis}">
            </div>
            <div> 
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
            
        </form>
    </body>
</html>