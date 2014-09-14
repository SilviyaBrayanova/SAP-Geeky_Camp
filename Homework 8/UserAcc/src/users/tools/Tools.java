package users.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import users.entity.User;
import users.entity.Visit;

public class Tools {
	public static HashSet<User> getUserList(File file) {
		HashSet<User> users = new HashSet<User>();
		if(file.exists()) {
			try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
				users = (HashSet<User>) ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return users;
	}
	
	public static void writeUserList(File file, HashSet<User> users) {
		try(FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(users);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Visit> getVisitsList(File file) {
		List<Visit> visits = new ArrayList<Visit>();
		if(file.exists()) {
			try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
				visits = (List<Visit>) ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return visits;
	}
	
	public static void writeVisitsList(File file, List<Visit> visits) {
		try(FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(visits);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Visit> getLastTenVisits(List<Visit> visits) {
		return visits.subList(Math.max(0, visits.size()-10), visits.size());
	}
	
	public static List<Visit> getLastTenVisitsOfUser(List<Visit> visits, User user) {
		List<Visit> lastTenVisits = new ArrayList<Visit>();
		for(Visit visit : visits) {
			if(visit.getUser().getUsername().equals(user.getUsername())) {
				lastTenVisits.add(visit);
			}
		}
		
		return lastTenVisits.subList(Math.max(0, lastTenVisits.size()-10), lastTenVisits.size());
	}
}
