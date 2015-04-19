package frontend;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import backend.Tablero;
import javax.swing.JLabel;

public final class AppGUI {

	private  JFrame frmStarCrush;
	private JButton buttons[];
	private JLabel lblPuntuacion;
	private int puntuacion;
	private String change_aux;
	static Tablero tab;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tab = new Tablero(8,8,7);
					System.out.println("Preparación del tablero inicial: ");
					AppGUI window = new AppGUI(tab.toIntegerList(tab.get_clean_content()));
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
	public AppGUI(List<Integer> tab) {
//		System.out.println(tab.toString());
		initialize(tab);
	}
	
	private List<Integer> listaBotones() {
		List<Integer> l = new ArrayList<Integer>();
		for (int i=0;i<64;i++){
			l.add(getColor(buttons[i].getToolTipText()));
		}
		return l;
	}
	
	private int getColor(String s) {
		String split[] = s.split(",");
		return Integer.valueOf(split[1]);
	}
	
	private int getPosicion(String s) {
		String split[] = s.split(",");
		return Integer.valueOf(split[0]);
	}

	private boolean esValido(int a, int b){
		if((a+1 % 8)==0) {
			//fin de fila
			if(b == a-1 || b==a-8 || b==a+8) return true;
		} else if((a % 8)==0) {
			//inicio de fila
			if(b == a+1 || b==a-8 || b==a+8) return true;
		} else if(b == a-1 || b==a+1 || b==a-8 || b==a+8){
			return true;
		}
		return false;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(List<Integer> tablist) {
		frmStarCrush = new JFrame();
		frmStarCrush.setTitle("Star Crush");
		frmStarCrush.setResizable(false);
		frmStarCrush.setBounds(100, 100, 365, 430);
		frmStarCrush.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStarCrush.getContentPane().setLayout(null);
		
		lblPuntuacion = new JLabel("Puntuación: 0");
		lblPuntuacion.setBounds(6, 386, 353, 16);
		frmStarCrush.getContentPane().add(lblPuntuacion);
		puntuacion=0;
		
		change_aux = "";
		int[] pos = new int[] {5, 50, 95, 140, 185, 230, 275, 320};
		buttons = new JButton[tablist.size()];
		for (int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				buttons[i*8+j] = new JButton();
				buttons[i*8+j].setIcon(new ImageIcon("resources/"+ tablist.get(i*8+j).toString() +".png"));
				buttons[i*8+j].setToolTipText(String.valueOf(i*8+j) +","+ tablist.get(i*8+j).toString()); 
				buttons[i*8+j].setOpaque(false);
				buttons[i*8+j].setContentAreaFilled(false);
				buttons[i*8+j].setBorderPainted(false);
				buttons[i*8+j].setFocusPainted(false);
				
				buttons[i*8+j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton) e.getSource();
						System.out.println(b.getToolTipText());
						if(change_aux == "") {
							System.out.println("Primer boton");
							change_aux = b.getToolTipText(); 
						} else if (!esValido(getPosicion(change_aux), getPosicion(b.getToolTipText()))){
							System.out.println("Movimiento no válido");
							change_aux = "";
						} else {
							System.out.println("Segundo boton");
							List<Integer> lista_inicial = listaBotones();
							buttons[getPosicion(change_aux)].setToolTipText(getPosicion(change_aux) +","+ getColor(b.getToolTipText()));
							buttons[getPosicion(b.getToolTipText())].setToolTipText(getPosicion(b.getToolTipText()) +","+ getColor(change_aux));
							change_aux = "";
							List<Integer> vieja_lista = listaBotones();
							List<Integer> nueva_lista = tab.play_GUI(vieja_lista);
							if(nueva_lista!=null){
								for (int i=0; i<8; i++) {
									for(int j=0; j<8; j++) {
										buttons[i*8+j].setIcon(new ImageIcon("resources/"+ nueva_lista.get(i*8+j+1).toString() +".png"));
										buttons[i*8+j].setToolTipText(String.valueOf(i*8+j) +","+ nueva_lista.get(i*8+j+1).toString()); 
									}
								}
								puntuacion += nueva_lista.get(0);
							}
							
							lblPuntuacion.setText("Puntuación: " + puntuacion);
							List<Integer> lista_final = listaBotones();
							System.out.println("\nlista_inicial: "+lista_inicial);
							System.out.println("vieja_lista: "+vieja_lista);
							System.out.println("nueva_lista: "+nueva_lista);
							System.out.println("lista_final: "+lista_final);
						}
					}
				});
				
				buttons[i*8+j].setBounds(pos[j], pos[i], 40, 40);
				frmStarCrush.getContentPane().add(buttons[i*8+j]);
			}
		}
		
		System.out.println("\n"+tablist);
		System.out.println(listaBotones());
	}
}
