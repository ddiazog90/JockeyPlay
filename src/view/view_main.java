package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.logic_view_main;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JSpinner;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class view_main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public lienzo pn_lienzo;
	private JPanel pn_control;
	public JButton btn_iniciar;
	public JButton btn_parar;
	public JButton btn_continuar;
	public JButton btn_bets;
	public JPanel pn_names;
	private JLabel lblNewLabel;
	private JLabel lblPlay;
	private JLabel lblPlay_2;
	private JLabel lblPlay_3;
	public JTextField txt_playName1;
	public JTextField txt_playName2;
	public JTextField txt_playName3;
	public JButton btn_saveNames;
	private JLabel lbl_jugadores;
	private JLabel lbl_jugadores_1;
	private JLabel lbl_jugadores_2;
	private JLabel lbl_jugadores_3;
	public JLabel lbl_play1;
	public JLabel lbl_play2;
	public JLabel lbl_play3;
	public JSpinner sp_play1;
	public JSpinner sp_play2;
	public JSpinner sp_play3;
	public JTextField txt_playMonto1;
	public JTextField txt_playPagar1;
	public JTextField txt_playMonto2;
	public JTextField txt_playMonto3;
	public JTextField txt_playPagar2;
	public JTextField txt_playPagar3;
	public JTextField txt_montoTotal;
	public JTextField txt_base;
	public JLabel lblPlay_1;
	public JLabel lblPlay_4;
	public JLabel lblPlay_5;
	public JTextField txt_playName4;
	public JTextField txt_playName5;
	public JTextField txt_playName6;
	public JLabel lbl_play4;
	public JLabel lbl_play5;
	public JLabel lbl_play6;
	public JSpinner sp_play4;
	public JSpinner sp_play5;
	public JSpinner sp_play6;
	public JTextField txt_playMonto4;
	public JTextField txt_playMonto5;
	public JTextField txt_playMonto6;
	public JTextField txt_playPagar4;
	public JTextField txt_playPagar5;
	public JTextField txt_playPagar6;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_main frame = new view_main();
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
	public view_main() {
		setTitle("LIENZO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1500, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pn_control = new JPanel();
		pn_control.setBackground(SystemColor.inactiveCaption);
		pn_control.setBounds(1, 35, 70, 509);
		contentPane.add(pn_control);
		pn_control.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btn_iniciar = new JButton("");
//		ImageIcon start=new ImageIcon("/images/start.png");
//		Image imagenEscalada = start.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
//        ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
		
		btn_iniciar.setIcon(new ImageIcon(view_main.class.getResource("/images/start.png")));
        
		pn_control.add(btn_iniciar);
		
		btn_parar = new JButton("");
		btn_parar.setIcon(new ImageIcon(view_main.class.getResource("/images/stop.png")));
		pn_control.add(btn_parar);
		
		btn_continuar = new JButton("");
		btn_continuar.setIcon(new ImageIcon(view_main.class.getResource("/images/continue.png")));
		pn_control.add(btn_continuar);
		
		btn_bets = new JButton("");
		btn_bets.setIcon(new ImageIcon(view_main.class.getResource("/images/bet.png")));
		pn_control.add(btn_bets);
		
		JTabbedPane pn_config = new JTabbedPane(JTabbedPane.TOP);
		pn_config.setBounds(76, 10, 1400, 534);
		contentPane.add(pn_config);
		
		pn_lienzo = new lienzo();
		pn_config.addTab("PLAYS", null, pn_lienzo, null);
		
		pn_names = new JPanel();
		pn_config.addTab("NAMES", null, pn_names, null);
		GridBagLayout gbl_pn_names = new GridBagLayout();
		gbl_pn_names.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pn_names.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pn_names.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pn_names.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pn_names.setLayout(gbl_pn_names);
		
		lblNewLabel = new JLabel("NOMBRES DE LOS CABALLOS");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		pn_names.add(lblNewLabel, gbc_lblNewLabel);
		
		lblPlay = new JLabel("PLAY 1 : ");
		lblPlay.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lblPlay = new GridBagConstraints();
		gbc_lblPlay.anchor = GridBagConstraints.EAST;
		gbc_lblPlay.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlay.gridx = 1;
		gbc_lblPlay.gridy = 3;
		pn_names.add(lblPlay, gbc_lblPlay);
		
		txt_playName1 = new JTextField();
		txt_playName1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playName1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		GridBagConstraints gbc_txt_playName1 = new GridBagConstraints();
		gbc_txt_playName1.insets = new Insets(0, 0, 5, 0);
		gbc_txt_playName1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playName1.gridx = 2;
		gbc_txt_playName1.gridy = 3;
		pn_names.add(txt_playName1, gbc_txt_playName1);
		txt_playName1.setColumns(10);
		
		lblPlay_2 = new JLabel("PLAY 2 : ");
		lblPlay_2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lblPlay_2 = new GridBagConstraints();
		gbc_lblPlay_2.anchor = GridBagConstraints.EAST;
		gbc_lblPlay_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlay_2.gridx = 1;
		gbc_lblPlay_2.gridy = 4;
		pn_names.add(lblPlay_2, gbc_lblPlay_2);
		
		txt_playName2 = new JTextField();
		txt_playName2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playName2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txt_playName2.setColumns(10);
		GridBagConstraints gbc_txt_playName2 = new GridBagConstraints();
		gbc_txt_playName2.insets = new Insets(0, 0, 5, 0);
		gbc_txt_playName2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playName2.gridx = 2;
		gbc_txt_playName2.gridy = 4;
		pn_names.add(txt_playName2, gbc_txt_playName2);
		
		lblPlay_3 = new JLabel("PLAY 3 : ");
		lblPlay_3.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lblPlay_3 = new GridBagConstraints();
		gbc_lblPlay_3.anchor = GridBagConstraints.EAST;
		gbc_lblPlay_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlay_3.gridx = 1;
		gbc_lblPlay_3.gridy = 5;
		pn_names.add(lblPlay_3, gbc_lblPlay_3);
		
		txt_playName3 = new JTextField();
		txt_playName3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playName3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txt_playName3.setColumns(10);
		GridBagConstraints gbc_txt_playName3 = new GridBagConstraints();
		gbc_txt_playName3.insets = new Insets(0, 0, 5, 0);
		gbc_txt_playName3.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playName3.gridx = 2;
		gbc_txt_playName3.gridy = 5;
		pn_names.add(txt_playName3, gbc_txt_playName3);
		
		lblPlay_1 = new JLabel("PLAY 4 : ");
		lblPlay_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lblPlay_1 = new GridBagConstraints();
		gbc_lblPlay_1.anchor = GridBagConstraints.EAST;
		gbc_lblPlay_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlay_1.gridx = 1;
		gbc_lblPlay_1.gridy = 6;
		pn_names.add(lblPlay_1, gbc_lblPlay_1);
		
		txt_playName4 = new JTextField();
		txt_playName4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playName4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txt_playName4.setColumns(10);
		GridBagConstraints gbc_txt_playName4 = new GridBagConstraints();
		gbc_txt_playName4.insets = new Insets(0, 0, 5, 0);
		gbc_txt_playName4.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playName4.gridx = 2;
		gbc_txt_playName4.gridy = 6;
		pn_names.add(txt_playName4, gbc_txt_playName4);
		
		lblPlay_4 = new JLabel("PLAY 5 : ");
		lblPlay_4.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lblPlay_4 = new GridBagConstraints();
		gbc_lblPlay_4.anchor = GridBagConstraints.EAST;
		gbc_lblPlay_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlay_4.gridx = 1;
		gbc_lblPlay_4.gridy = 7;
		pn_names.add(lblPlay_4, gbc_lblPlay_4);
		
		txt_playName5 = new JTextField();
		txt_playName5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playName5.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txt_playName5.setColumns(10);
		GridBagConstraints gbc_txt_playName5 = new GridBagConstraints();
		gbc_txt_playName5.insets = new Insets(0, 0, 5, 0);
		gbc_txt_playName5.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playName5.gridx = 2;
		gbc_txt_playName5.gridy = 7;
		pn_names.add(txt_playName5, gbc_txt_playName5);
		
		lblPlay_5 = new JLabel("PLAY 6 : ");
		lblPlay_5.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lblPlay_5 = new GridBagConstraints();
		gbc_lblPlay_5.anchor = GridBagConstraints.EAST;
		gbc_lblPlay_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlay_5.gridx = 1;
		gbc_lblPlay_5.gridy = 8;
		pn_names.add(lblPlay_5, gbc_lblPlay_5);
		
		txt_playName6 = new JTextField();
		txt_playName6.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playName6.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txt_playName6.setColumns(10);
		GridBagConstraints gbc_txt_playName6 = new GridBagConstraints();
		gbc_txt_playName6.insets = new Insets(0, 0, 5, 0);
		gbc_txt_playName6.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playName6.gridx = 2;
		gbc_txt_playName6.gridy = 8;
		pn_names.add(txt_playName6, gbc_txt_playName6);
		
		btn_saveNames = new JButton("SAVE");
		btn_saveNames.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_btn_saveNames = new GridBagConstraints();
		gbc_btn_saveNames.gridx = 2;
		gbc_btn_saveNames.gridy = 11;
		pn_names.add(btn_saveNames, gbc_btn_saveNames);
		
		JPanel pn_apuestas = new JPanel();
		pn_config.addTab("BETS", null, pn_apuestas, null);
		GridBagLayout gbl_pn_apuestas = new GridBagLayout();
		gbl_pn_apuestas.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pn_apuestas.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pn_apuestas.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pn_apuestas.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pn_apuestas.setLayout(gbl_pn_apuestas);
		
		lbl_jugadores = new JLabel("JUGADORES");
		lbl_jugadores.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_jugadores = new GridBagConstraints();
		gbc_lbl_jugadores.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_jugadores.gridx = 1;
		gbc_lbl_jugadores.gridy = 0;
		pn_apuestas.add(lbl_jugadores, gbc_lbl_jugadores);
		
		lbl_jugadores_1 = new JLabel("APUESTAS");
		lbl_jugadores_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_jugadores_1 = new GridBagConstraints();
		gbc_lbl_jugadores_1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_jugadores_1.gridx = 4;
		gbc_lbl_jugadores_1.gridy = 0;
		pn_apuestas.add(lbl_jugadores_1, gbc_lbl_jugadores_1);
		
		lbl_jugadores_2 = new JLabel("MONTO");
		lbl_jugadores_2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_jugadores_2 = new GridBagConstraints();
		gbc_lbl_jugadores_2.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_jugadores_2.gridx = 6;
		gbc_lbl_jugadores_2.gridy = 0;
		pn_apuestas.add(lbl_jugadores_2, gbc_lbl_jugadores_2);
		
		lbl_jugadores_3 = new JLabel("A PAGAR");
		lbl_jugadores_3.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_jugadores_3 = new GridBagConstraints();
		gbc_lbl_jugadores_3.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_jugadores_3.gridx = 8;
		gbc_lbl_jugadores_3.gridy = 0;
		pn_apuestas.add(lbl_jugadores_3, gbc_lbl_jugadores_3);
		
		lbl_play1 = new JLabel("Jugador 1");
		lbl_play1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_play1 = new GridBagConstraints();
		gbc_lbl_play1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_play1.gridx = 1;
		gbc_lbl_play1.gridy = 1;
		pn_apuestas.add(lbl_play1, gbc_lbl_play1);
		
		sp_play1 = new JSpinner();
		sp_play1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		GridBagConstraints gbc_sp_play1 = new GridBagConstraints();
		gbc_sp_play1.insets = new Insets(0, 0, 5, 5);
		gbc_sp_play1.gridx = 4;
		gbc_sp_play1.gridy = 1;
		pn_apuestas.add(sp_play1, gbc_sp_play1);
		
		txt_playMonto1 = new JTextField();
		txt_playMonto1.setText("$ 0");
		txt_playMonto1.setEditable(false);
		txt_playMonto1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playMonto1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_txt_playMonto1 = new GridBagConstraints();
		gbc_txt_playMonto1.insets = new Insets(0, 0, 5, 5);
		gbc_txt_playMonto1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playMonto1.gridx = 6;
		gbc_txt_playMonto1.gridy = 1;
		pn_apuestas.add(txt_playMonto1, gbc_txt_playMonto1);
		txt_playMonto1.setColumns(10);
		
		txt_playPagar1 = new JTextField();
		txt_playPagar1.setText("$ 0");
		txt_playPagar1.setEditable(false);
		txt_playPagar1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playPagar1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txt_playPagar1.setColumns(10);
		GridBagConstraints gbc_txt_playPagar1 = new GridBagConstraints();
		gbc_txt_playPagar1.insets = new Insets(0, 0, 5, 0);
		gbc_txt_playPagar1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playPagar1.gridx = 8;
		gbc_txt_playPagar1.gridy = 1;
		pn_apuestas.add(txt_playPagar1, gbc_txt_playPagar1);
		
		lbl_play2 = new JLabel("Jugador 2");
		lbl_play2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_play2 = new GridBagConstraints();
		gbc_lbl_play2.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_play2.gridx = 1;
		gbc_lbl_play2.gridy = 2;
		pn_apuestas.add(lbl_play2, gbc_lbl_play2);
		
		sp_play2 = new JSpinner();
		sp_play2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		GridBagConstraints gbc_sp_play2 = new GridBagConstraints();
		gbc_sp_play2.insets = new Insets(0, 0, 5, 5);
		gbc_sp_play2.gridx = 4;
		gbc_sp_play2.gridy = 2;
		pn_apuestas.add(sp_play2, gbc_sp_play2);
		
		txt_playMonto2 = new JTextField();
		txt_playMonto2.setText("$ 0");
		txt_playMonto2.setEditable(false);
		txt_playMonto2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playMonto2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txt_playMonto2.setColumns(10);
		GridBagConstraints gbc_txt_playMonto2 = new GridBagConstraints();
		gbc_txt_playMonto2.insets = new Insets(0, 0, 5, 5);
		gbc_txt_playMonto2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playMonto2.gridx = 6;
		gbc_txt_playMonto2.gridy = 2;
		pn_apuestas.add(txt_playMonto2, gbc_txt_playMonto2);
		
		txt_playPagar2 = new JTextField();
		txt_playPagar2.setText("$ 0");
		txt_playPagar2.setEditable(false);
		txt_playPagar2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playPagar2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txt_playPagar2.setColumns(10);
		GridBagConstraints gbc_txt_playPagar2 = new GridBagConstraints();
		gbc_txt_playPagar2.insets = new Insets(0, 0, 5, 0);
		gbc_txt_playPagar2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playPagar2.gridx = 8;
		gbc_txt_playPagar2.gridy = 2;
		pn_apuestas.add(txt_playPagar2, gbc_txt_playPagar2);
		
		lbl_play3 = new JLabel("Jugador 3");
		lbl_play3.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_play3 = new GridBagConstraints();
		gbc_lbl_play3.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_play3.gridx = 1;
		gbc_lbl_play3.gridy = 3;
		pn_apuestas.add(lbl_play3, gbc_lbl_play3);
		
		sp_play3 = new JSpinner();
		sp_play3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		GridBagConstraints gbc_sp_play3 = new GridBagConstraints();
		gbc_sp_play3.insets = new Insets(0, 0, 5, 5);
		gbc_sp_play3.gridx = 4;
		gbc_sp_play3.gridy = 3;
		pn_apuestas.add(sp_play3, gbc_sp_play3);
		
		txt_playMonto3 = new JTextField();
		txt_playMonto3.setText("$ 0");
		txt_playMonto3.setEditable(false);
		txt_playMonto3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playMonto3.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txt_playMonto3.setColumns(10);
		GridBagConstraints gbc_txt_playMonto3 = new GridBagConstraints();
		gbc_txt_playMonto3.insets = new Insets(0, 0, 5, 5);
		gbc_txt_playMonto3.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playMonto3.gridx = 6;
		gbc_txt_playMonto3.gridy = 3;
		pn_apuestas.add(txt_playMonto3, gbc_txt_playMonto3);
		
		txt_playPagar3 = new JTextField();
		txt_playPagar3.setText("$ 0");
		txt_playPagar3.setEditable(false);
		txt_playPagar3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playPagar3.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txt_playPagar3.setColumns(10);
		GridBagConstraints gbc_txt_playPagar3 = new GridBagConstraints();
		gbc_txt_playPagar3.insets = new Insets(0, 0, 5, 0);
		gbc_txt_playPagar3.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playPagar3.gridx = 8;
		gbc_txt_playPagar3.gridy = 3;
		pn_apuestas.add(txt_playPagar3, gbc_txt_playPagar3);
		
		lbl_play4 = new JLabel("Jugador 4");
		lbl_play4.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_play4 = new GridBagConstraints();
		gbc_lbl_play4.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_play4.gridx = 1;
		gbc_lbl_play4.gridy = 4;
		pn_apuestas.add(lbl_play4, gbc_lbl_play4);
		
		sp_play4 = new JSpinner();
		sp_play4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		GridBagConstraints gbc_sp_play4 = new GridBagConstraints();
		gbc_sp_play4.insets = new Insets(0, 0, 5, 5);
		gbc_sp_play4.gridx = 4;
		gbc_sp_play4.gridy = 4;
		pn_apuestas.add(sp_play4, gbc_sp_play4);
		
		txt_playMonto4 = new JTextField();
		txt_playMonto4.setText("$ 0");
		txt_playMonto4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playMonto4.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txt_playMonto4.setEditable(false);
		txt_playMonto4.setColumns(10);
		GridBagConstraints gbc_txt_playMonto4 = new GridBagConstraints();
		gbc_txt_playMonto4.insets = new Insets(0, 0, 5, 5);
		gbc_txt_playMonto4.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playMonto4.gridx = 6;
		gbc_txt_playMonto4.gridy = 4;
		pn_apuestas.add(txt_playMonto4, gbc_txt_playMonto4);
		
		txt_playPagar4 = new JTextField();
		txt_playPagar4.setText("$ 0");
		txt_playPagar4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playPagar4.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txt_playPagar4.setEditable(false);
		txt_playPagar4.setColumns(10);
		GridBagConstraints gbc_txt_playPagar4 = new GridBagConstraints();
		gbc_txt_playPagar4.insets = new Insets(0, 0, 5, 0);
		gbc_txt_playPagar4.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playPagar4.gridx = 8;
		gbc_txt_playPagar4.gridy = 4;
		pn_apuestas.add(txt_playPagar4, gbc_txt_playPagar4);
		
		lbl_play5 = new JLabel("Jugador 5");
		lbl_play5.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_play5 = new GridBagConstraints();
		gbc_lbl_play5.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_play5.gridx = 1;
		gbc_lbl_play5.gridy = 5;
		pn_apuestas.add(lbl_play5, gbc_lbl_play5);
		
		sp_play5 = new JSpinner();
		sp_play5.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		GridBagConstraints gbc_sp_play5 = new GridBagConstraints();
		gbc_sp_play5.insets = new Insets(0, 0, 5, 5);
		gbc_sp_play5.gridx = 4;
		gbc_sp_play5.gridy = 5;
		pn_apuestas.add(sp_play5, gbc_sp_play5);
		
		txt_playMonto5 = new JTextField();
		txt_playMonto5.setText("$ 0");
		txt_playMonto5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playMonto5.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txt_playMonto5.setEditable(false);
		txt_playMonto5.setColumns(10);
		GridBagConstraints gbc_txt_playMonto5 = new GridBagConstraints();
		gbc_txt_playMonto5.insets = new Insets(0, 0, 5, 5);
		gbc_txt_playMonto5.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playMonto5.gridx = 6;
		gbc_txt_playMonto5.gridy = 5;
		pn_apuestas.add(txt_playMonto5, gbc_txt_playMonto5);
		
		txt_playPagar5 = new JTextField();
		txt_playPagar5.setText("$ 0");
		txt_playPagar5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playPagar5.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txt_playPagar5.setEditable(false);
		txt_playPagar5.setColumns(10);
		GridBagConstraints gbc_txt_playPagar5 = new GridBagConstraints();
		gbc_txt_playPagar5.insets = new Insets(0, 0, 5, 0);
		gbc_txt_playPagar5.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playPagar5.gridx = 8;
		gbc_txt_playPagar5.gridy = 5;
		pn_apuestas.add(txt_playPagar5, gbc_txt_playPagar5);
		
		lbl_play6 = new JLabel("Jugador 6");
		lbl_play6.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_play6 = new GridBagConstraints();
		gbc_lbl_play6.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_play6.gridx = 1;
		gbc_lbl_play6.gridy = 6;
		pn_apuestas.add(lbl_play6, gbc_lbl_play6);
		
		sp_play6 = new JSpinner();
		sp_play6.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		GridBagConstraints gbc_sp_play6 = new GridBagConstraints();
		gbc_sp_play6.insets = new Insets(0, 0, 5, 5);
		gbc_sp_play6.gridx = 4;
		gbc_sp_play6.gridy = 6;
		pn_apuestas.add(sp_play6, gbc_sp_play6);
		
		txt_playMonto6 = new JTextField();
		txt_playMonto6.setText("$ 0");
		txt_playMonto6.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playMonto6.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txt_playMonto6.setEditable(false);
		txt_playMonto6.setColumns(10);
		GridBagConstraints gbc_txt_playMonto6 = new GridBagConstraints();
		gbc_txt_playMonto6.insets = new Insets(0, 0, 5, 5);
		gbc_txt_playMonto6.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playMonto6.gridx = 6;
		gbc_txt_playMonto6.gridy = 6;
		pn_apuestas.add(txt_playMonto6, gbc_txt_playMonto6);
		
		txt_playPagar6 = new JTextField();
		txt_playPagar6.setText("$ 0");
		txt_playPagar6.setHorizontalAlignment(SwingConstants.CENTER);
		txt_playPagar6.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txt_playPagar6.setEditable(false);
		txt_playPagar6.setColumns(10);
		GridBagConstraints gbc_txt_playPagar6 = new GridBagConstraints();
		gbc_txt_playPagar6.insets = new Insets(0, 0, 5, 0);
		gbc_txt_playPagar6.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_playPagar6.gridx = 8;
		gbc_txt_playPagar6.gridy = 6;
		pn_apuestas.add(txt_playPagar6, gbc_txt_playPagar6);
		
		Component verticalGlue = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue = new GridBagConstraints();
		gbc_verticalGlue.insets = new Insets(0, 0, 5, 5);
		gbc_verticalGlue.gridx = 6;
		gbc_verticalGlue.gridy = 7;
		pn_apuestas.add(verticalGlue, gbc_verticalGlue);
		
		JLabel lbl_jugadores_2_1 = new JLabel("TOTAL");
		lbl_jugadores_2_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_jugadores_2_1 = new GridBagConstraints();
		gbc_lbl_jugadores_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_jugadores_2_1.gridx = 4;
		gbc_lbl_jugadores_2_1.gridy = 11;
		pn_apuestas.add(lbl_jugadores_2_1, gbc_lbl_jugadores_2_1);
		
		txt_montoTotal = new JTextField();
		txt_montoTotal.setText("$ 0");
		txt_montoTotal.setForeground(Color.WHITE);
		txt_montoTotal.setBackground(new Color(0, 0, 0));
		txt_montoTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txt_montoTotal.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txt_montoTotal.setEditable(false);
		txt_montoTotal.setColumns(10);
		GridBagConstraints gbc_txt_montoTotal = new GridBagConstraints();
		gbc_txt_montoTotal.insets = new Insets(0, 0, 5, 5);
		gbc_txt_montoTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_montoTotal.gridx = 6;
		gbc_txt_montoTotal.gridy = 11;
		pn_apuestas.add(txt_montoTotal, gbc_txt_montoTotal);
		
		JLabel lbl_jugadores_2_1_1 = new JLabel("BASE");
		lbl_jugadores_2_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_jugadores_2_1_1 = new GridBagConstraints();
		gbc_lbl_jugadores_2_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_jugadores_2_1_1.gridx = 4;
		gbc_lbl_jugadores_2_1_1.gridy = 12;
		pn_apuestas.add(lbl_jugadores_2_1_1, gbc_lbl_jugadores_2_1_1);
		
		txt_base = new JTextField();
		txt_base.setText("$ 0.05");
		txt_base.setHorizontalAlignment(SwingConstants.CENTER);
		txt_base.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txt_base.setColumns(10);
		GridBagConstraints gbc_txt_base = new GridBagConstraints();
		gbc_txt_base.insets = new Insets(0, 0, 0, 5);
		gbc_txt_base.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_base.gridx = 6;
		gbc_txt_base.gridy = 12;
		pn_apuestas.add(txt_base, gbc_txt_base);
		
		new logic_view_main(this);
	}
}
