package com.mario_carlos.pecl3.server

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mario_carlos.pecl3.client.LoginInfo;
import com.mario_carlos.pecl3.client.ServerService;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer

class ServerServiceImpl extends RemoteServiceServlet with ServerService {
  
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
  
  def modificar(libro:Libro):Libro = {
    val pm = PMF.get.getPersistenceManager
    try{
      val l:Libro = pm.getObjectById(classOf[Libro], libro.getIsbn)
      pm.deletePersistent(l)
      pm.makePersistent(libro)
      pm.close
      return libro
    } catch {
      case t: Throwable =>{
        t.printStackTrace() // TODO: handle error
        pm.close
        return null
      }
    }
  }
  
  def getBooks():java.util.ArrayList[Libro] = {
    val pm = PMF.get().getPersistenceManager();
    val query = pm.newQuery(classOf[Libro]);
    val result:java.util.List[Libro] = query.execute().asInstanceOf[java.util.List[Libro]]
    val libros = pm.detachCopyAll(result).asInstanceOf[java.util.ArrayList[Libro]]
    query.closeAll()
    pm.close()
    return libros
  }
}