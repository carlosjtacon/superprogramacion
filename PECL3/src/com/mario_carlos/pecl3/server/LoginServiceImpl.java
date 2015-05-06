package com.mario_carlos.pecl3.server;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mario_carlos.pecl3.client.LoginInfo;
import com.mario_carlos.pecl3.client.LoginService;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService{

	@Override
	public LoginInfo login(String requestUri) {
		// TODO Auto-generated method stub
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		LoginInfo loginInfo = new LoginInfo();
		
		if (user != null) {
			loginInfo.setLoggedIn(true);
		      loginInfo.setEmailAddress(user.getEmail());
		      loginInfo.setNickname(user.getNickname());
		      loginInfo.setLogoutUrl(userService.createLogoutURL(requestUri));
		}else{
			loginInfo.setLoggedIn(false);
		      loginInfo.setLoginUrl(userService.createLoginURL(requestUri));
		}		
		return loginInfo;
	}

}
