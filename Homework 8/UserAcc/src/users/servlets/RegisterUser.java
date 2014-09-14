package users.servlets;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import users.entity.User;
import users.tools.Tools;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File usersFile = new File("users");
		HashSet<User> users = Tools.getUserList(usersFile);
		
		String newUsername = request.getParameter("username");
		String newEmail = request.getParameter("email");
		String newPassword = request.getParameter("password");
		boolean isAdmin = request.getParameter("isAdmin") != null;
		User newUser = new User(newUsername, newEmail, newPassword, isAdmin);
		
		if(users.add(newUser)) {
			Tools.writeUserList(usersFile, users);
			request.setAttribute("success", true);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		} else {
			request.setAttribute("exists", true);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
