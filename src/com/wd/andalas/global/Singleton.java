package com.wd.andalas.global;

import java.util.HashMap;
import java.util.Map;

public class Singleton {
	
	/********** Inisiasi **********/
	private static Singleton instance;
	private Map<String, Object> allObjects = new HashMap<String, Object>();
	private String singletonId = "";

	/********** Main Methods **********/
	private Singleton() { }
	
	/* Static 'instance' method */
	public static synchronized Singleton getInstance( ) {
		synchronized (Singleton.class) {
			if(instance == null){
				instance = new Singleton();
			}
		}
		return instance;
	}

	/********** Custom Methods **********/
	public static String showMessage( ) {
		String msg = "Halo, ini dari singleton!";
		return msg;
	}
	
	/********** Setter Getter **********/
	public String getSingletonId() {
		return singletonId;
	}
	public void setSingletonId(String singletonId) {
		this.singletonId = singletonId;
	}

	public Map<String, Object> getAllObjects() {
		return allObjects;
	}
	public void setAllObjects(Map<String, Object> allObjects) {
		this.allObjects = allObjects;
	}

}
