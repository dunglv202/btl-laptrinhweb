<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dashboard</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/chung.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/trang_admin.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/dashboard.css"/>
  </head>
  <body>
    <jsp:include page="components/menu_admin.jsp">
      <jsp:param name="mucHienTai" value="dashboard"/>
    </jsp:include>
    <main>
      <% request.setAttribute("danhSachDuLieu", request.getAttribute("doanhThuThang")); %>
      <jsp:include page="components/bieu_do.jsp">
        <jsp:param name="idBieuDo" value="doanh-thu-thang"/>
      </jsp:include>
    </main>
  </body>
</html>
