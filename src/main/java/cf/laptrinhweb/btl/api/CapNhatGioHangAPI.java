package cf.laptrinhweb.btl.api;

import cf.laptrinhweb.btl.dto.request.DangNhapDTO;
import cf.laptrinhweb.btl.dto.request.CapNhatGioHangDTO;
import cf.laptrinhweb.btl.dto.response.PhanHoiDangNhap;
import cf.laptrinhweb.btl.dto.response.PhanHoiGioHang;
import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.exception.xacthuc.SaiThongTinDangNhapException;
import cf.laptrinhweb.btl.exception.xacthuc.TaiKhoanBiKhoaException;
import cf.laptrinhweb.btl.helper.HoTroJson;
import cf.laptrinhweb.btl.helper.HoTroToken;
import cf.laptrinhweb.btl.service.GioHangService;
import cf.laptrinhweb.btl.service.XacThucService;
import cf.laptrinhweb.btl.service.impl.GioHangServiceImpl;
import cf.laptrinhweb.btl.service.impl.XacThucServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cf.laptrinhweb.btl.api.*;
import cf.laptrinhweb.btl.dto.*;

import java.io.IOException;

import static cf.laptrinhweb.btl.helper.HoTroRequest.traVeLoi;
import static cf.laptrinhweb.btl.helper.HoTroRequest.traVeThanhCong;
import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

@WebServlet("/api/gio-hang/cap-nhat")
public class CapNhatGioHangAPI extends HttpServlet {
    private final GioHangService gioHangService = new GioHangServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        	CapNhatGioHangDTO capNhatGioHangDTO = HoTroJson.layThongTin(req, CapNhatGioHangDTO.class);
            gioHangService.capNhatSoLuong(capNhatGioHangDTO.getMaGio(), capNhatGioHangDTO.getSoLuongMoi());
            traVeThanhCong(
                resp,
                new PhanHoiGioHang("Da cap nhat thanh cong")
            );
        } catch (Exception e) {
            traVeLoi(resp, SC_BAD_REQUEST, "Khong cap nhat duoc gio hang");
        }
    }
}
    
