package com.web.Action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
    public String execute() throws Exception {
        return this.SUCCESS;
    }
	public boolean login(){		
		return false;
	}
}
