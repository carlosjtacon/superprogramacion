package com.mario_carlos.pecl3.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;

public class GUI implements EntryPoint{

	@Override
	public void onModuleLoad() {

		RootPanel rootPanel = RootPanel.get();

		TabPanel tabPanel = new TabPanel();
		rootPanel.add(tabPanel, 100, 50);
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
		
		TextBox textBox = new TextBox();
		absolutePanel.add(textBox, 183, 8);
		textBox.setSize("157px", "8px");
		
		TextBox textBox_1 = new TextBox();
		absolutePanel.add(textBox_1, 183, 32);
		textBox_1.setSize("157px", "8px");
		
		TextBox textBox_2 = new TextBox();
		absolutePanel.add(textBox_2, 183, 58);
		textBox_2.setSize("157px", "8px");
		
		TextBox textBox_3 = new TextBox();
		absolutePanel.add(textBox_3, 183, 82);
		textBox_3.setSize("157px", "8px");
		
		TextBox textBox_4 = new TextBox();
		absolutePanel.add(textBox_4, 183, 148);
		textBox_4.setSize("157px", "8px");
		
		TextBox textBox_5 = new TextBox();
		absolutePanel.add(textBox_5, 183, 174);
		textBox_5.setSize("157px", "8px");
		
		TextBox textBox_6 = new TextBox();
		absolutePanel.add(textBox_6, 183, 198);
		textBox_6.setSize("157px", "8px");
		
		TextBox textBox_7 = new TextBox();
		absolutePanel.add(textBox_7, 183, 222);
		textBox_7.setSize("157px", "8px");
		
		TextBox textBox_8 = new TextBox();
		absolutePanel.add(textBox_8, 183, 246);
		textBox_8.setSize("157px", "8px");
		
		TextBox textBox_9 = new TextBox();
		absolutePanel.add(textBox_9, 183, 270);
		textBox_9.setSize("157px", "8px");
		
		TextBox textBox_10 = new TextBox();
		absolutePanel.add(textBox_10, 183, 294);
		textBox_10.setSize("157px", "8px");
		
		TextBox textBox_11 = new TextBox();
		absolutePanel.add(textBox_11, 183, 318);
		textBox_11.setSize("157px", "8px");
		
		Button btnInsertar = new Button("Insertar");
		absolutePanel.add(btnInsertar, 268, 380);
	}
}
