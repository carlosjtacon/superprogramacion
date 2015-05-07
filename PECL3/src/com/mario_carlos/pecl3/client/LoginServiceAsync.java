package com.mario_carlos.pecl3.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mario_carlos.pecl3.shared.Libro;

public interface LoginServiceAsync {
	public void login(String requestUri, AsyncCallback<LoginInfo> async);
	public void insert(Libro libro, AsyncCallback<Libro> async);
	public void getBooks(AsyncCallback<ArrayList<Libro>> async);
}
