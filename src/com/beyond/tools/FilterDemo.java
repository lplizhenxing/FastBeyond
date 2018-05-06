package com.beyond.tools;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.beyond.pojo.BeyondUser;

/**
 * @ClassName: FilterDemo
 * @Description: 过滤器，对于非法登录或者登陆超时等问题进行拦截)
 */
public class FilterDemo implements Filter {

	private Logger logger = Logger.getLogger(FilterDemo.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String request_uri = req.getRequestURI();
		String ctxPath = req.getContextPath();
		String uri = request_uri.substring(ctxPath.length());
		req.getSession().getServletContext()
				.setAttribute("urlsource", uri.substring(1, uri.length()));
		if (uri.equals("/") || uri.equals("/auth.jsp")
				|| uri.equals("/login!userLogin.action")
				|| uri.equals("/login.jsp")) {
			chain.doFilter(req, res);
			return;
		} else {
			Object userId = session.getAttribute("userId");
			if (userId == null || userId.equals("") || userId.equals("null")) {
				if (req.getHeader("x-requested-with") != null
						&& req.getHeader("X-Requested-With").equals(
								"XMLHttpRequest")) { // ajax请求
					logger.warn("用户已过期，请刷新页面重新登录！");
					PrintWriter out = response.getWriter();
					out.println("{\"sessionTimeout\":true, \"vrows\":-1, \"msg\":\"用户已过期，请刷新页面重新登录！\"}");
					out.flush();
					return;
				} else { // 非ajax请求
					logger.warn("用户已过期，请刷新页面重新登录！");
					res.sendRedirect(req.getContextPath() + "/login.jsp");
					return;
				}
			} else {
				BeyondUser u = (BeyondUser) req.getSession().getAttribute(
						"user");
				if (u != null) {
					logger.warn("在线人数：" + OnLineUser.getOnLineUser().getCount()
							+ " ，用户" + u.getUserName() + "(" + u.getUserLogin()
							+ ")，URL：" + uri);
				}
				chain.doFilter(req, res);
				return;
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void destroy() {

	}

}
