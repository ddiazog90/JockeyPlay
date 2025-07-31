 package controller;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import model.bets;
import model.betsDAO;
import view.lienzo;
import view.view_main;

public class actPlay extends Thread{
	private lienzo l;
	private view_main vm;
	private int play;
	private final Object monitor=new Object();
	private boolean paused=false;
	


	public actPlay(lienzo l, int play_,view_main vm) {
		super();
		this.l = l;
		this.vm=vm;
		play=play_;
	}
	
	public int getRandomValue(int range) {
		return (int)(Math.random()*range);
	}
	public void run() {
		while(true) {
			while(paused) {
				synchronized(monitor) {
					try {
						monitor.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			switch(play) {
			case 1->l.setObj1X(getRandomValue(20));
			case 2->l.setObj2X(getRandomValue(20));
			case 3->l.setObj3X(getRandomValue(20));
			case 4->l.setObj5X(getRandomValue(20));
			case 5->l.setObj6X(getRandomValue(20));
			case 6->l.setObj7X(getRandomValue(20));
			}
			if(l.collisionObj1()||l.collisionObj2()||l.collisionObj3()||
					l.collisionObj5()||l.collisionObj6()||l.collisionObj7())
				break;
			try {
				sleep(getRandomValue(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			sleep(5000);
			
			winner(); //Permite obtener los ganadores 
			//premio();
			l.estadoInicial();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void pausar() {
		synchronized(monitor) {
			paused=true;
		}
	}
	public void continuar() {
		synchronized(monitor) {
			paused=false;
			monitor.notify();
		}
	}
	public void premio() {
				String etiqueta="";
				if(l.getWinner().equals(l.getPlayName1())) 
					etiqueta= String.format("Ganador %s!!! \n Premio:%s \n Ganadores:%d \n Premio individual:%s", 
											l.getWinner(),vm.txt_montoTotal.getText(),Integer.parseInt(vm.sp_play1.getValue().toString())
											,vm.txt_playPagar1.getText());
				else if(l.getWinner().equals(l.getPlayName2())) 
					etiqueta= String.format("Ganador %s!!! \n Premio:%s \n Ganadores:%d \n Premio individual:%s", 
							l.getWinner(),vm.txt_montoTotal.getText(),Integer.parseInt(vm.sp_play2.getValue().toString())
							,vm.txt_playPagar2.getText());
				else if(l.getWinner().equals(l.getPlayName3())) 
					etiqueta= String.format("Ganador %s!!! \n Premio:%s \n Ganadores:%d \n Premio individual:%s", 
							l.getWinner(),vm.txt_montoTotal.getText(),Integer.parseInt(vm.sp_play3.getValue().toString())
							,vm.txt_playPagar3.getText());
				
				else if(l.getWinner().equals(l.getPlayName5())) 
					etiqueta= String.format("Ganador %s!!! \n Premio:%s \n Ganadores:%d \n Premio individual:%s", 
							l.getWinner(),vm.txt_montoTotal.getText(),Integer.parseInt(vm.sp_play4.getValue().toString())
							,vm.txt_playPagar4.getText());
				else if(l.getWinner().equals(l.getPlayName6())) 
					etiqueta= String.format("Ganador %s!!! \n Premio:%s \n Ganadores:%d \n Premio individual:%s", 
							l.getWinner(),vm.txt_montoTotal.getText(),Integer.parseInt(vm.sp_play5.getValue().toString())
							,vm.txt_playPagar5.getText());
				else if(l.getWinner().equals(l.getPlayName7())) 
					etiqueta= String.format("Ganador %s!!! \n Premio:%s \n Ganadores:%d \n Premio individual:%s", 
							l.getWinner(),vm.txt_montoTotal.getText(),Integer.parseInt(vm.sp_play6.getValue().toString())
							,vm.txt_playPagar6.getText());
				JOptionPane.showMessageDialog(l,etiqueta,"Carrera de Caballos",JOptionPane.INFORMATION_MESSAGE);
			
	}
	
	private void winner() throws IOException {
		synchronized(monitor) {
			betsDAO bdao=new betsDAO();
			List<bets>allBets=bdao.getBets();
			if(!allBets.get(0).getCod().equals("-1")) {
				String msg="";
				for(bets b:allBets) {
					if(b.getPlay().equals(l.getWinner())) {
						double valor=0,cdf=0;
						//valor=Double.parseDouble(vm.txt_playPagar1.getText().split(" ")[1].replace(',', '.'));
						if(l.getWinner().equals(l.getPlayName1()))
							valor=getValor(vm.txt_playPagar1.getText());
						else if(l.getWinner().equals(l.getPlayName2()))
							valor=getValor(vm.txt_playPagar2.getText());
						else if(l.getWinner().equals(l.getPlayName3()))
							valor=getValor(vm.txt_playPagar3.getText());
						else if(l.getWinner().equals(l.getPlayName5()))
							valor=getValor(vm.txt_playPagar4.getText());
						else if(l.getWinner().equals(l.getPlayName6()))
							valor=getValor(vm.txt_playPagar5.getText());
						else if(l.getWinner().equals(l.getPlayName7()))
							valor=getValor(vm.txt_playPagar6.getText());
						cdf=Double.parseDouble(b.getMonto())/Double.parseDouble(vm.txt_base.getText().split(" ")[1]);		
						msg+=("Bet:"+b.getAlias()+" Caballo:"+b.getPlay()+" CDFS:"+cdf +"A Pagar $"+(cdf*valor))+"\n";
						System.out.println(msg);
					}
				}
				bdao.backup(msg);
				clearValues();//limpia los campos de los spinners para los jugadores
			}
		}
	}
	
	private double getValor(String value) {
		return Double.parseDouble(value.split(" ")[1].replace(',', '.'));
	}
	private void clearValues() {
		vm.sp_play1.setValue(0);
		vm.sp_play2.setValue(0);
		vm.sp_play3.setValue(0);
		vm.sp_play4.setValue(0);
		vm.sp_play5.setValue(0);
		vm.sp_play6.setValue(0);
		
	}

}
