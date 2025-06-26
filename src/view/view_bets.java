package view;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.logic_bets;

import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;

public class view_bets extends JFrame{
	public JTextField txt_alias;
	public JComboBox cmb_plays;
	public JSpinner sp_money;
	public JButton btn_bets;
	public JTable tb_bets;
	public view_bets(view_main vm) {
		getContentPane().setBackground(new Color(64, 0, 64));
		setResizable(false);
		setTitle("APOSTADORES");
		setBounds(1000,50,542,700);
		getContentPane().setLayout(null);
		
		JPanel pn_controlBets = new JPanel();
		pn_controlBets.setBackground(new Color(255, 255, 255));
		pn_controlBets.setBounds(10, 10, 511, 82);
		getContentPane().add(pn_controlBets);
		
		JLabel lblNewLabel = new JLabel("ALIAS:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		pn_controlBets.add(lblNewLabel);
		
		txt_alias = new JTextField();
		txt_alias.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		pn_controlBets.add(txt_alias);
		txt_alias.setColumns(10);
		
		JLabel lblPlay = new JLabel("PLAY:");
		lblPlay.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		pn_controlBets.add(lblPlay);
		
		cmb_plays = new JComboBox();
		cmb_plays.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		cmb_plays.addItem("Elegir");
		pn_controlBets.add(cmb_plays);
		
		JLabel lblNewLabel_1 = new JLabel("$:");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		pn_controlBets.add(lblNewLabel_1);
		
		sp_money = new JSpinner();
		sp_money.setModel(new SpinnerNumberModel(Double.valueOf(0), null, null, Double.valueOf(1)));
		sp_money.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		sp_money.setValue(0.25);
		pn_controlBets.add(sp_money);
		
		btn_bets = new JButton("APOSTAR");
		btn_bets.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		pn_controlBets.add(btn_bets);
		
		JPanel pn_betsTable = new JPanel();
		pn_betsTable.setBounds(10, 102, 508, 551);
		getContentPane().add(pn_betsTable);
		
		
		tb_bets = new JTable();
		tb_bets.setForeground(new Color(255, 255, 255));
		tb_bets.setBackground(new Color(64, 0, 0));
		tb_bets.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		//pn_betsTable.add(tb_bets);
		JScrollPane contTable=new JScrollPane(tb_bets);
		pn_betsTable.add(contTable);
		
		
		
		new logic_bets(this,vm);
		
	}
}
