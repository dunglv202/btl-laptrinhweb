<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/chung.css" />
    <style>
        @keyframes truotLen {
            0% {
                transform: translateY(50%);
            }
        }
        main {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 60vh;
            gap: 1rem;
            font-size: 1.1rem;
            text-align: center;
            padding-bottom: 50px;
        }
        main .anh {
            height: 183px;
        }
        main .anh img {
            object-fit: contain;
            height: 100%;
        }
        main .noi-dung {
            animation: truotLen 0.2s;
        }
        main .hanh-dong .nut {
            display: inline-block;
            font-size: 1rem;
        }
    </style>
</head>
<body>
    <jsp:include page="components/header.jsp"/>
    <main>
        <div class="anh">
            <img src="<%=request.getContextPath()%>/static/images/golang_1.svg" />
        </div>
        <c:choose>
            <c:when test="${daDangNhap}">
                <div class="noi-dung">
                    <p>Trang không tồn tại hoặc bạn không có quyền truy cập tài nguyên này</p>
                    <div class="hanh-dong">
                        <a href="<%=request.getContextPath()%>/" class="nut kieu-2">
                            <span>Về lại trang chủ</span>
                        </a>
                    </div>
                </div>
            </c:when>
            <c:when test="${!daDangNhap}">
                <div class="noi-dung">
                    <p>Bạn cần đăng nhập trước để truy cập tài nguyên này</p>
                    <div class="hanh-dong">
                        <a href="<%=request.getContextPath()%>/dang-nhap" class="nut kieu-2">
                            <span>Đăng nhập ngay</span>
                        </a>
                    </div>
                </div>
            </c:when>
        </c:choose>
    </main>
    <jsp:include page="components/chan_trang.jsp"/>
</body>
</html>
