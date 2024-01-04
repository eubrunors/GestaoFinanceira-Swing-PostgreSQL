package app.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.controller.DespesaController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JTextField;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroDespesa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JLabel lblNewLabel_1 = new JLabel("Cadastro de Despesa");
	private final JTextField textFieldDescricao = new JTextField();
	private final JLabel lblNewLabel_2 = new JLabel("Descricao");
	private final JLabel lblNewLabel_2_1_1 = new JLabel("Valor");
	private final JLabel lblNewLabel_2_1_1_1 = new JLabel("Data");
	private final JSpinner spinnerData = new JSpinner();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroDespesa frame = new TelaCadastroDespesa();
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
	public TelaCadastroDespesa() {
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setPreferredSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 581);
		contentPane = new JPanel();
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel_1.setBounds(338, 46, 186, 25);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.setBounds(41, 81, 780, 400);
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.setPreferredSize(new Dimension(780, 400));
		panel.setBackground(new Color(192, 192, 192));
		contentPane.add(panel);
		panel.setLayout(null);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(70, 58, 96, 22);
		lblNewLabel_2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		panel.add(lblNewLabel_2);
		textFieldDescricao.setBounds(197, 51, 447, 36);
		textFieldDescricao.setColumns(10);
		
		panel.add(textFieldDescricao);
		
		JLabel lblNewLabel_2_1 = new JLabel("Categoria");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblNewLabel_2_1.setBounds(70, 109, 96, 22);
		panel.add(lblNewLabel_2_1);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setModel(new DefaultComboBoxModel(new String[] {"Casa", "Mercado", "Compras"}));
		comboBoxCategoria.setBounds(196, 102, 112, 36);
		panel.add(comboBoxCategoria);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblNewLabel_2_1_1.setBounds(70, 163, 96, 22);
		
		panel.add(lblNewLabel_2_1_1);
		
		JSpinner spinnerValor = new JSpinner();
		spinnerValor.setModel(new SpinnerNumberModel(Float.valueOf(0), null, Float.valueOf(999999), Float.valueOf(0)));
		spinnerValor.setBounds(196, 156, 86, 36);
		panel.add(spinnerValor);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblNewLabel_2_1_1_1.setBounds(70, 217, 96, 22);
		
		panel.add(lblNewLabel_2_1_1_1);
		spinnerData.setModel(new SpinnerDateModel(new Date(1704164400000L), null, null, Calendar.DAY_OF_MONTH));
		spinnerData.setBounds(197, 210, 144, 36);
		
		panel.add(spinnerData);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date data = (Date) spinnerData.getValue();
				float valor = Float.parseFloat(spinnerValor.getValue().toString());
				String categoria = comboBoxCategoria.getSelectedItem().toString();
				
				try {
					DespesaController despesaController = new DespesaController();
					boolean despesaCadastrada = despesaController.cadastrarDespesa(textFieldDescricao.getText(), categoria, valor, data);
					if(despesaCadastrada) {
						JOptionPane.showMessageDialog(null, "Despesa Cadastrada com Sucesso! ");
						this.limparTelaCadastroDespesa();
					}else{
						JOptionPane.showMessageDialog(null, "Campos não preenchidos corretamente. ");
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Erro: " + ex);
				}
			}

			private void limparTelaCadastroDespesa() {//GEN-FIRST:event_limparTelaCadastroFilme
				textFieldDescricao.setText("");
				comboBoxCategoria.setSelectedIndex(0);
			    spinnerValor.setValue(0);

			}
		});
		btnSalvar.setBounds(131, 302, 85, 21);
		panel.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    textFieldDescricao.setText("");
			    comboBoxCategoria.setSelectedIndex(0);
			    spinnerValor.setValue(0);
			}
		});
		btnLimpar.setBounds(347, 302, 85, 21);
		panel.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(563, 302, 85, 21);
		panel.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Lógica para voltar para a tela principal
		        TelaPrincipal telaPrincipal = new TelaPrincipal(); // Substitua TelaPrincipal pelo nome da sua classe da tela principal
		        telaPrincipal.setVisible(true); // Mostra a tela principal
		        dispose(); // Fecha a tela atual, se necessário
		    }
		});

		
	}
	
}
