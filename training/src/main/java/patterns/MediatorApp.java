package patterns;

import java.util.ArrayList;
import java.util.List;

public class MediatorApp {
	public static void main(String[] args){
		TextChat chat = new TextChat();
		
		User admin = new Admin(chat, "Antonina Anatolievna");
		User u1 = new SimpleUser(chat, "Nikolay");
		User u2 = new SimpleUser(chat, "Vanya");
		User u3 = new SimpleUser(chat, "Jenya");
		u2.setEnable(false);
		
		chat.setAdmin(admin);
		chat.addUser(u1);
		chat.addUser(u2);
		chat.addUser(u3);
		
		u1.sendMessage("Hi everyone!");
//		u1.sendMessage("Hi, I'm user.");
//		admin.sendMessage("ADMIN come into the chat!!!");
	}
}

abstract class User {
	Chat chat;
	String name;
	boolean isEnable = true;
	
	public boolean isEnable() {
		return isEnable;
	}
	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}
	
	public User(Chat chat, String name){
		this.chat=chat;
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void sendMessage(String message) {
		chat.sendMessage(message, this);
	}
	
	abstract void getMessage(String message);
	
	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
}

class Admin extends User{

	public Admin(Chat chat, String name) {
		super(chat, name);
	}

	@Override
	public void getMessage(String message) {
		System.out.println("Администратор " + getName() + " получает сообщение: '" + message + "'");
	}
	
}

class SimpleUser extends User{

	public SimpleUser(Chat chat, String name) {
		super(chat, name);
	}

	@Override
	public void getMessage(String message) {
		System.out.println("User " + getName() + " получает сообщение: '" + message + "'");
	}
}

interface Chat {
	void sendMessage(String message, User user);
}

class TextChat implements Chat {
	User admin;
	List<User> users = new ArrayList<>();
	
	public void setAdmin(User admin){
		if(admin!=null && admin instanceof Admin){
			this.admin = admin;
		} else {
			throw new RuntimeException("You don't have permission.");
		}
		
	}

	public void addUser(User user){
		if(user==null){
			throw new RuntimeException("This chat doesn't have admin!");
		}
		
		if(user instanceof SimpleUser){
			users.add(user);
		} else {
			throw new RuntimeException("Admin can't come in at another chat!");
		}
	}
	
	@Override
	public void sendMessage(String message, User user) {
		if(user instanceof Admin){
			for(User u : users){
				u.getMessage(user.getName() + ": " + message);
			}
		}
		
		if(user instanceof SimpleUser){
			for(User u : users){
				if(u!=user && u.isEnable){
					u.getMessage(user.getName() + ": " + message);
				}
			}
			if(admin.isEnable()){
				admin.getMessage(user.getName() + ": " + message);
			}
		}
		
		
		for(User u : users){
			u.getMessage(message);
		}
		admin.getMessage(message);
		
	}
	
}