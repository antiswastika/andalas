package com.wd.andalas.global;

import java.util.HashMap;
import java.util.Map;

public class Singleton {
	private static Singleton instance;
	private Map<String, Object> allObjects = new HashMap<String, Object>();
	private String singletonId = "";

	/*********************************** MAIN CODE ***********************************/
	/* A private Constructor prevents any other class from instantiating. */
	private Singleton() {
		// Exists only to defeat instantiation.
	}

	/*********************************** CUSTOM METHODS ***********************************/
	/* Other methods protected by singleton-ness */
	public static String showMessage( ) {
		String msg = "Halo, ini dari singleton!";
		return msg;
	}

	/*********************************** SETTER GETTER ***********************************/
	/* Static 'instance' method */
	public static synchronized Singleton getInstance( ) {
		synchronized (Singleton.class) {
			if(instance == null){
				instance = new Singleton();
			}
		}
		return instance;
	}

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
