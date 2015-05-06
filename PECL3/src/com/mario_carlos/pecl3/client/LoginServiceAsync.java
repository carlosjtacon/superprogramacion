package com.mario_carlos.pecl3.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mario_carlos.pecl3.shared.Libro;

public interface LoginServiceAsync {
	public void login(String requestUri, AsyncCallback<LoginInfo> async);
	public void insert(Libro libro, AsyncCallback<Libro> async);
}
