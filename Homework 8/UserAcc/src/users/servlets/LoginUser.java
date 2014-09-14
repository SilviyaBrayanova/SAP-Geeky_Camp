package users.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import users.entity.User;
import users.entity.Visit;
import users.tools.Tools;

@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File usersFile = new File("users");
		HashSet<User> users = Tools.getUserList(usersFile);
		
		File visitsFile = new File("visits");
		List<Visit> visits = Tools.getVisitsList(visitsFile);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		for(User user : users) {
			if(user.tryLogin(username, password)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("logged", user);
				visits.add(new Visit(user, new Date()));
				Tools.writeVisitsList(visitsFile, visits);
				RequestDispatcher requestDispatcher = null;
				if(user.getRole() == 1) {
					List<Visit> visitsOfUser = Tools.getLastTenVisits(visits);
					request.setAttribute("visitList", visitsOfUser);
					requestDispatcher = request.getRequestDispatcher("admin_index.jsp");
				} else {
					List<Visit> visitsOfUser = Tools.getLastTenVisitsOfUser(visits, user);
					request.setAttribute("visitList", visitsOfUser);
					requestDispatcher = request.getRequestDispatcher("user_index.jsp");
				}
				requestDispatcher.forward(request, response);
				return;
			}
		}	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		request.setAttribute("fail", true);
		requestDispatcher.forward(request, response);
	}
}
