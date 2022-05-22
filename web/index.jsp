<%--
  Created by IntelliJ IDEA.
  User: 徐宇超
  Date: 2022/3/29
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  <h1>文件上传</h1>
  1、要有一个form标签，method为post请求<br>
  2、form标签的encType属性的值必须为multipart/form-data<br>
  encType=multipart/form-data表示提交的数据以多段（每一个表单项一个数据段）的形式进行拼接，然后以二进制流的形式发送给服务器<br>
  boundary表示每段数据的分隔符<br>
  3、在form标签中使用input type=file添加上传的文件<br>
  4、编写服务器代码（servlet程序）接收，处理上传的数据<br><br>
  <form action="http://localhost:8080/fileUploadServlet" method="post" enctype="multipart/form-data" >
    用户名：<input type="text" name="username"><br><br>
    头像：<input type="file" name="photo"><br><br>
    <input type="submit" value="上传头像">
  </form>
  </body>
</html>
