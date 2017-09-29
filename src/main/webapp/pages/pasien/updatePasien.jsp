<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form Pasien</h1>
        <form action="${pageContext.servletContext.contextPath}/pasien/update" method="post">
            <input type="hidden" value="${p.id}" name="pasienId">
            <div>
                <label for="pasienName">Nama Pasien</label>
                <input type="text" name="pasienName" id="pasienName" value="${p.nama}">
            </div>
            <div>
                <label for="pasienAlamat">Alamat</label>
                <input type="text" name="pasienAlamat" id="pasienAlamat" value="${p.alamat}">
            </div>
            <div>
                <label for="pasienTanggalLahir">Tanggal Lahir</label>
                <input type="text" name="pasienTanggalLahir" id="pasienTanggalLahir" value="${p.tanggal_lahir}">
            </div>
            <div> 
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
            
        </form>
    </body>
</html>