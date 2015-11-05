package org.kh.jnlpScripting;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Main {
	
	public static final String NASHORN_COMPAT_SCRIPT = "if (typeof importClass != \"function\") { load(\"nashorn:mozilla_compat.js\"); }";
	
	public static void main(String[] args) {
		Main main=new Main();
		ScriptEngine scriptEngine=new ScriptEngineManager().getEngineByName("javascript");
		System.out.println("Using script engine: "+scriptEngine.getClass().getName());
		scriptEngine.put("main", main);
		
		System.out.println("Executing doPrivilegedAction() from java code.");
		try {
			main.doPrivilegedAction();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Executing doPrivilegedAction() from ScriptEngine.");		
		try {
			scriptEngine.eval(NASHORN_COMPAT_SCRIPT);
			scriptEngine.eval("main.doPrivilegedAction()");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPrivilegedAction() throws Exception{
		PrivilegedActions actions=new PrivilegedActions();
		actions.makeHTTPConnection();		
		actions.changeValueOfPrivateField();
	}

	
}
