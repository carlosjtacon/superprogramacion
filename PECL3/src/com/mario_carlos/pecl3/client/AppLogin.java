package com.mario_carlos.pecl3.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;

public class AppLogin implements EntryPoint{
	public void onModuleLoad() {

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		loadUI();

	}
	private void loadUI(){
		
		TabPanel tabPanel = new TabPanel();
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
