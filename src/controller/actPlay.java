 package controller;

import javax.swing.JOptionPane;

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
			}
			if(l.collisionObj1()||l.collisionObj2()||l.collisionObj3())
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
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		premio();
		l.estadoInicial();
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
				JOptionPane.showMessageDialog(l,etiqueta,"Carrera de Caballos",JOptionPane.INFORMATION_MESSAGE);
			
	}

}
