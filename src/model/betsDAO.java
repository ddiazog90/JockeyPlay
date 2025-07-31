package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import libreriaGenerica.files;

public class betsDAO {
	private bets b;
	private files archivo=new files("src/sources/bets.txt");

	public betsDAO(bets b) {
		super();
		this.b = b;
	}

	public betsDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Permite agregar los apostadores
	 * @return
	 * @throws IOException
	 */
	public boolean addBet() throws IOException {
		String [] dataBet=archivo.readerFile().split("\n");//last
		if(dataBet[0].split(":")[0].equals("-1"))//last
			return archivo.writerFile(b.info(), true);//las
		else//last
			return archivo.writerFile(b.info(), false);
	}
	/**
	 * Permite obtener los apostadores
	 * @return
	 */
	public List<bets> getBets(){
		List<bets> allBets=new ArrayList<>();
		try {
			String [] dataBet=archivo.readerFile().split("\n");
			//if(dataBet.length==1) {
				
			//}else {
				for(String data:dataBet) {
					allBets.add(new bets(
							data.split(":")[0],
							data.split(":")[1],
							Double.parseDouble(data.split(":")[2]),
							data.split(":")[3]
							));
				}
			//}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allBets;
	}
	
	public boolean backup(String winner) throws IOException{
		files backup=new files("src/sources/respaldo.txt");
		backup.writerFile(etiqueta()+archivo.readerFile()+"\n"+winner, false);
		return clearFile();
	}
	private String etiqueta() {
		return String.format("**************************************\n %s \n**************************************\n",new Date().toString());
	}
	public boolean clearFile() throws IOException {
		b=new bets("-1","null",0,"null");
		return archivo.writerFile(b.info(), true);
	}
}
