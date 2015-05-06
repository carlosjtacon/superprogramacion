package com.mario_carlos.pecl3.client;

import com.mario_carlos.pecl3.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TabPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PECL3 implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);


	private LoginInfo loginInfo = null;
	  private VerticalPanel loginPanel = new VerticalPanel();
	  private Label loginLabel = new Label(
	      "Please sign in to your Google Account to access the StockWatcher application.");
	  private Anchor signInLink = new Anchor("Sign In");

	  public void onModuleLoad() {
	    // Check login status using login service.
	    LoginServiceAsync loginService = GWT.create(LoginService.class);
	    loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
	      public void onFailure(Throwable error) {
	      }

	      public void onSuccess(LoginInfo result) {
	        loginInfo = result;
	        if(loginInfo.isLoggedIn()) {
	          loadUI();
	        } else {
	          loadLogin();
	        }
	      }
	    });
	  }

	  private void loadLogin() {
	    // Assemble login panel.
	    signInLink.setHref(loginInfo.getLoginUrl());
	    loginPanel.add(loginLabel);
	    loginPanel.add(signInLink);
	    RootPanel.get().add(loginPanel);
	  }
	private void loadUI(){
		
		RootPanel rootPanel = RootPanel.get();
		
		TabPanel tabPanel = new TabPanel();
		rootPanel.add(tabPanel, 10, 10);
		tabPanel.setSize("430px", "513px");
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		tabPanel.add(absolutePanel, "New tab", false);
		absolutePanel.setSize("418px", "469px");
		
		Label label = new Label("Titulo");
		absolutePanel.add(label, 11, 10);
		label.setSize("32px", "18px");
		
		Label label_1 = new Label("Autores");
		absolutePanel.add(label_1, 11, 34);
		label_1.setSize("45px", "18px");
		
		Label label_2 = new Label("Edicion");
		absolutePanel.add(label_2, 11, 58);
		label_2.setSize("43px", "18px");
		
		Label label_3 = new Label("Resumen");
		absolutePanel.add(label_3, 11, 82);
		label_3.setSize("56px", "18px");
		
		Label label_4 = new Label("Editor");
		absolutePanel.add(label_4, 10, 150);
		label_4.setSize("34px", "18px");
		
		Label label_5 = new Label("Fecha de publicacion");
		absolutePanel.add(label_5, 10, 174);
		label_5.setSize("123px", "18px");
		
		Label label_6 = new Label("Paginas");
		absolutePanel.add(label_6, 10, 198);
		label_6.setSize("47px", "18px");
		
		Label label_7 = new Label("ISBN");
		absolutePanel.add(label_7, 11, 222);
		label_7.setSize("30px", "18px");
		
		Label lblEnlace = new Label("Enlace (URL)");
		absolutePanel.add(lblEnlace, 11, 246);
		
		Label lblMateria = new Label("Materia");
		absolutePanel.add(lblMateria, 11, 270);
		
		Label lblFotoPortada = new Label("Foto Portada");
		absolutePanel.add(lblFotoPortada, 11, 294);
		
		Label lblNewLabel = new Label("Copias existentes");
		absolutePanel.add(lblNewLabel, 11, 318);
	}
}
