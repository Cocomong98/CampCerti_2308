<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>증명서 발급 시스템</title>
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
                        <h2>전체 캠프 목록</h2>
                        <h5>원하는 캠프를 선택해 정보를 확인하세요!</h5>
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
                                        <img onclick="location.href='/index'" style="width: 50px; height: 50px; padding: 1px;" src="${context}/static/image/camp2.png" alt="camp">
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
        <div class="container">
            <!--
                <a href="/addList">신규 추가</a>
            -->
            <button class="btn-edit" onclick="location.href='/form'">추가</button>
            <hr><br>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">No.</th>
                    <th scope="col">캠프명</th>
                    <th scope="col">기간</th>
                    <th scope="col">인원</th>
                    <th scope="col">선택</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>웹 서비스 캠프</td>
                    <td>2023.07.10 - 2023.08.20</td>
                    <td>31명</td>
                    <td>
                        <button class="btn-enter" onclick="location.href='/camp'">선택</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row">1</th>
                    <td>미리미리 C 캠프</td>
                    <td>2023.07.10 - 2023.08.20</td>
                    <td>39명</td>
                    <td>
                        <button class="btn-enter" onclick="location.href='/camp'">선택</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row">1</th>
                    <td>PPS</td>
                    <td>2023.07.10 - 2023.08.20</td>
                    <td>58명</td>
                    <td>
                        <button class="btn-enter" onclick="location.href='/camp'">선택</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </main>

    <footer class="footer">
        <p>2023_SUM Miniproject</p>
        <p>Copyright © 2023 <b>WALAB</b> All rights reserved.</p>
    </footer>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>

