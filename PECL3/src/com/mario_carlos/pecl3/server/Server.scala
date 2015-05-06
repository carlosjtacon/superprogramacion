package com.mario_carlos.pecl3.server

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mario_carlos.pecl3.client.LoginInfo;
import com.mario_carlos.pecl3.client.LoginService;
import com.mario_carlos.pecl3.shared.Libro;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

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
  
  def insert(libro:Libro):Libro = {
    // TODO Auto-generated method stub
    val pm = PMF.get().getPersistenceManager();
    try {
      pm.makePersistent(libro);
    }catch {
      case t: Throwable =>{
        t.printStackTrace() // TODO: handle error
        pm.close
        return null
      }        
    }
    pm.close
    return libro;
  }
  
  def getBooks():java.util.ArrayList[Libro] = {
    val pm = PMF.get().getPersistenceManager();
    val query = pm.newQuery("select from Libro");
    try {
      val libros:java.util.ArrayList[Libro] = query.execute().asInstanceOf[java.util.ArrayList[Libro]];
      query.closeAll()
      return libros
    } catch {
      case t: Throwable =>{
        t.printStackTrace() // TODO: handle error
        query.closeAll()
        return null
      }      
    }
  }
}