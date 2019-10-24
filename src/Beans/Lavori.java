package Beans;

import java.math.BigDecimal;
import java.sql.Date;

public class Lavori 
{
	private int idLavoro;
	private String Descrizione;
	private Date DataPrenotazione;
	private BigDecimal SpeseMateriale,Pagamento;
	
	public Lavori(int idLavoro,String Descrizione,Date DataPrenotazione,BigDecimal SpeseMateriale, BigDecimal Pagamento) {
		this.idLavoro=idLavoro;
		this.Descrizione=Descrizione;
		this.DataPrenotazione=DataPrenotazione;
		this.SpeseMateriale=SpeseMateriale;
		this.Pagamento=Pagamento;
	}
	public Lavori() {
		
	}
	public Lavori(String Descrizione, Date DataPrenotazione,BigDecimal SpeseMateriale) 
	{
		this.Descrizione=Descrizione;
		this.DataPrenotazione=DataPrenotazione;
		this.SpeseMateriale=SpeseMateriale;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	public Date getDataPrenotazione() {
		return DataPrenotazione;
	}
	public void setDataPrenotazione(Date dataPrenotazione) {
		DataPrenotazione = dataPrenotazione;
	}
	public BigDecimal getSpeseMateriale() {
		return SpeseMateriale;
	}
	public void setSpeseMateriale(BigDecimal speseMateriale) {
		SpeseMateriale = speseMateriale;
	}
	public BigDecimal getPagamento() {
		return Pagamento;
	}
	public void setPagamento(BigDecimal pagamento) {
		Pagamento = pagamento;
	}
	public int getIdLavoro() {
		return idLavoro;
	}
	public void setIdLavoro(int idLavoro) {
		this.idLavoro = idLavoro;
	}
	
}
