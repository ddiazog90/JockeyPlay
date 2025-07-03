package model;

import libreriaGenerica.generic;

public class bets {
	private generic<String,String> dt_b;
	public bets() {
		super();
		dt_b=new generic<>();
	}
	public bets(String cod, String alias, double monto, String play) {
		dt_b=new generic<>(cod,alias,String.valueOf(monto),play);
	}
	public String getCod() {
		return dt_b.getAttribute1();
	}
	public String getAlias() {
		return dt_b.getAttribute2();
	}
	public String getMonto() {
		return dt_b.getAttribute3();
	}
	public String getPlay() {
		return dt_b.getAttribute4();
	}
	public String info() {
		return String.format("%s:%s:%s:%s", getCod(),getAlias(),getMonto(),getPlay());
	}

}
