package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.view_bets;
import view.view_main;

public class logic_view_main implements ActionListener, ChangeListener{

	private view_main vm;
	private actPlay play1,play2,play3;

	
	public logic_view_main(view_main vm) {
		super();
		this.vm = vm;
		loadNamesBets();
		vm.btn_iniciar.addActionListener(this);
		vm.btn_continuar.addActionListener(this);
		vm.btn_parar.addActionListener(this);
		vm.btn_saveNames.addActionListener(this);
		vm.btn_bets.addActionListener(this);
		vm.sp_play1.addChangeListener(this);
		vm.sp_play2.addChangeListener(this);
		vm.sp_play3.addChangeListener(this);
		   
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vm.btn_iniciar) {
			play1=new actPlay(vm.pn_lienzo,1,vm);
			play2=new actPlay(vm.pn_lienzo,2,vm);
			play3=new actPlay(vm.pn_lienzo,3,vm);
			play1.start();
			play2.start();
			play3.start();
			
		}else if(e.getSource()==vm.btn_continuar) {
			play1.continuar();
			play2.continuar();
			play3.continuar();		
		}else if(e.getSource()==vm.btn_parar) {
			play1.pausar();
			play2.pausar();
			play3.pausar();	
		}else if(e.getSource()==vm.btn_saveNames) {
			vm.pn_lienzo.setPla1(vm.txt_playName1.getText());
			vm.pn_lienzo.setPlay2(vm.txt_playName2.getText());
			vm.pn_lienzo.setPlay3(vm.txt_playName3.getText());
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
	}

	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		double monto, total, montoPlay1, montoPlay2, montoPlay3,pagarPlay1,pagarPlay2,pagarPlay3;
		monto=Double.parseDouble(vm.txt_base.getText().split("\s")[1]);
		montoPlay1=monto*Integer.parseInt(vm.sp_play1.getValue().toString());
		montoPlay2=monto*Integer.parseInt(vm.sp_play2.getValue().toString());
		montoPlay3=monto*Integer.parseInt(vm.sp_play3.getValue().toString());
		total=montoPlay1+montoPlay2+montoPlay3;
		pagarPlay1=total/Integer.parseInt(vm.sp_play1.getValue().toString());
		pagarPlay2=total/Integer.parseInt(vm.sp_play2.getValue().toString());
		pagarPlay3=total/Integer.parseInt(vm.sp_play3.getValue().toString());

		if(e.getSource()==vm.sp_play1) {
			vm.txt_playMonto1.setText(String.format("$ %.2f", montoPlay1));
		}else if(e.getSource()==vm.sp_play2) {
			vm.txt_playMonto2.setText(String.format("$ %.2f", montoPlay2));
		}else if(e.getSource()==vm.sp_play3) {
			vm.txt_playMonto3.setText(String.format("$ %.2f", montoPlay3));
		}
		vm.txt_montoTotal.setText(String.format("$ %.2f", total));
		vm.txt_playPagar1.setText(String.format("$ %.2f",pagarPlay1));
		vm.txt_playPagar2.setText(String.format("$ %.2f",pagarPlay2));
		vm.txt_playPagar3.setText(String.format("$ %.2f",pagarPlay3));
		
	}

}
