package cf.laptrinhweb.btl.filter;

import cf.laptrinhweb.btl.constant.KhoaSession;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("*")
public class UngDungFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            request.setAttribute("daDangNhap", ((HttpServletRequest) request).getSession().getAttribute(KhoaSession.NGUOI_DUNG) != null);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}