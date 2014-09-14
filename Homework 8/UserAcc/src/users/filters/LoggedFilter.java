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

@WebFilter("/user_index.jsp")
public class LoggedFilter implements Filter {

    public LoggedFilter() {

    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		User user = (User) session.getAttribute("logged");
		if(user != null) {
			List<Visit> visits = Tools.getVisitsList(new File("visits"));
			request.setAttribute("visitList", Tools.getLastTenVisitsOfUser(visits, user));
			chain.doFilter(request, response);
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
