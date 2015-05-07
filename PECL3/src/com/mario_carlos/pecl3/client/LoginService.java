package com.mario_carlos.pecl3.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.mario_carlos.pecl3.server.Libro;

@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService{
	public LoginInfo login(String requestUri);
	public Libro insert(Libro libro);
	public ArrayList<Libro> getBooks();
}
