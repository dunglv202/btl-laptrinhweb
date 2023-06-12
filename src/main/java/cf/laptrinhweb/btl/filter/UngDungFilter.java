package cf.laptrinhweb.btl.filter;

import cf.laptrinhweb.btl.constant.KhoaSession;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static cf.laptrinhweb.btl.helper.HoTroRequest.traVeLoi;
import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

@WebFilter(filterName = "UngDungFilter")
public class UngDungFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        if (request instanceof HttpServletRequest httpRequest) {
            httpRequest.setAttribute("daDangNhap", httpRequest.getSession().getAttribute(KhoaSession.NGUOI_DUNG) != null);

            if (httpRequest.getServletPath().startsWith("/api")) {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                response.setContentType("application/json");
                try {
                    // bat va xu ly loi (exception) ma controller chua handle
                    chain.doFilter(request, response);
                } catch (Exception e) {
                    traVeLoi(httpResponse, SC_INTERNAL_SERVER_ERROR, "Loi da xay ra");
                }
                // api da tu hoan thanh xu ly request va tra ve response => dung cac phan sau
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}