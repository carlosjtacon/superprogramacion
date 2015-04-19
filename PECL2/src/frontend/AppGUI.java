package frontend;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import backend.Tablero;

public final class AppGUI {
	
	private JFrame frmStarCrush;
	private JFrame frmInit;
	private JFrame frmFinal;

	private JButton buttons[];
	private JLabel lblPuntuacion;
	private int puntuacion;
	private String change_aux;
	private static Tablero tab;
	private int turnos;
	private ImageIcon images[];


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
					window.frmInit.setVisible(true);
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
	
	//devuelve una lista con la lista actual cargada en la GUI
	private List<Integer> listaBotones() {
		List<Integer> l = new ArrayList<Integer>();
		for (int i=0;i<64;i++){
			l.add(getColor(buttons[i].getToolTipText()));
		}
		return l;
	}
	
	//devuelve el color de una tupla
	private int getColor(String s) {
		String split[] = s.split(",");
		return Integer.valueOf(split[1]);
	}
	
	//devuelve la posicion de una tupla
	private int getPosicion(String s) {
		String split[] = s.split(",");
		return Integer.valueOf(split[0]);
	}
	
	//comprueba un movimiento válido
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
		
		frmFinal = new JFrame();
		frmFinal.setTitle("Star Crush");
		frmFinal.setResizable(false);
		frmFinal.setBounds(100, 100, 365, 430);
		frmFinal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFinal.getContentPane().setLayout(null);
		
		JLabel lblPuntos = new JLabel("Puntos:");
		lblPuntos.setBounds(42, 4, 300, 16);
		frmFinal.getContentPane().add(lblPuntos);
		
		frmInit = new JFrame();
		frmInit.setTitle("Star Crush");
		frmInit.setResizable(false);
		frmInit.setBounds(100, 100, 365, 430);
		frmInit.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmInit.getContentPane().setLayout(null);		
		
		JLabel lblMovimientos = new JLabel("Movimientos:");
		lblMovimientos.setBounds(42, 139, 90, 16);
		frmInit.getContentPane().add(lblMovimientos);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(42, 172, 200, 50);
		frmInit.getContentPane().add(spinner);
		
		JLabel lblTurnos = new JLabel("Turnos");
		lblTurnos.setBounds(298, 386, 61, 16);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInit.setVisible(false);
				frmStarCrush.setVisible(true);
				turnos = (int) spinner.getValue();
				lblTurnos.setText("Turnos: "+turnos);
			}
		});
		btnOk.setBounds(42, 263, 117, 29);
		frmInit.getContentPane().add(btnOk);
		
		
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
		
		frmStarCrush.getContentPane().add(lblTurnos);
		
		images = new ImageIcon[7];
		for (int i = 0; i < 7; i++) {
			images[i] = new ImageIcon("resources/"+i+".png");
		}
		
		change_aux = "";
		int[] pos = new int[] {5, 50, 95, 140, 185, 230, 275, 320};
		buttons = new JButton[tablist.size()];
		//se crean todos los botones
		for (int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				buttons[i*8+j] = new JButton();
				buttons[i*8+j].setIcon(images[tablist.get(i*8+j)]);
				buttons[i*8+j].setToolTipText(String.valueOf(i*8+j) +","+ tablist.get(i*8+j).toString()); 
				buttons[i*8+j].setOpaque(false);
				buttons[i*8+j].setContentAreaFilled(false);
				buttons[i*8+j].setBorderPainted(false);
				buttons[i*8+j].setFocusPainted(false);
				
				buttons[i*8+j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton) e.getSource();
						System.out.println(b.getToolTipText());
						//primer boton pulsado
						if(change_aux == "") {
							System.out.println("Primer boton");
							change_aux = b.getToolTipText(); 
						//segundo boton pero no valido
						} else if (!esValido(getPosicion(change_aux), getPosicion(b.getToolTipText()))){
							System.out.println("Movimiento no válido");
							change_aux = "";
						//segundo boton valido
						} else {
							System.out.println("Segundo boton");
							int origen = getPosicion(change_aux);
							int destino = getPosicion(b.getToolTipText());
							int origen_c = getColor(change_aux);
							int destino_c = getColor(b.getToolTipText());
							List<Integer> lista_inicial = listaBotones();
							buttons[origen].setToolTipText(origen +","+ destino_c);
							buttons[destino].setToolTipText(destino +","+ origen_c);
							
							List<Integer> vieja_lista = listaBotones();
							List<Integer> nueva_lista = tab.play_GUI(vieja_lista);
							//si el movimiento hace jugada se ejecuta
							if(nueva_lista!=null){
								for (int i=0; i<8; i++) {
									for(int j=0; j<8; j++) {
										buttons[i*8+j].setIcon(images[nueva_lista.get(i*8+j+1)]);
										buttons[i*8+j].setToolTipText(String.valueOf(i*8+j) +","+ nueva_lista.get(i*8+j+1).toString()); 
									}
								}
								puntuacion += nueva_lista.get(0);
							} else {
								buttons[origen].setToolTipText(origen +","+ origen_c);
								buttons[destino].setToolTipText(destino +","+ destino_c);
							}
							change_aux = "";
							lblPuntuacion.setText("Puntuación: " + puntuacion);
							List<Integer> lista_final = listaBotones();
							System.out.println("\nlista_inicial: "+lista_inicial);
							System.out.println("vieja_lista: "+vieja_lista);
							System.out.println("nueva_lista: "+nueva_lista);
							System.out.println("lista_final: "+lista_final);
							turnos--;
							System.out.println("Turnos:"+turnos);
							lblTurnos.setText("Turnos: "+turnos);
							if (turnos == 0) {
								frmStarCrush.setVisible(false);
								lblPuntos.setText("Puntuacion Final: "+puntuacion);
								frmFinal.setVisible(true);
							}
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
