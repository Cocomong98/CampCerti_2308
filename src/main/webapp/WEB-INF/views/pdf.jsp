<%--
  Created by IntelliJ IDEA.
  User: cocomong_98
  Date: 2023/08/23
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="application/pdf" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>PDF View</title>
    </head>
    <body>
            <%-- PDF 뷰에서 생성한 내용을 표시하는 부분 --%>
        <table>
            <c:forEach items="${list}" var="language">
                <tr>
                    <td>${language}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
