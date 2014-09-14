package users.entity;

import java.io.Serializable;
import java.util.Date;

public class Visit implements Serializable {
	private static final long serialVersionUID = 6473851761749932906L;
	private User user;
	private Date date;
	
	public Visit(User user, Date date) {
		this.user = user;
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public Date getDate() {
		return date;
	}
}
