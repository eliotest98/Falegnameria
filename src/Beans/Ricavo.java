package Beans;

import java.math.BigDecimal;

public class Ricavo 
{
	private int idRicavo,Mese;
	private BigDecimal Ricavo;
	public Ricavo(int idRicavo, BigDecimal Ricavo,int Mese) 
	{
		this.idRicavo=idRicavo;
		this.Ricavo=Ricavo;
		this.Mese=Mese;
	}
	public Ricavo(BigDecimal Ricavo,int Mese) 
	{
		this.Ricavo=Ricavo;
		this.Mese=Mese;
	}
	public Ricavo() {
		
	}
	public int getIdRicavo() {
		return idRicavo;
	}
	public void setIdRicavo(int idRicavo) {
		this.idRicavo = idRicavo;
	}
	public BigDecimal getRicavo() {
		return Ricavo;
	}
	public void setRicavo(BigDecimal ricavo) {
		Ricavo = ricavo;
	}
	public int getMese() {
		return Mese;
	}
	public void setMese(int mese) {
		Mese = mese;
	}
}
