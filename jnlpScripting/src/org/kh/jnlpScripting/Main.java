package org.kh.jnlpScripting;

import java.net.URL;
import java.net.URLConnection;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Main {
	
	public static void main(String[] args) {
		Main main=new Main();
		ScriptEngine scriptEngine=new ScriptEngineManager().getEngineByName("javascript");
		scriptEngine.put("main", main);
		
		System.out.println("Executing doPrivilegedAction() from java code.");
		try {
			main.doPrivilegedAction();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Executing doPrivilegedAction() from ScriptEngine.");		
		try {
			scriptEngine.eval("main.doPrivilegedAction()");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPrivilegedAction() throws Exception{
		URLConnection c=new URL("http://localhost:8080/jnlpScripting/index.html").openConnection();
		System.out.println(c.getContentLength());
	}
}
