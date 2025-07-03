package model;

import java.io.IOException;
import java.util.ArrayList;
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
	
	public boolean addBet() throws IOException {
		return archivo.writerFile(b.info(), false);
	}
	
	public List<bets> getBets(){
		List<bets> allBets=new ArrayList<>();
		try {
			String [] dataBet=archivo.readerFile().split("\n");
			for(String data:dataBet) {
				allBets.add(new bets(
						data.split(":")[0],
						data.split(":")[1],
						Double.parseDouble(data.split(":")[2]),
						data.split(":")[3]
						));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allBets;
	}
}
