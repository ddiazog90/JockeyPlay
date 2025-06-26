package controller;

public class generateCod extends Thread{
	
	private String cod="";
	public generateCod(String play) {
		cod=play.substring(0, 3).concat("-");
	}
	private int getRandomNumber() {
		return (int)(Math.random()*10);
	}
	public void run() {
		for(int i=0;i<5;i++) {
			
			cod+=(String.valueOf(getRandomNumber()));
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public String getCod() {
		return cod;
	}

}
