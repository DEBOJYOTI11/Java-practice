package com.nissan.training.corejava.project.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IInputInterface {
	
	public abstract void takeInput(HttpServletRequest request, HttpServletResponse response);

}
