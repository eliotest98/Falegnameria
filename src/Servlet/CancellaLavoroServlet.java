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

import Beans.Ricavo;
import Database.DatabaseQuary;

/**
 * Servlet implementation class CancellaLavoroServlet
 */
@WebServlet("/CancellaLavoroServlet")
public class CancellaLavoroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancellaLavoroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idLavoro = request.getParameter("idLavoro");
		String Ricavo = request.getParameter("Ricavo");
		System.out.println(idLavoro);
		System.out.println(Ricavo);
		if(idLavoro == null)
		{
			System.out.println("Ricevuto valore nullo");
		}
		else {
			System.out.println("Servlet: ricevuta richiesta cancellazione e inserimento");
			int idLavor = Integer.parseInt(idLavoro);
			BigDecimal ricavo = new BigDecimal(Ricavo);
			GregorianCalendar oggi = new GregorianCalendar();
			int mese = oggi.MONTH+5;
		try {
			DatabaseQuary.delLavoro(idLavor);
			DatabaseQuary.aggiungiRicavo(new Ricavo(ricavo,mese));
			request.getRequestDispatcher("GetListaLavori").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
