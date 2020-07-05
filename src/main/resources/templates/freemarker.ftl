<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>movie in freemarker template</title>
</head>
<body>
<table border="1" bgcolor="#556b2f">
    <thead>
    <tr>
        <th>图书名称</th>
        <th>图书作者</th>
        <th>图书价格</th>
    </tr>
    </thead>
    <tbody>
    <#if books ??&& (books?size > 0)>
        <#list books as movie>
            <tr>
            <td>${movie.name}</td>
            <td>${movie.author}</td>
            <td>${movie.price}</td>
            </tr>
        </#list>
    </#if>
    </tbody>
</table>
</body>
</html>