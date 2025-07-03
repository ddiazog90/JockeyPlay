package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.view_bets;
import view.view_main;

public class logic_view_main implements ActionListener, ChangeListener{

	private view_main vm;
	private actPlay play1,play2,play3,play4,play5,play6;
	private actPlay[]plays=new actPlay[6];

	
	public logic_view_main(view_main vm) {
		super();
		this.vm = vm;
		loadNamesBets();
		loadNamesBase();
		vm.btn_iniciar.addActionListener(this);
		vm.btn_continuar.addActionListener(this);
		vm.btn_parar.addActionListener(this);
		vm.btn_saveNames.addActionListener(this);
		vm.btn_bets.addActionListener(this);
		vm.sp_play1.addChangeListener(this);
		vm.sp_play2.addChangeListener(this);
		vm.sp_play3.addChangeListener(this);
		vm.sp_play4.addChangeListener(this);
		vm.sp_play5.addChangeListener(this);
		vm.sp_play6.addChangeListener(this);
		//Cargar la lectura del archivo
		processBets hilo=new processBets(vm,this);
		hilo.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vm.btn_iniciar) {
			for(int i=0;i<plays.length;i++) {
				plays[i]=new actPlay(vm.pn_lienzo,i+1,vm);
				plays[i].start();
			}
		}else if(e.getSource()==vm.btn_continuar) {
			for(actPlay play:plays) {
				play.continuar();
			}
		}else if(e.getSource()==vm.btn_parar) {
			for(actPlay play:plays) {
				play.pausar();
			}
		}else if(e.getSource()==vm.btn_saveNames) {
			vm.pn_lienzo.setPla1(vm.txt_playName1.getText());
			vm.pn_lienzo.setPlay2(vm.txt_playName2.getText());
			vm.pn_lienzo.setPlay3(vm.txt_playName3.getText());
			vm.pn_lienzo.setPlay5(vm.txt_playName4.getText());
			vm.pn_lienzo.setplay6(vm.txt_playName5.getText());
			vm.pn_lienzo.setplay7(vm.txt_playName6.getText());
			loadNamesBets();
		}else if(e.getSource()==vm.btn_bets) {
			view_bets b=new view_bets(vm);
			b.setVisible(true);
		}
	}

	private void loadNamesBets() {
		vm.lbl_play1.setText(vm.pn_lienzo.getPlayName1());
		vm.lbl_play2.setText(vm.pn_lienzo.getPlayName2());
		vm.lbl_play3.setText(vm.pn_lienzo.getPlayName3());
		vm.lbl_play4.setText(vm.pn_lienzo.getPlayName5());
		vm.lbl_play5.setText(vm.pn_lienzo.getPlayName6());
		vm.lbl_play6.setText(vm.pn_lienzo.getPlayName7());
	}

	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		double monto, total, 
		montoPlay1, montoPlay2, montoPlay3,
		montoPlay4, montoPlay5, montoPlay6,
		pagarPlay1,pagarPlay2,pagarPlay3,
		pagarPlay4,pagarPlay5,pagarPlay6;
		
		monto=Double.parseDouble(vm.txt_base.getText().split("\s")[1]);
		montoPlay1=monto*Integer.parseInt(vm.sp_play1.getValue().toString());
		montoPlay2=monto*Integer.parseInt(vm.sp_play2.getValue().toString());
		montoPlay3=monto*Integer.parseInt(vm.sp_play3.getValue().toString());
		montoPlay4=monto*Integer.parseInt(vm.sp_play4.getValue().toString());
		montoPlay5=monto*Integer.parseInt(vm.sp_play5.getValue().toString());
		montoPlay6=monto*Integer.parseInt(vm.sp_play6.getValue().toString());
		total=montoPlay1+montoPlay2+montoPlay3+montoPlay4+montoPlay5+montoPlay6;
		pagarPlay1=total/Integer.parseInt(vm.sp_play1.getValue().toString());
		pagarPlay2=total/Integer.parseInt(vm.sp_play2.getValue().toString());
		pagarPlay3=total/Integer.parseInt(vm.sp_play3.getValue().toString());
		pagarPlay4=total/Integer.parseInt(vm.sp_play4.getValue().toString());
		pagarPlay5=total/Integer.parseInt(vm.sp_play5.getValue().toString());
		pagarPlay6=total/Integer.parseInt(vm.sp_play6.getValue().toString());

		if(e.getSource()==vm.sp_play1) {
			vm.txt_playMonto1.setText(String.format("$ %.2f", montoPlay1));
		}else if(e.getSource()==vm.sp_play2) {
			vm.txt_playMonto2.setText(String.format("$ %.2f", montoPlay2));
		}else if(e.getSource()==vm.sp_play3) {
			vm.txt_playMonto3.setText(String.format("$ %.2f", montoPlay3));
		}else if(e.getSource()==vm.sp_play4) {
			vm.txt_playMonto4.setText(String.format("$ %.2f", montoPlay4));
		}else if(e.getSource()==vm.sp_play5) {
			vm.txt_playMonto5.setText(String.format("$ %.2f", montoPlay5));
		}else if(e.getSource()==vm.sp_play6) {
			vm.txt_playMonto6.setText(String.format("$ %.2f", montoPlay6));
			
		}
		vm.txt_montoTotal.setText(String.format("$ %.2f", total));
		vm.txt_playPagar1.setText(String.format("$ %.2f",pagarPlay1));
		vm.txt_playPagar2.setText(String.format("$ %.2f",pagarPlay2));
		vm.txt_playPagar3.setText(String.format("$ %.2f",pagarPlay3));
		vm.txt_playPagar4.setText(String.format("$ %.2f",pagarPlay4));
		vm.txt_playPagar5.setText(String.format("$ %.2f",pagarPlay5));
		vm.txt_playPagar6.setText(String.format("$ %.2f",pagarPlay6));
		
	}
	public void calMontoBets() {
		double monto, total, 
		montoPlay1, montoPlay2, montoPlay3,
		montoPlay4, montoPlay5, montoPlay6,
		pagarPlay1,pagarPlay2,pagarPlay3,
		pagarPlay4,pagarPlay5,pagarPlay6;
		
		monto=Double.parseDouble(vm.txt_base.getText().split("\s")[1]);
		montoPlay1=monto*Integer.parseInt(vm.sp_play1.getValue().toString());
		montoPlay2=monto*Integer.parseInt(vm.sp_play2.getValue().toString());
		montoPlay3=monto*Integer.parseInt(vm.sp_play3.getValue().toString());
		montoPlay4=monto*Integer.parseInt(vm.sp_play4.getValue().toString());
		montoPlay5=monto*Integer.parseInt(vm.sp_play5.getValue().toString());
		montoPlay6=monto*Integer.parseInt(vm.sp_play6.getValue().toString());
		total=montoPlay1+montoPlay2+montoPlay3+montoPlay4+montoPlay5+montoPlay6;
		pagarPlay1=total/Integer.parseInt(vm.sp_play1.getValue().toString());
		pagarPlay2=total/Integer.parseInt(vm.sp_play2.getValue().toString());
		pagarPlay3=total/Integer.parseInt(vm.sp_play3.getValue().toString());
		pagarPlay4=total/Integer.parseInt(vm.sp_play4.getValue().toString());
		pagarPlay5=total/Integer.parseInt(vm.sp_play5.getValue().toString());
		pagarPlay6=total/Integer.parseInt(vm.sp_play6.getValue().toString());

		vm.txt_playMonto1.setText(String.format("$ %.2f", montoPlay1));
		vm.txt_playMonto2.setText(String.format("$ %.2f", montoPlay2));
		vm.txt_playMonto3.setText(String.format("$ %.2f", montoPlay3));
		vm.txt_playMonto4.setText(String.format("$ %.2f", montoPlay4));
		vm.txt_playMonto5.setText(String.format("$ %.2f", montoPlay5));
		vm.txt_playMonto6.setText(String.format("$ %.2f", montoPlay6));
		
		vm.txt_montoTotal.setText(String.format("$ %.2f", total));
		vm.txt_playPagar1.setText(String.format("$ %.2f",pagarPlay1));
		vm.txt_playPagar2.setText(String.format("$ %.2f",pagarPlay2));
		vm.txt_playPagar3.setText(String.format("$ %.2f",pagarPlay3));
		vm.txt_playPagar4.setText(String.format("$ %.2f",pagarPlay4));
		vm.txt_playPagar5.setText(String.format("$ %.2f",pagarPlay5));
		vm.txt_playPagar6.setText(String.format("$ %.2f",pagarPlay6));
	}
	private void loadNamesBase() {
		vm.txt_playName1.setText(vm.pn_lienzo.getPlayName1());
		vm.txt_playName2.setText(vm.pn_lienzo.getPlayName2());
		vm.txt_playName3.setText(vm.pn_lienzo.getPlayName3());
		vm.txt_playName4.setText(vm.pn_lienzo.getPlayName5());
		vm.txt_playName5.setText(vm.pn_lienzo.getPlayName6());
		vm.txt_playName6.setText(vm.pn_lienzo.getPlayName7());
		
	}

}
