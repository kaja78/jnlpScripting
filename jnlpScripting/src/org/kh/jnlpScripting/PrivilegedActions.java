package org.kh.jnlpScripting;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PrivilegedActions {
	
	private String testingUrl="http://localhost:8080/jnlpScripting/index.html";

	public String getTestingUrl() {
		return testingUrl;
	}

	public void setTestingUrl(String testingUrl) {
		this.testingUrl = testingUrl;
	}

	public void changeValueOfPrivateField() throws NoSuchFieldException,
			IllegalAccessException {
		PrivateFieldHolder h = new PrivateFieldHolder();
		Field f = h.getClass().getDeclaredField("privateField");
		f.setAccessible(true);
		f.set(h, "changed");
		System.out.println("Value of private field changed.");
	}

	public void makeHTTPConnection() throws IOException, MalformedURLException {
		URLConnection c = new URL(
				getTestingUrl())
				.openConnection();
		System.out.println("Connected to "+getTestingUrl()+". Content length: "
				+ c.getContentLength());
	}
	
}
