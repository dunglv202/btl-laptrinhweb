<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Title</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/chung.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/dang_ky.css">
</head>
<body>
	<c:forEach var = "item" items = "${tat_ca_binh_luan}">
		<div> ${item.nguoi_binh_luan.tenHienThi}</div>
		<div> ${item.noi_dung_binh_luan}</div>
		<div>${item.ma_binh_luan_tra_loi}</div>
		<form action = "<%=request.getContextPath()%>/xoa-binh-luan" method = "POST">
			<input type = "hidden" name = "ma_san_pham" value = "${item.san_pham.maSanPham}"/>
			<input type = "hidden" name = "ma_binh_luan" value = "${item.id}"/>
			<button type = "submit"> delete </button>
		</form>
		<form action = "<%=request.getContextPath()%>/tra-loi-binh-luan" method = "GET">
			<input type = "hidden" name = "ma_san_pham" value = "${item.san_pham.maSanPham}"/>
			<input name = "ma_binh_luan" value = "${item.id}" type = "hidden">
			<p>Dien noi dung</p>
			<input name = "noi_dung_tra_loi" value = "">
			<button type = "submit"> tra loi</button>
		</form>
	</c:forEach> 
	<div> </div>
</body>
</html>