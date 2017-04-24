package com.wd.andalas.global.views;

public class AnyComboModel {
	
	/********** Inisiasi **********/
	private String key;
	private String value;
	
	/********** Main Methods **********/
	public AnyComboModel(String key, String value) {
	      this.key = key;
	      this.value = value;
	    }
	
	/********** Setter Getter **********/
	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}
