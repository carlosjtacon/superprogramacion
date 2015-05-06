package com.mario_carlos.pecl3.server

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mario_carlos.pecl3.client.LoginInfo;
import com.mario_carlos.pecl3.client.LoginService;

class Server extends RemoteServiceServlet with LoginService {
  
  def login(requestUri:String):LoginInfo = {
    // TODO Auto-generated method stub
    val userService = UserServiceFactory.getUserService();
    val user = userService.getCurrentUser();
    val loginInfo = new LoginInfo();
    
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