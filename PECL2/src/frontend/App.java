package frontend;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import backend.*;

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
		Tablero tab = new Tablero(8,8,7);
		List<Object> tablist = tab.getListAsJava(tab.clean_table(tab.getContent()));
		System.out.println(tablist.toString());
		initialize(tablist);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(List<Object> tablist) {
		frmStarCrush = new JFrame();
		frmStarCrush.setTitle("Star Crush");
		frmStarCrush.setResizable(false);
		frmStarCrush.setBounds(100, 100, 365, 432);
		frmStarCrush.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStarCrush.getContentPane().setLayout(null);
		
//		int i = 0;

		JButton buttons[];
		int[] pos = new int[] {5, 50, 95, 140, 185, 230, 275, 320};
		buttons = new JButton[tablist.size()];
		for (int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				buttons[i*8+j] = new JButton();
				buttons[i*8+j].setIcon(new ImageIcon("resources/"+ tablist.get(i*8+j).toString() +".png"));
				buttons[i*8+j].setOpaque(false);
				buttons[i*8+j].setContentAreaFilled(false);
				buttons[i*8+j].setBorderPainted(false);
				buttons[i*8+j].setFocusPainted(false);
				buttons[i*8+j].setBounds(pos[i], pos[j], 40, 40);
				frmStarCrush.getContentPane().add(buttons[i*8+j]);
			}
		}
		
		JButton btnTiempo = new JButton("Tiempo");
		btnTiempo.setBounds(5, 374, 175, 30);
		frmStarCrush.getContentPane().add(btnTiempo);
		
		JButton btnMovimientos = new JButton("Movimientos");
		btnMovimientos.setBounds(185, 374, 175, 30);
		frmStarCrush.getContentPane().add(btnMovimientos);
	}

}
