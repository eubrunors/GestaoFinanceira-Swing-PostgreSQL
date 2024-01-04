package app.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setTitle("Despesas Pessoais");
		setBounds(100, 100, 615, 444);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDespesa = new JMenu("Despesa");
		menuBar.add(mnDespesa);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/seta.png")));
		mnDespesa.add(mntmConsultar);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/seta.png")));
		mnDespesa.add(mntmCadastrar);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		JMenu mnSair = new JMenu("Sair");
		menuBar.add(mnSair);

	}

}
