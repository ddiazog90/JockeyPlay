package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class lienzo extends JPanel{
	private position obj1,obj2,obj3,obj4,obj5,obj6,obj7;
	private Color color=Color.YELLOW;
	private String playName1="ECLIPSE",playName2="PERCHERON",playName3="LUCAS",
			playName5="MIGUELITO",playName6="ROGELIO",playName7="PEGASSO";
	private String winner;
	
	public lienzo() {
		estadoInicial();
		setBounds(0,0,this.getWidth(),this.getHeight());
		repaint();
	}
	
	public void paint(Graphics g) {
		Font font=new Font("Arial",Font.BOLD,12);
		Font fontWin=new Font("Commic",Font.BOLD,40);
		//Permite agregar un color a la figura
		ImageIcon fondo=new ImageIcon("src/images/fondo2.jpg");
		g.drawImage(fondo.getImage(),0,0,this.getWidth(),this.getHeight(),null);
		//Fuente de texto
		g.setColor(Color.BLACK);
		g.setFont(font);
		//muro de llegada
		g.setColor(Color.WHITE);
		g.fillRect(obj4.x, obj4.y, obj4.width, obj4.height);
		//carga de competidores
		//play 1
		ImageIcon play1=new ImageIcon("src/images/play1.png");
		g.drawImage(play1.getImage(), obj1.x, obj1.y, obj1.width, obj1.height, null);
		g.drawString(playName1, 5+obj1.x, obj1.y+10);
		//play 2
		ImageIcon play2=new ImageIcon("src/images/play2.png");
		g.drawImage(play2.getImage(), obj2.x, obj2.y, obj2.width, obj2.height, null);
		g.drawString(playName2, 5+obj2.x, obj2.y+10);
		//play 3
		ImageIcon play3=new ImageIcon("src/images/play3.png");
		g.drawImage(play3.getImage(), obj3.x, obj3.y,obj3.width, obj3.height, null);
		g.drawString(playName3, 5+obj3.x, obj3.y+10);
		//play 5
		ImageIcon play5=new ImageIcon("src/images/play5.png");
		g.drawImage(play5.getImage(), obj5.x, obj5.y, obj5.width, obj5.height, null);
		g.drawString(playName5, 5+obj5.x, obj5.y+10);
		//play 6
		ImageIcon play6=new ImageIcon("src/images/play6.png");
		g.drawImage(play6.getImage(), obj6.x, obj6.y, obj6.width, obj6.height, null);
		g.drawString(playName6, 5+obj6.x, obj6.y+10);
		//play 7
		ImageIcon play7=new ImageIcon("src/images/play4.png");
		g.drawImage(play7.getImage(), obj7.x, obj7.y,obj7.width, obj7.height, null);
		g.drawString(playName7, 5+obj7.x, obj7.y+10);		
		


		if(collisionObj1()||collisionObj2()||collisionObj3()||
				collisionObj5()||collisionObj6()||collisionObj7()) {
			g.setFont(fontWin);
			g.setColor(Color.BLUE);
			winner = "";
			if(collisionObj1()) {
				winner=playName1;				
			}
			if(collisionObj2()) {
				winner=playName2;
			}
			if(collisionObj3()) {
				winner=playName3;
			}
			if(collisionObj5()) {
				winner=playName5;				
			}
			if(collisionObj6()) {
				winner=playName6;
			}
			if(collisionObj7()) {
				winner=playName7;
			}
			g.drawString("****WINNER****", getWidth()/2-80, 50);
			g.drawString(winner+"!!!", getWidth()/2-60, 85);
			
		}
		
	}
	public void setObj1X(int x) {
		obj1.x+=x;
		repaint();
	}
	public void setObj1Y(int y) {
		obj1.y=y;
		repaint();
	}
	public void setObj2X(int x) {
		obj2.x+=x;
		repaint();
	}
	public void setObj3X(int x) {
		obj3.x+=x;
		repaint();
	}
	public void setObj5X(int x) {
		obj5.x+=x;
		repaint();
	}
	public void setObj6X(int x) {
		obj6.x+=x;
		repaint();
	}
	public void setObj7X(int x) {
		obj7.x+=x;
		repaint();
	}
	
	public void setColor(Color color_) {
		color=color_;
		repaint();
	}
	public void setPla1(String play1) {
		this.playName1 = play1;
		repaint();
	}
	public void setPlay2(String play2) {
		this.playName2 = play2;
		repaint();
	}
	public void setPlay3(String play3) {
		this.playName3 = play3;
		repaint();
	}
	public String getPlayName1() {
		return playName1;
	}
	public String getPlayName2() {
		return playName2;
	}
	public String getPlayName3() {
		return playName3;
	}
	public void setPlay5(String play5) {
		this.playName5 = play5;
		repaint();
	}
	public void setplay6(String play6) {
		this.playName6 = play6;
		repaint();
	}
	public void setplay7(String play7) {
		this.playName7 = play7;
		repaint();
	}
	public String getPlayName5() {
		return playName5;
	}
	public String getPlayName6() {
		return playName6;
	}
	public String getPlayName7() {
		return playName7;
	}

	public boolean collisionObj1() {
		Rectangle OBJ1=new Rectangle(obj1.x,obj1.y,obj1.width,obj1.height);
		Rectangle OBJ4=new Rectangle(obj4.x,obj4.y,obj4.width,obj4.height);
		return OBJ1.intersects(OBJ4);
	}
	public boolean collisionObj2() {
		Rectangle OBJ2=new Rectangle(obj2.x,obj2.y,obj2.width,obj2.height);
		Rectangle OBJ4=new Rectangle(obj4.x,obj4.y,obj4.width,obj4.height);
		return OBJ2.intersects(OBJ4);
	}
	public boolean collisionObj3() {
		Rectangle OBJ3=new Rectangle(obj3.x,obj3.y,obj3.width,obj3.height);
		Rectangle OBJ4=new Rectangle(obj4.x,obj4.y,obj4.width,obj4.height);
		return OBJ3.intersects(OBJ4);
	}
	public boolean collisionObj5() {
		Rectangle OBJ5=new Rectangle(obj5.x,obj5.y,obj5.width,obj5.height);
		Rectangle OBJ4=new Rectangle(obj4.x,obj4.y,obj4.width,obj4.height);
		return OBJ5.intersects(OBJ4);
	}
	public boolean collisionObj6() {
		Rectangle OBJ6=new Rectangle(obj6.x,obj6.y,obj6.width,obj6.height);
		Rectangle OBJ4=new Rectangle(obj4.x,obj4.y,obj4.width,obj4.height);
		return OBJ6.intersects(OBJ4);
	}
	public boolean collisionObj7() {
		Rectangle OBJ7=new Rectangle(obj7.x,obj7.y,obj7.width,obj7.height);
		Rectangle OBJ4=new Rectangle(obj4.x,obj4.y,obj4.width,obj4.height);
		return OBJ7.intersects(OBJ4);
	}
	public void estadoInicial() {
		obj1=new position(10,248,100,60);
		obj2=new position(10,288,100,60);
		obj3=new position(10,328,100,60);
		obj4=new position(1230,275,15,250);//punto de llegada
		obj5=new position(10,368,100,60);
		obj6=new position(10,408,100,60);
		obj7=new position(10,438,100,60);
		repaint();
	}

	public String getWinner() {
		return winner;
	}

	
}
