<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bieu_do.css"/>

<div class="bieu-do">
  <canvas id="${param.get('idBieuDo')}" style="width: 100%;"></canvas>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.js"></script>
<script>
  const ctx = document.getElementById("${param.get('idBieuDo')}").getContext("2d");

  const thietLap = {
    type: "bar",
    data: {
      datasets: [
        {
          data: [
            <c:forEach var="banGhi" items="${danhSachDuLieu.danhSachDuLieu}">
            {
              x: "${banGhi.nhan}",
              y: ${banGhi.giaTri},
            },
            </c:forEach>
          ],
          backgroundColor: "#48cab232",
          borderColor: "#48cab2",
          borderWidth: 2
        },
      ],
    },
    options: {
      plugins: {
        title: {
          display: true,
          text: "${danhSachDuLieu.tenDanhSach}",
        },
        legend: {
          display: false,
        },
      },
    },
  };
  const myChart = new Chart(ctx, thietLap);
</script>