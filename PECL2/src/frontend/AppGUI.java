package frontend;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public final class AppGUI {

	private static JFrame frmStarCrush;
	public static JButton buttons[];
	private static int change_aux;

	/**
	 * Launch the application.
	 */
	public static void startapp(List<Integer> tab) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AppGUI(tab);
					AppGUI.frmStarCrush.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void refrescar(List<Integer> tab) {
		System.out.println(tab);
		for (int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				buttons[i*8+j].setIcon(new ImageIcon("resources/"+ tab.get(i*8+j).toString() +".png"));
			}
		}
	}

	/**
	 * Create the application.
	 */
	public AppGUI(List<Integer> tab) {
//		System.out.println(tab.toString());
		initialize(tab);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize(List<Integer> tablist) {
		frmStarCrush = new JFrame();
		frmStarCrush.setTitle("Star Crush");
		frmStarCrush.setResizable(false);
		frmStarCrush.setBounds(100, 100, 365, 432);
		frmStarCrush.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStarCrush.getContentPane().setLayout(null);
		
		
		change_aux = (-1);
		int[] pos = new int[] {5, 50, 95, 140, 185, 230, 275, 320};
		buttons = new JButton[tablist.size()];
		for (int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				buttons[i*8+j] = new JButton();
				buttons[i*8+j].setIcon(new ImageIcon("resources/"+ tablist.get(i*8+j).toString() +".png"));
				buttons[i*8+j].setToolTipText(String.valueOf(i*8+j)); 
				buttons[i*8+j].setOpaque(false);
				buttons[i*8+j].setContentAreaFilled(false);
				buttons[i*8+j].setBorderPainted(false);
				buttons[i*8+j].setFocusPainted(false);
				
				buttons[i*8+j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton) e.getSource();
						System.out.println(b.getToolTipText());
						if(change_aux == (-1)) {
							change_aux = Integer.valueOf(b.getToolTipText()); 
						} else {
							Icon ic = buttons[change_aux].getIcon();
							buttons[change_aux].setIcon(b.getIcon());
							buttons[Integer.valueOf(b.getToolTipText())].setIcon(ic);
							change_aux = (-1);
						}
					}
				});
				
				buttons[i*8+j].setBounds(pos[j], pos[i], 40, 40);
				frmStarCrush.getContentPane().add(buttons[i*8+j]);
			}
		}
		
		JButton btnTiempo = new JButton("Tiempo");
		btnTiempo.setBounds(5, 375, 175, 30);
		frmStarCrush.getContentPane().add(btnTiempo);
		
		JButton btnMovimientos = new JButton("Movimientos");
		btnMovimientos.setBounds(185, 375, 175, 30);
		frmStarCrush.getContentPane().add(btnMovimientos);
	}

}
