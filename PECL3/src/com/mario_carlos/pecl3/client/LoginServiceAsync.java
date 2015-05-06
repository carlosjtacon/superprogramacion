package com.mario_carlos.pecl3.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
	public void login(String requestUri, AsyncCallback<LoginInfo> async);
}
