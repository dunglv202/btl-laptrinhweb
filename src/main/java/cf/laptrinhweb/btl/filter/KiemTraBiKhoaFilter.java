package cf.laptrinhweb.btl.filter;

import cf.laptrinhweb.btl.constant.KhoaSession;
import cf.laptrinhweb.btl.constant.LoaiLoi;
import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.model.thongbao.ThongBaoTkBiKhoa;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebFilter(filterName = "KiemTraBiKhoaFilter")
public class KiemTraBiKhoaFilter implements Filter {
    private ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Khoi chay filter kiem tra tai khoan bi khoa");
        this.servletContext = filterConfig.getServletContext();
        this.servletContext.setAttribute(KhoaSession.BI_KHOA, new HashSet<>());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        NguoiDung nguoiDung = (NguoiDung) httpRequest.getSession().getAttribute(KhoaSession.NGUOI_DUNG);
        if (nguoiDung != null && daBiKhoa(nguoiDung)) {
            httpRequest.getSession().invalidate();
            ((HttpServletResponse) response).sendRedirect(httpRequest.getContextPath() + "/?loi=" + LoaiLoi.TAI_KHOAN_BI_KHOA);
        } else {
            chain.doFilter(request, response);
        }
    }

    @SuppressWarnings("unchecked")
    private boolean daBiKhoa(NguoiDung nguoiDung) {
        return ((Set<Long>) this.servletContext.getAttribute(KhoaSession.BI_KHOA)).contains(nguoiDung.getMaNguoiDung());
    }

    @Override
    public void destroy() {
        System.out.println("Huy filter kiem tra tai khoan bi khoa");
    }
}
