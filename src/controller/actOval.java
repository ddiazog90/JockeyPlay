package controller;

import java.awt.Color;

import view.lienzo;

public class actOval extends Thread{
	private lienzo l;
	private boolean flag=true;
	
	
	
	public actOval(lienzo l) {
		super();
		this.l = l;
	}
	public void run() {
		int aux=0;
		for(int i=0;i<300;i++) {
			if(flag) {
				l.setObj1X(i);
				if(i%7==0)
					l.setObj1Y(i);
				aux=i;//lleva el control de la variable i
				
			}else {
				i=aux;//Mantiene el estado del for
				l.setColor(new Color(getRandomValue(),
						getRandomValue()
						,getRandomValue()));
			}		
					
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void continuar() {
		flag=true;		
	}
	public void pausar() {
		flag=false;
	}
	public int getRandomValue() {
		return (int)(Math.random()*255);
	}

}
