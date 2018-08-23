package ynwa.core.framework;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynwa.core.cache.Cache;
import ynwa.core.entity.Language;

@WebFilter(filterName = "CookieLocaleFilter", urlPatterns = { "/*" })
public class CookieLocaleFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (req.getParameter("lang") != null) {
            Cookie cookie = new Cookie("lang", req.getParameter("lang"));
            res.addCookie(cookie);
            
            Language lang = Cache.LanguageList.Get(req.getParameter("lang"));
            Cookie langName = new Cookie("langName", lang.getName());
            res.addCookie(langName);
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

}