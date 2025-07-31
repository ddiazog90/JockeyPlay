package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.bets;
import model.betsDAO;
import view.view_bets;
import view.view_main;

public class logic_bets implements ActionListener{
	
	private view_bets b;
	private view_main vm;
	private List<bets> apostadores;
	private betsDAO bdao;
	public logic_bets(view_bets b, view_main vm) {
		super();
		this.b = b;
		this.vm = vm;
		this.apostadores=new ArrayList<>();
		loadPlays();
		loadBets();
		b.btn_bets.addActionListener(this);
		
	}
	private void loadBets() {
		// TODO Auto-generated method stub
		bdao=new betsDAO();
		apostadores=bdao.getBets();
		if(apostadores.size()!=0) {
			loadTable();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b.btn_bets) {
			generateCod cod=new generateCod(b.cmb_plays.getSelectedItem().toString());
			cod.start();
			try {
				cod.join();
				bets bt=new bets(
					cod.getCod(),
					b.txt_alias.getText(),
					Double.parseDouble(b.sp_money.getValue().toString()),
					b.cmb_plays.getSelectedItem().toString()
					);
			bdao=new betsDAO(bt);
			bdao.addBet();//registrar en el archivo bets.txt
			apostadores.add(bt);
			loadTable();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	private void loadPlays() {
		b.cmb_plays.addItem(vm.pn_lienzo.getPlayName1());
		b.cmb_plays.addItem(vm.pn_lienzo.getPlayName2());
		b.cmb_plays.addItem(vm.pn_lienzo.getPlayName3());
		b.cmb_plays.addItem(vm.pn_lienzo.getPlayName5());
		b.cmb_plays.addItem(vm.pn_lienzo.getPlayName6());
		b.cmb_plays.addItem(vm.pn_lienzo.getPlayName7());
	}

	public void loadTable() {
		String [] encabezado= {"CODIGO","ALIAS","APUESTA","CABALLO"};
		String [][] data=new String[apostadores.size()][4];
		for(int i=0;i<apostadores.size();i++) {
			data[i][0]=apostadores.get(i).getCod();
			data[i][1]=apostadores.get(i).getAlias();
			data[i][2]=apostadores.get(i).getMonto();
			data[i][3]=apostadores.get(i).getPlay();
		}
		
		DefaultTableModel model=new DefaultTableModel(data,encabezado);
		
		b.tb_bets.setModel(model);
	}
	
	
}
