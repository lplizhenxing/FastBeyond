package com.beyond.tools;

import java.util.Vector;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


@SuppressWarnings("unchecked")
public class OnLineUser implements HttpSessionBindingListener {

	private OnLineUser() {
	}

	private static final OnLineUser onLineUser = new OnLineUser();
	
	private static Vector<String> users = new Vector();
	
	public static OnLineUser getOnLineUser(){
		return onLineUser;
	}
	@SuppressWarnings("unused")
	private int i = 1;

	public int getCount() {
		users.trimToSize();
		return (users.capacity()==0 ? 1 : users.capacity());
	}

	public boolean existUser(String userName) {
		users.trimToSize();
		boolean existUser = false;
		for (int i = 0; i < users.capacity(); i++) {
			if (userName.equals(users.get(i).toString())) {
				existUser = true;
				break;
			}
		}
		return existUser;
	}

	public boolean deleteUser(String userName) {
		users.trimToSize();
		if (existUser(userName)) {
			int currUserIndex = -1;
			for (int i = 0; i < users.capacity(); i++) {
				if (userName.equals(users.get(i).toString())) {
					currUserIndex = i;
					break;
				}
			}
			if (currUserIndex != -1) {
				users.remove(currUserIndex);
				users.trimToSize();
				return true;
			}
		}
		return false;
	}

	public void valueBound(HttpSessionBindingEvent e) {
		users.trimToSize();
		if (!existUser(e.getName())) {
			users.add(e.getName());
		}
	}

	public void valueUnbound(HttpSessionBindingEvent e) {
		users.trimToSize();
		deleteUser(e.getName());
	}
}
