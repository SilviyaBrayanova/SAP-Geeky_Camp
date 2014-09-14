package users.filters;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import users.entity.User;
import users.entity.Visit;
import users.tools.Tools;

@WebFilter("/admin_index.jsp")
public class PermissionFilter implements Filter {

    public PermissionFilter() {

    }
    
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		User user = (User) session.getAttribute("logged");
		if(user != null && user.getRole() == 1) {
			List<Visit> visits = Tools.getVisitsList(new File("visits"));
			request.setAttribute("visitList", Tools.getLastTenVisits(visits));
			chain.doFilter(request, response);
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
