package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import model.bets;
import model.betsDAO;
import view.view_main;

public class processBets extends Thread{
	
	private view_main vm;
	private logic_view_main lvm;
	private betsDAO bdao;
	private List<bets> allBets=new ArrayList<>();
	private boolean state=true;
	public processBets(view_main vm, logic_view_main lvm) {
		super();
		this.vm = vm;
		this.lvm = lvm;
		bdao=new betsDAO();
		if(bdao.getBets().size()!=0)
			allBets=bdao.getBets();
	}
	/**
	 * Este metodo permite cargar el numero de apuestas
	 */
	public synchronized void loadBets() {
		double base=Double.parseDouble(vm.txt_base.getText().split(" ")[1]);
		encerrarCampos();
		for(bets b:allBets) {
			int apuesta=0;
			if(vm.txt_playName1.getText().equals(b.getPlay())) {
				apuesta=Integer.parseInt(vm.sp_play1.getValue().toString());
				apuesta+=(int)(Double.parseDouble(b.getMonto())/base);
				vm.sp_play1.setValue(apuesta);
			}else if(vm.txt_playName2.getText().equals(b.getPlay())) {
				apuesta=Integer.parseInt(vm.sp_play2.getValue().toString());
				apuesta+=(int)(Double.parseDouble(b.getMonto())/base);
				vm.sp_play2.setValue(apuesta);
			}else if(vm.txt_playName3.getText().equals(b.getPlay())) {
				apuesta=Integer.parseInt(vm.sp_play3.getValue().toString());
				apuesta+=(int)(Double.parseDouble(b.getMonto())/base);
				vm.sp_play3.setValue(apuesta);
			}else if(vm.txt_playName4.getText().equals(b.getPlay())) {
				apuesta=Integer.parseInt(vm.sp_play4.getValue().toString());
				apuesta+=(int)(Double.parseDouble(b.getMonto())/base);
				vm.sp_play4.setValue(apuesta);
			}else if(vm.txt_playName5.getText().equals(b.getPlay())) {
				apuesta=Integer.parseInt(vm.sp_play5.getValue().toString());
				apuesta+=(int)(Double.parseDouble(b.getMonto())/base);
				vm.sp_play5.setValue(apuesta);
			}else if(vm.txt_playName6.getText().equals(b.getPlay())) {
				apuesta=Integer.parseInt(vm.sp_play6.getValue().toString());
				apuesta+=(int)(Double.parseDouble(b.getMonto())/base);
				vm.sp_play6.setValue(apuesta);
			}
		}
		lvm.calMontoBets();
	}
	public void run() {
		while(true) {
			if(state) {
				loadBets();
				state=false;
			}else {
				if(allBets.size()<bdao.getBets().size()) {
					allBets=bdao.getBets();
					state=true;
				}
			}
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void encerrarCampos() {
		vm.sp_play1.setValue(0);
		vm.sp_play2.setValue(0);
		vm.sp_play3.setValue(0);
		vm.sp_play4.setValue(0);
		vm.sp_play5.setValue(0);
		vm.sp_play6.setValue(0);
	}
	
	
	
	
	

}
