package geeky.camp.jpa;

import geeky.camp.jpa.dao.StudentDAO;
import geeky.camp.jpa.entities.Student;

import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppLauncher {
	public static void main(String[] args) {
		// The annotations for table relations just don't work :(
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("geeky.camp");
		StudentDAO studentDAO = new StudentDAO(emf);
		studentDAO.createNewStudent("mincho", "mincho", new Date(), 17);
		Student studentByFn = studentDAO.findByPrimaryKey(1);
		System.out.println("Found student : " + studentByFn);
		studentByFn.setFirstName("spascho");
		studentDAO.updateStudent(studentByFn);
		studentDAO.deleteStudent(studentByFn.getFacultyNumber());
	}
}
