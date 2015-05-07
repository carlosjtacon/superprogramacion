package com.mario_carlos.pecl3.client;

import java.util.ArrayList;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.mario_carlos.pecl3.shared.Libro;

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

	private LoginInfo loginInfo = null;
	  private VerticalPanel loginPanel = new VerticalPanel();
	  private Label loginLabel = new Label(
	      "Por favor, haz regístrate para acceder al servicio bibliográfico.");
	  private Anchor signInLink = new Anchor("Sign In");
	  private Anchor signOutLink = new Anchor("Sign Out");
	  
	  public void onModuleLoad() {
		  //loadUI();
	    // Check login status using login service.
	    LoginServiceAsync loginService = GWT.create(LoginService.class);
	    loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
	      public void onFailure(Throwable error) {
	      }

	      public void onSuccess(LoginInfo result) {
	        loginInfo = result;
	        if(loginInfo.isLoggedIn()) {
	          loadUI(loginInfo);
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
	  
	  private Libro getLibro(String titulo, ArrayList<Libro> libros) {
		for (Libro libro : libros) {
			if (libro.getTitulo().equals(titulo)) return libro;
		}
		return null;
	  }
	  
	  private void loadUI(LoginInfo user){
		final ArrayList<Libro> libros = new ArrayList<Libro>();
		libros.add(new Libro("The Martian", "autor", "edicion", "res", "editor", "fecha_p", "pag", "isbn", "url", "materia", "portada", "copias"));
		libros.add(new Libro("Moon", "autor", "edicion", "res", "editor", "fecha_p", "pag", "isbn", "url", "materia", "portada", "copias"));
		libros.add(new Libro("Submarine", "autor", "edicion", "res", "editor", "fecha_p", "pag", "isbn", "url", "materia", "portada", "copias"));
		libros.add(new Libro("The Double", "autor", "edicion", "res", "editor", "fecha_p", "pag", "isbn", "url", "materia", "portada", "copias"));
		libros.add(new Libro("True Detective", "autor", "edicion", "res", "editor", "fecha_p", "pag", "isbn", "url", "materia", "portada", "copias"));
		libros.add(new Libro("Game of Thrones", "autor", "edicion", "res", "editor", "fecha_p", "pag", "isbn", "url", "materia", "portada", "copias"));
		libros.add(new Libro("Star Wars", "autor", "edicion", "res", "editor", "fecha_p", "pag", "isbn", "url", "materia", "portada", "copias"));
		libros.add(new Libro("The Hobbit", "autor", "edicion", "res", "editor", "fecha_p", "pag", "isbn", "url", "materia", "portada", "copias"));
		
		
		signOutLink.setHref(loginInfo.getLogoutUrl());
		Label nick = new Label(user.getNickname());
		RootPanel rootPanel = RootPanel.get();
		rootPanel.add(signOutLink,200,1);
		rootPanel.add(nick,1,1);


		TabPanel tabPanel = new TabPanel();
		rootPanel.add(tabPanel, 339, 50);
		tabPanel.setSize("430px", "513px");

		AbsolutePanel absolutePanelView = new AbsolutePanel();
		tabPanel.add(absolutePanelView, "Consultar", false);
		absolutePanelView.setSize("418px", "469px");
		
		Label labelView_0 = new Label("Titulo");
		absolutePanelView.add(labelView_0, 11, 10);
		labelView_0.setSize("32px", "18px");
		
		Label labelView_1 = new Label("Autores");
		absolutePanelView.add(labelView_1, 11, 34);
		labelView_1.setSize("45px", "18px");
		
		Label labelView_2 = new Label("Edicion");
		absolutePanelView.add(labelView_2, 11, 58);
		labelView_2.setSize("43px", "18px");
		
		Label labelView_3 = new Label("Resumen");
		absolutePanelView.add(labelView_3, 11, 82);
		labelView_3.setSize("56px", "18px");
		
		Label labelView_4 = new Label("Editor");
		absolutePanelView.add(labelView_4, 10, 150);
		labelView_4.setSize("34px", "18px");
		
		Label labelView_5 = new Label("Fecha de publicacion");
		absolutePanelView.add(labelView_5, 10, 174);
		labelView_5.setSize("123px", "18px");
		
		Label labelView_6 = new Label("Paginas");
		absolutePanelView.add(labelView_6, 10, 198);
		labelView_6.setSize("47px", "18px");
		
		Label labelView_7 = new Label("ISBN");
		absolutePanelView.add(labelView_7, 11, 222);
		labelView_7.setSize("30px", "18px");
		
		Label labelView_8 = new Label("Enlace (URL)");
		absolutePanelView.add(labelView_8, 11, 246);
		
		Label labelView_9 = new Label("Materia");
		absolutePanelView.add(labelView_9, 11, 270);
		
		Label labelView_10 = new Label("Foto Portada");
		absolutePanelView.add(labelView_10, 11, 294);
		
		Label labelView_11 = new Label("Copias existentes");
		absolutePanelView.add(labelView_11, 11, 318);
		
		final Label labelViewData_0 = new Label("datos demo");
		absolutePanelView.add(labelViewData_0, 183, 8);
		labelViewData_0.setSize("157px", "8px");
		
		final Label labelViewData_1 = new Label("datos demo");
		absolutePanelView.add(labelViewData_1, 183, 32);
		labelViewData_1.setSize("157px", "8px");
		
		final Label labelViewData_2 = new Label("datos demo");
		absolutePanelView.add(labelViewData_2, 183, 58);
		labelViewData_2.setSize("157px", "8px");
		
		final Label labelViewData_3 = new Label("datos demo");
		absolutePanelView.add(labelViewData_3, 183, 82);
		labelViewData_3.setSize("157px", "8px");
		
		final Label labelViewData_4 = new Label("datos demo");
		absolutePanelView.add(labelViewData_4, 183, 148);
		labelViewData_4.setSize("157px", "8px");
		
		final Label labelViewData_5 = new Label("datos demo");
		absolutePanelView.add(labelViewData_5, 183, 174);
		labelViewData_5.setSize("157px", "8px");
		
		final Label labelViewData_6 = new Label("datos demo");
		absolutePanelView.add(labelViewData_6, 183, 198);
		labelViewData_6.setSize("157px", "8px");
		
		final Label labelViewData_7 = new Label("datos demo");
		absolutePanelView.add(labelViewData_7, 183, 222);
		labelViewData_7.setSize("157px", "8px");
		
		final Label labelViewData_8 = new Label("datos demo");
		absolutePanelView.add(labelViewData_8, 183, 246);
		labelViewData_8.setSize("157px", "8px");
		
		final Label labelViewData_9 = new Label("datos demo");
		absolutePanelView.add(labelViewData_9, 183, 270);
		labelViewData_9.setSize("157px", "8px");
		
		final Label labelViewData_10 = new Label("datos demo");
		absolutePanelView.add(labelViewData_10, 183, 294);
		labelViewData_10.setSize("157px", "8px");
		
		final Label labelViewData_11 = new Label("datos demo");
		absolutePanelView.add(labelViewData_11, 183, 318);
		labelViewData_11.setSize("157px", "8px");
		
		AbsolutePanel absolutePanelEdit = new AbsolutePanel();
		tabPanel.add(absolutePanelEdit, "Editar", false);
		absolutePanelEdit.setSize("418px", "469px");
		
		Label labelEdit_0 = new Label("Titulo");
		absolutePanelEdit.add(labelEdit_0, 11, 10);
		labelEdit_0.setSize("32px", "18px");
		
		Label labelEdit_1 = new Label("Autores");
		absolutePanelEdit.add(labelEdit_1, 11, 34);
		labelEdit_1.setSize("45px", "18px");
		
		Label labelEdit_2 = new Label("Edicion");
		absolutePanelEdit.add(labelEdit_2, 11, 58);
		labelEdit_2.setSize("43px", "18px");
		
		Label labelEdit_3 = new Label("Resumen");
		absolutePanelEdit.add(labelEdit_3, 11, 82);
		labelEdit_3.setSize("56px", "18px");
		
		Label labelEdit_4 = new Label("Editor");
		absolutePanelEdit.add(labelEdit_4, 10, 150);
		labelEdit_4.setSize("34px", "18px");
		
		Label labelEdit_5 = new Label("Fecha de publicacion");
		absolutePanelEdit.add(labelEdit_5, 10, 174);
		labelEdit_5.setSize("123px", "18px");
		
		Label labelEdit_6 = new Label("Paginas");
		absolutePanelEdit.add(labelEdit_6, 10, 198);
		labelEdit_6.setSize("47px", "18px");
		
		Label labelEdit_7 = new Label("ISBN");
		absolutePanelEdit.add(labelEdit_7, 11, 222);
		labelEdit_7.setSize("30px", "18px");
		
		Label labelEdit_8 = new Label("Enlace (URL)");
		absolutePanelEdit.add(labelEdit_8, 11, 246);
		
		Label labelEdit_9 = new Label("Materia");
		absolutePanelEdit.add(labelEdit_9, 11, 270);
		
		Label labelEdit_10 = new Label("Foto Portada");
		absolutePanelEdit.add(labelEdit_10, 11, 294);
		
		Label labelEdit_11 = new Label("Copias existentes");
		absolutePanelEdit.add(labelEdit_11, 11, 318);
		
		final TextBox textBoxEdit_0 = new TextBox();
		absolutePanelEdit.add(textBoxEdit_0, 183, 8);
		textBoxEdit_0.setSize("157px", "8px");
		
		final TextBox textBoxEdit_1 = new TextBox();
		absolutePanelEdit.add(textBoxEdit_1, 183, 32);
		textBoxEdit_1.setSize("157px", "8px");
		
		final TextBox textBoxEdit_2 = new TextBox();
		absolutePanelEdit.add(textBoxEdit_2, 183, 58);
		textBoxEdit_2.setSize("157px", "8px");
		
		final TextBox textBoxEdit_3 = new TextBox();
		absolutePanelEdit.add(textBoxEdit_3, 183, 82);
		textBoxEdit_3.setSize("157px", "8px");
		
		final TextBox textBoxEdit_4 = new TextBox();
		absolutePanelEdit.add(textBoxEdit_4, 183, 148);
		textBoxEdit_4.setSize("157px", "8px");
		
		final TextBox textBoxEdit_5 = new TextBox();
		absolutePanelEdit.add(textBoxEdit_5, 183, 174);
		textBoxEdit_5.setSize("157px", "8px");
		
		final TextBox textBoxEdit_6 = new TextBox();
		absolutePanelEdit.add(textBoxEdit_6, 183, 198);
		textBoxEdit_6.setSize("157px", "8px");
		
		final TextBox textBoxEdit_7 = new TextBox();
		absolutePanelEdit.add(textBoxEdit_7, 183, 222);
		textBoxEdit_7.setSize("157px", "8px");
		
		final TextBox textBoxEdit_8 = new TextBox();
		absolutePanelEdit.add(textBoxEdit_8, 183, 246);
		textBoxEdit_8.setSize("157px", "8px");
		
		final TextBox textBoxEdit_9 = new TextBox();
		absolutePanelEdit.add(textBoxEdit_9, 183, 270);
		textBoxEdit_9.setSize("157px", "8px");
		
		final TextBox textBoxEdit_10 = new TextBox();
		absolutePanelEdit.add(textBoxEdit_10, 183, 294);
		textBoxEdit_10.setSize("157px", "8px");
		
		final TextBox textBoxEdit_11 = new TextBox();
		absolutePanelEdit.add(textBoxEdit_11, 183, 318);
		textBoxEdit_11.setSize("157px", "8px");
		
		Button btnEdit = new Button("Guardar");
		btnEdit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String titulo = textBoxEdit_0.getText();
		        String autores = textBoxEdit_1.getText();
		        String edicion = textBoxEdit_2.getText();
		        String resumen = textBoxEdit_3.getText();
		        String editor = textBoxEdit_4.getText();
		        String fecha = textBoxEdit_5.getText();
		        String paginas = textBoxEdit_6.getText();
		        String isbn = textBoxEdit_7.getText();
		        String url = textBoxEdit_8.getText();
		        String materia = textBoxEdit_9.getText();
		        String portada = textBoxEdit_10.getText();
		        String copias = textBoxEdit_11.getText();
		        Libro libroEditado = new Libro(titulo, autores, edicion, resumen, editor, fecha, paginas, isbn, url, materia, portada, copias);
				Window.alert("Has editado los datos de un libro: " + libroEditado.toString());
			}
		});
		absolutePanelEdit.add(btnEdit, 268, 380);
		
		AbsolutePanel absolutePanelInsert = new AbsolutePanel();
		tabPanel.add(absolutePanelInsert, "Insertar", false);
		absolutePanelInsert.setSize("418px", "469px");
		
		Label labelInsert_0 = new Label("Titulo");
		absolutePanelInsert.add(labelInsert_0, 11, 10);
		labelInsert_0.setSize("32px", "18px");
		
		Label labelInsert_1 = new Label("Autores");
		absolutePanelInsert.add(labelInsert_1, 11, 34);
		labelInsert_1.setSize("45px", "18px");
		
		Label labelInsert_2 = new Label("Edicion");
		absolutePanelInsert.add(labelInsert_2, 11, 58);
		labelInsert_2.setSize("43px", "18px");
		
		Label labelInsert_3 = new Label("Resumen");
		absolutePanelInsert.add(labelInsert_3, 11, 82);
		labelInsert_3.setSize("56px", "18px");
		
		Label labelInsert_4 = new Label("Editor");
		absolutePanelInsert.add(labelInsert_4, 10, 150);
		labelInsert_4.setSize("34px", "18px");
		
		Label labelInsert_5 = new Label("Fecha de publicacion");
		absolutePanelInsert.add(labelInsert_5, 10, 174);
		labelInsert_5.setSize("123px", "18px");
		
		Label labelInsert_6 = new Label("Paginas");
		absolutePanelInsert.add(labelInsert_6, 10, 198);
		labelInsert_6.setSize("47px", "18px");
		
		Label labelInsert_7 = new Label("ISBN");
		absolutePanelInsert.add(labelInsert_7, 11, 222);
		labelInsert_7.setSize("30px", "18px");
		
		Label labelInsert_8 = new Label("Enlace (URL)");
		absolutePanelInsert.add(labelInsert_8, 11, 246);
		
		Label labelInsert_9 = new Label("Materia");
		absolutePanelInsert.add(labelInsert_9, 11, 270);
		
		Label labelInsert_10 = new Label("Foto Portada");
		absolutePanelInsert.add(labelInsert_10, 11, 294);
		
		Label labelInsert_11 = new Label("Copias existentes");
		absolutePanelInsert.add(labelInsert_11, 11, 318);
		
		final TextBox textBoxInsert_0 = new TextBox();
		absolutePanelInsert.add(textBoxInsert_0, 183, 8);
		textBoxInsert_0.setSize("157px", "8px");
		
		final TextBox textBoxInsert_1 = new TextBox();
		absolutePanelInsert.add(textBoxInsert_1, 183, 32);
		textBoxInsert_1.setSize("157px", "8px");
		
		final TextBox textBoxInsert_2 = new TextBox();
		absolutePanelInsert.add(textBoxInsert_2, 183, 58);
		textBoxInsert_2.setSize("157px", "8px");
		
		final TextBox textBoxInsert_3 = new TextBox();
		absolutePanelInsert.add(textBoxInsert_3, 183, 82);
		textBoxInsert_3.setSize("157px", "8px");
		
		final TextBox textBoxInsert_4 = new TextBox();
		absolutePanelInsert.add(textBoxInsert_4, 183, 148);
		textBoxInsert_4.setSize("157px", "8px");
		
		final TextBox textBoxInsert_5 = new TextBox();
		absolutePanelInsert.add(textBoxInsert_5, 183, 174);
		textBoxInsert_5.setSize("157px", "8px");
		
		final TextBox textBoxInsert_6 = new TextBox();
		absolutePanelInsert.add(textBoxInsert_6, 183, 198);
		textBoxInsert_6.setSize("157px", "8px");
		
		final TextBox textBoxInsert_7 = new TextBox();
		absolutePanelInsert.add(textBoxInsert_7, 183, 222);
		textBoxInsert_7.setSize("157px", "8px");
		
		final TextBox textBoxInsert_8 = new TextBox();
		absolutePanelInsert.add(textBoxInsert_8, 183, 246);
		textBoxInsert_8.setSize("157px", "8px");
		
		final TextBox textBoxInsert_9 = new TextBox();
		absolutePanelInsert.add(textBoxInsert_9, 183, 270);
		textBoxInsert_9.setSize("157px", "8px");
		
		final TextBox textBoxInsert_10 = new TextBox();
		absolutePanelInsert.add(textBoxInsert_10, 183, 294);
		textBoxInsert_10.setSize("157px", "8px");
		
		final TextBox textBoxInsert_11 = new TextBox();
		absolutePanelInsert.add(textBoxInsert_11, 183, 318);
		textBoxInsert_11.setSize("157px", "8px");
		
		Button btnInsert = new Button("Insertar");
		btnInsert.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String titulo = textBoxInsert_0.getText();
		        String autores = textBoxInsert_1.getText();
		        String edicion = textBoxInsert_2.getText();
		        String resumen = textBoxInsert_3.getText();
		        String editor = textBoxInsert_4.getText();
		        String fecha = textBoxInsert_5.getText();
		        String paginas = textBoxInsert_6.getText();
		        String isbn = textBoxInsert_7.getText();
		        String url = textBoxInsert_8.getText();
		        String materia = textBoxInsert_9.getText();
		        String portada = textBoxInsert_10.getText();
		        String copias = textBoxInsert_11.getText();
		        Libro nuevoLibro = new Libro(titulo, autores, edicion, resumen, editor, fecha, paginas, isbn, url, materia, portada, copias);
				Window.alert("Has insertado un nuevo libro: " + nuevoLibro.toString());
			}
		});
		absolutePanelInsert.add(btnInsert, 268, 380);
		
		ArrayList<String> libros_str = new ArrayList<String>();
		for (int i = 0; i < libros.size(); i++) {
			libros_str.add(libros.get(i).getTitulo());
		}
		
		TextCell textCell = new TextCell();
		CellList<String> cellBookList = new CellList<String>(textCell);
		cellBookList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
	    cellBookList.setSelectionModel(selectionModel);
	    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
	      public void onSelectionChange(SelectionChangeEvent event) {
	        String selected = selectionModel.getSelectedObject();
	        if (selected != null) {
	          labelViewData_0.setText(getLibro(selected, libros).getTitulo());
	          labelViewData_1.setText(getLibro(selected, libros).getAutores());
	          labelViewData_2.setText(getLibro(selected, libros).getEdicion());
	          labelViewData_3.setText(getLibro(selected, libros).getResumen());
	          labelViewData_4.setText(getLibro(selected, libros).getEditor());
	          labelViewData_5.setText(getLibro(selected, libros).getFecha_p());
	          labelViewData_6.setText(getLibro(selected, libros).getPaginas());
	          labelViewData_7.setText(getLibro(selected, libros).getIsbn());
	          labelViewData_8.setText(getLibro(selected, libros).getEnlace());
	          labelViewData_9.setText(getLibro(selected, libros).getMateria());
	          labelViewData_10.setText(getLibro(selected, libros).getPortada());
	          labelViewData_11.setText(getLibro(selected, libros).getCopias());
	          textBoxEdit_0.setText(getLibro(selected, libros).getTitulo());
	          textBoxEdit_1.setText(getLibro(selected, libros).getAutores());
	          textBoxEdit_2.setText(getLibro(selected, libros).getEdicion());
	          textBoxEdit_3.setText(getLibro(selected, libros).getResumen());
	          textBoxEdit_4.setText(getLibro(selected, libros).getEditor());
	          textBoxEdit_5.setText(getLibro(selected, libros).getFecha_p());
	          textBoxEdit_6.setText(getLibro(selected, libros).getPaginas());
	          textBoxEdit_7.setText(getLibro(selected, libros).getIsbn());
	          textBoxEdit_8.setText(getLibro(selected, libros).getEnlace());
	          textBoxEdit_9.setText(getLibro(selected, libros).getMateria());
	          textBoxEdit_10.setText(getLibro(selected, libros).getPortada());
	          textBoxEdit_11.setText(getLibro(selected, libros).getCopias());
	        }
	      }
	    });

	    cellBookList.setRowCount(libros_str.size(), true);
	    cellBookList.setRowData(0, libros_str);

		rootPanel.add(cellBookList, 66, 50);
		cellBookList.setSize("267px", "514px");
	}
	
}
