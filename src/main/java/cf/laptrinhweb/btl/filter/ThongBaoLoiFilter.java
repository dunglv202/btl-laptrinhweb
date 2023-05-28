package cf.laptrinhweb.btl.filter;

import cf.laptrinhweb.btl.model.thongbao.ThongBaoTkBiKhoa;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import static cf.laptrinhweb.btl.constant.LoaiLoi.TAI_KHOAN_BI_KHOA;

@WebFilter("*")
public class ThongBaoLoiFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String loi = request.getParameter("loi");
        if (loi != null) {
            switch (loi) {
                case TAI_KHOAN_BI_KHOA -> request.setAttribute("thongBao", new ThongBaoTkBiKhoa());
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
