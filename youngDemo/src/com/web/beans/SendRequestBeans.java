package com.web.beans;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SendRequestBeans {
	private String message;
	private String SUCCESS;
	private String state;
	private String data;
	private String ERROR;
	private String WARN;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSUCCESS() {
		return SUCCESS;
	}
	public void setSUCCESS(String sUCCESS) {
		SUCCESS = sUCCESS;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getERROR() {
		return ERROR;
	}
	public void setERROR(String eRROR) {
		ERROR = eRROR;
	}
	public String getWARN() {
		return WARN;
	}
	public void setWARN(String wARN) {
		WARN = wARN;
	}
	
}
