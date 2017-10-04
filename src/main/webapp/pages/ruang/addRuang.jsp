
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form Ruang</h1>
        <!--${pageContext.servletContext.contextPath}-->
        <form action="${pageContext.servletContext.contextPath}/ruang/new" method="post">
            <div>
                <label for="No_ruangan">No Ruangan</label>
                <input type="text" name="No_ruangan" id="No_ruangan"
            </div>
            <div>
                <label for="ruangKosong">Kosong</label>
                <input type="text" name="ruangKosong" id="ruangKosong"
            </div>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
