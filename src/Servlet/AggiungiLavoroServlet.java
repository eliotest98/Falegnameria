package Servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Cliente;
import Beans.Lavori;
import Database.DatabaseQuary;

/**
 * Servlet implementation class AggiungiLavoroServlet
 */
@WebServlet("/AggiungiLavoroServlet")
public class AggiungiLavoroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiLavoroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String NomePersona = request.getParameter("NomePersona");
		String NumeroTelefono = request.getParameter("NumeroTelefono");
		String SpeseMateriale = request.getParameter("SpeseMateriale");
		String DescrizioneLavoro = request.getParameter("DescrizioneLavoro");
		GregorianCalendar oggi = new GregorianCalendar();
		int giorno = oggi.DAY_OF_MONTH+16;
		int mese = oggi.MONTH+4;
		int anno = oggi.YEAR+118;
		Date Data = new Date(anno,mese,giorno);
		System.out.println(Data);
		long Numero = Long.parseLong(NumeroTelefono);
		BigDecimal Spesa = new BigDecimal(SpeseMateriale);
		Lavori lav = new Lavori(DescrizioneLavoro,Data,Spesa);
		Cliente cli = new Cliente(NomePersona,Numero);
		try {
			DatabaseQuary.addLavoro(lav);
			DatabaseQuary.addCliente(cli);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
