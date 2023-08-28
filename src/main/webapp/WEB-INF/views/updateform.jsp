<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>새 인원 추가</title>
    <link rel="stylesheet" type="text/css" href="${context}/static/css/list.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<!-- 헤더바 부분, 타 페이지로 이동 가능 -->
<header>
    <div class="px-3 py-2 text-bg-dark">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <!-- 웹사이트 이름 -->
                <a>
                    <h2>인원 정보 수정</h2>
                    <h5>정보 수정 후 확인을 눌러주세요</h5>
                </a>

                <a href="/" class="d-flex align-items-center my-2 my-lg-0 me-lg-auto text-white text-decoration-none">
                    <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
                </a>

                <!-- 페이지 이동 버튼 -->
                <ul class="nav col-12 col-lg-auto my-2 justify-content-center my-md-0 text-small">
                    <!-- 전체 캠프 조회 -->
                    <li>
                        <a href="#" class="nav-link text-secondary text-center">
                            <div class="d-flex flex-column align-items-center">
                                <svg class="bi d-block mx-auto mb-1" width="24" height="24">
                                    <img onclick="location.href='/'" style="width: 50px; height: 50px; padding: 1px;" src="${context}/static/image/camp2.png" alt="camp">
                                </svg>
                                <span>전체 캠프 보기</span>
                            </div>
                        </a>
                    </li>
                    <!-- 다운로드 이력 확인 -->
                    <li>
                        <a href="#" class="nav-link text-secondary text-center">
                            <div class="d-flex flex-column align-items-center">
                                <svg class="bi d-block mx-auto mb-1" width="24" height="24">
                                    <img onclick="location.href='/downLogs'" style="width: 50px; height: 50px; padding: 1px;" src="${context}/static/image/log2.png" alt="log">
                                </svg>
                                <span>다운로드 이력 확인하기</span>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>
<main>
    <br>
    <div class="form-container">
        <form action="updateOk" method="post">
            <input type="hidden" name="id" value="${user.getId()}">
            <input type="text" name="name" value="${user.getName()}"> <br><br>
            <input type="text" name="s_id" value="${user.getS_id()}"> <br><br>
            <input type="text" name="major" value="${user.getMajor()}"> <br><br>
            <input type="text" name="camp" value="${user.getCamp()}"> <br><br>
            <input type="text" name="p_start" value="${user.getP_start()}"> <br><br>
            <input type="text" name="p_end" value="${user.getP_end()}"> <br><br>
            <input type="submit" value="수정 완료">
        </form>
    </div>
    <br>
</main>

<footer class="footer">
    <p>2023_SUM Miniproject</p>
    <p>Copyright © 2023 <b>Cocomong98</b> All rights reserved.</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous">
</script>
</body>
</html>

