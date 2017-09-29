
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form Ruang</h1>
        <form action="${pageContext.servletContext.contextPath}/ruang/new" method="post">
            <div>
                <label for="ruangName">Nama Ruang</label>
                <input type="text" name="ruangName" id="ruangName">
            </div>
            <div>
                <label for="ruangKosong">Kosong</label>
                <input type="text" name="ruangKosong" id="ruangKosong">
            </div>
            <div> 
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
            
        </form>
    </body>
</html>
