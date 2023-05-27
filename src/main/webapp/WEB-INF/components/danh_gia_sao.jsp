<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/danh_gia.css" />

<div class="danh-gia">
  <span class="sao ${param.saoDanhGia == '1' ? 'hien-tai' : ''}"></span>
  <span class="sao ${param.saoDanhGia == '2' ? 'hien-tai' : ''}"></span>
  <span class="sao ${param.saoDanhGia == '3' ? 'hien-tai' : ''}"></span>
  <span class="sao ${param.saoDanhGia == '4' ? 'hien-tai' : ''}"></span>
  <span class="sao ${param.saoDanhGia == '5' ? 'hien-tai' : ''}"></span>
</div>