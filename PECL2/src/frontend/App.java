package frontend;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class App {

	private JFrame frmStarCrush;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmStarCrush.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStarCrush = new JFrame();
		frmStarCrush.setTitle("Star Crush");
		frmStarCrush.setResizable(false);
		frmStarCrush.setBounds(100, 100, 365, 432);
		frmStarCrush.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStarCrush.getContentPane().setLayout(null);
		
		JButton button_0 = new JButton("");
		button_0.setIcon(new ImageIcon("resources/1.png"));
		button_0.setOpaque(false);
		button_0.setContentAreaFilled(false);
		button_0.setBorderPainted(false);
		button_0.setFocusPainted(false);
		button_0.setSize(40, 40);
		button_0.setBounds(5, 5, 40, 40);
		frmStarCrush.getContentPane().add(button_0);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("resources/2.png"));
		button_1.setOpaque(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setFocusPainted(false);
		button_1.setBounds(50, 5, 40, 40);
		frmStarCrush.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("resources/3.png"));
		button_2.setOpaque(false);
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setFocusPainted(false);
		button_2.setBounds(50, 5, 40, 40);
		button_2.setBounds(95, 5, 40, 40);
		frmStarCrush.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon("resources/4.png"));
		button_3.setOpaque(false);
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		button_3.setFocusPainted(false);
		button_3.setBounds(50, 5, 40, 40);
		button_3.setBounds(140, 5, 40, 40);
		frmStarCrush.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon("resources/5.png"));
		button_4.setOpaque(false);
		button_4.setContentAreaFilled(false);
		button_4.setBorderPainted(false);
		button_4.setFocusPainted(false);
		button_4.setBounds(50, 5, 40, 40);
		button_4.setBounds(185, 5, 40, 40);
		frmStarCrush.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon("resources/6.png"));
		button_5.setOpaque(false);
		button_5.setContentAreaFilled(false);
		button_5.setBorderPainted(false);
		button_5.setFocusPainted(false);
		button_5.setBounds(50, 5, 40, 40);
		button_5.setBounds(230, 5, 40, 40);
		frmStarCrush.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon("resources/7.png"));
		button_6.setOpaque(false);
		button_6.setContentAreaFilled(false);
		button_6.setBorderPainted(false);
		button_6.setFocusPainted(false);
		button_6.setBounds(50, 5, 40, 40);
		button_6.setBounds(275, 5, 40, 40);
		frmStarCrush.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setBounds(320, 5, 40, 40);
		frmStarCrush.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setBounds(5, 50, 40, 40);
		frmStarCrush.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("");
		button_9.setBounds(50, 50, 40, 40);
		frmStarCrush.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.setBounds(95, 50, 40, 40);
		frmStarCrush.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("");
		button_11.setBounds(140, 50, 40, 40);
		frmStarCrush.getContentPane().add(button_11);
		
		JButton button_12 = new JButton("");
		button_12.setBounds(185, 50, 40, 40);
		frmStarCrush.getContentPane().add(button_12);
		
		JButton button_13 = new JButton("");
		button_13.setBounds(230, 50, 40, 40);
		frmStarCrush.getContentPane().add(button_13);
		
		JButton button_14 = new JButton("");
		button_14.setBounds(275, 50, 40, 40);
		frmStarCrush.getContentPane().add(button_14);
		
		JButton button_15 = new JButton("");
		button_15.setBounds(320, 50, 40, 40);
		frmStarCrush.getContentPane().add(button_15);
		
		JButton button_16 = new JButton("");
		button_16.setBounds(5, 95, 40, 40);
		frmStarCrush.getContentPane().add(button_16);
		
		JButton button_17 = new JButton("");
		button_17.setBounds(50, 95, 40, 40);
		frmStarCrush.getContentPane().add(button_17);
		
		JButton button_18 = new JButton("");
		button_18.setBounds(95, 95, 40, 40);
		frmStarCrush.getContentPane().add(button_18);
		
		JButton button_19 = new JButton("");
		button_19.setBounds(140, 95, 40, 40);
		frmStarCrush.getContentPane().add(button_19);
		
		JButton button_20 = new JButton("");
		button_20.setBounds(185, 95, 40, 40);
		frmStarCrush.getContentPane().add(button_20);
		
		JButton button_21 = new JButton("");
		button_21.setBounds(230, 95, 40, 40);
		frmStarCrush.getContentPane().add(button_21);
		
		JButton button_22 = new JButton("");
		button_22.setBounds(275, 95, 40, 40);
		frmStarCrush.getContentPane().add(button_22);
		
		JButton button_23 = new JButton("");
		button_23.setBounds(320, 95, 40, 40);
		frmStarCrush.getContentPane().add(button_23);
		
		JButton button_24 = new JButton("");
		button_24.setBounds(5, 140, 40, 40);
		frmStarCrush.getContentPane().add(button_24);
		
		JButton button_25 = new JButton("");
		button_25.setBounds(50, 140, 40, 40);
		frmStarCrush.getContentPane().add(button_25);
		
		JButton button_26 = new JButton("");
		button_26.setBounds(95, 140, 40, 40);
		frmStarCrush.getContentPane().add(button_26);
		
		JButton button_27 = new JButton("");
		button_27.setBounds(140, 140, 40, 40);
		frmStarCrush.getContentPane().add(button_27);
		
		JButton button_28 = new JButton("");
		button_28.setBounds(185, 140, 40, 40);
		frmStarCrush.getContentPane().add(button_28);
		
		JButton button_29 = new JButton("");
		button_29.setBounds(230, 140, 40, 40);
		frmStarCrush.getContentPane().add(button_29);
		
		JButton button_30 = new JButton("");
		button_30.setBounds(275, 140, 40, 40);
		frmStarCrush.getContentPane().add(button_30);
		
		JButton button_31 = new JButton("");
		button_31.setBounds(320, 140, 40, 40);
		frmStarCrush.getContentPane().add(button_31);
		
		JButton button_32 = new JButton("");
		button_32.setBounds(5, 185, 40, 40);
		frmStarCrush.getContentPane().add(button_32);
		
		JButton button_33 = new JButton("");
		button_33.setBounds(50, 185, 40, 40);
		frmStarCrush.getContentPane().add(button_33);
		
		JButton button_34 = new JButton("");
		button_34.setBounds(95, 185, 40, 40);
		frmStarCrush.getContentPane().add(button_34);
		
		JButton button_35 = new JButton("");
		button_35.setBounds(140, 185, 40, 40);
		frmStarCrush.getContentPane().add(button_35);
		
		JButton button_36 = new JButton("");
		button_36.setBounds(185, 185, 40, 40);
		frmStarCrush.getContentPane().add(button_36);
		
		JButton button_37 = new JButton("");
		button_37.setBounds(230, 185, 40, 40);
		frmStarCrush.getContentPane().add(button_37);
		
		JButton button_38 = new JButton("");
		button_38.setBounds(275, 185, 40, 40);
		frmStarCrush.getContentPane().add(button_38);
		
		JButton button_39 = new JButton("");
		button_39.setBounds(320, 185, 40, 40);
		frmStarCrush.getContentPane().add(button_39);
		
		JButton button_40 = new JButton("");
		button_40.setBounds(5, 230, 40, 40);
		frmStarCrush.getContentPane().add(button_40);
		
		JButton button_41 = new JButton("");
		button_41.setBounds(50, 230, 40, 40);
		frmStarCrush.getContentPane().add(button_41);
		
		JButton button_42 = new JButton("");
		button_42.setBounds(95, 230, 40, 40);
		frmStarCrush.getContentPane().add(button_42);
		
		JButton button_43 = new JButton("");
		button_43.setBounds(140, 230, 40, 40);
		frmStarCrush.getContentPane().add(button_43);
		
		JButton button_44 = new JButton("");
		button_44.setBounds(185, 230, 40, 40);
		frmStarCrush.getContentPane().add(button_44);
		
		JButton button_45 = new JButton("");
		button_45.setBounds(230, 230, 40, 40);
		frmStarCrush.getContentPane().add(button_45);
		
		JButton button_46 = new JButton("");
		button_46.setBounds(275, 230, 40, 40);
		frmStarCrush.getContentPane().add(button_46);
		
		JButton button_47 = new JButton("");
		button_47.setBounds(320, 230, 40, 40);
		frmStarCrush.getContentPane().add(button_47);
		
		JButton button_48 = new JButton("");
		button_48.setBounds(5, 275, 40, 40);
		frmStarCrush.getContentPane().add(button_48);
		
		JButton button_49 = new JButton("");
		button_49.setBounds(50, 275, 40, 40);
		frmStarCrush.getContentPane().add(button_49);
		
		JButton button_50 = new JButton("");
		button_50.setBounds(95, 275, 40, 40);
		frmStarCrush.getContentPane().add(button_50);
		
		JButton button_51 = new JButton("");
		button_51.setBounds(140, 275, 40, 40);
		frmStarCrush.getContentPane().add(button_51);
		
		JButton button_52 = new JButton("");
		button_52.setBounds(185, 275, 40, 40);
		frmStarCrush.getContentPane().add(button_52);
		
		JButton button_53 = new JButton("");
		button_53.setBounds(230, 275, 40, 40);
		frmStarCrush.getContentPane().add(button_53);
		
		JButton button_54 = new JButton("");
		button_54.setBounds(275, 275, 40, 40);
		frmStarCrush.getContentPane().add(button_54);
		
		JButton button_55 = new JButton("");
		button_55.setBounds(320, 275, 40, 40);
		frmStarCrush.getContentPane().add(button_55);
		
		JButton button_56 = new JButton("");
		button_56.setBounds(5, 320, 40, 40);
		frmStarCrush.getContentPane().add(button_56);
		
		JButton button_57 = new JButton("");
		button_57.setBounds(49, 320, 40, 40);
		frmStarCrush.getContentPane().add(button_57);
		
		JButton button_58 = new JButton("");
		button_58.setBounds(94, 320, 40, 40);
		frmStarCrush.getContentPane().add(button_58);
		
		JButton button_59 = new JButton("");
		button_59.setBounds(139, 320, 40, 40);
		frmStarCrush.getContentPane().add(button_59);
		
		JButton button_60 = new JButton("");
		button_60.setBounds(184, 320, 40, 40);
		frmStarCrush.getContentPane().add(button_60);
		
		JButton button_61 = new JButton("");
		button_61.setBounds(229, 320, 40, 40);
		frmStarCrush.getContentPane().add(button_61);
		
		JButton button_62 = new JButton("");
		button_62.setBounds(274, 320, 40, 40);
		frmStarCrush.getContentPane().add(button_62);
		
		JButton button_63 = new JButton("");
		button_63.setBounds(319, 320, 40, 40);
		frmStarCrush.getContentPane().add(button_63);
		
		JButton btnTiempo = new JButton("Tiempo");
		btnTiempo.setBounds(5, 374, 175, 30);
		frmStarCrush.getContentPane().add(btnTiempo);
		
		JButton btnMovimientos = new JButton("Movimientos");
		btnMovimientos.setBounds(185, 374, 175, 30);
		frmStarCrush.getContentPane().add(btnMovimientos);
	}

}
