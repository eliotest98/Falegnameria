package Servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DatabaseQuary;

/**
 * Servlet implementation class PagaLavoroServlet
 */
@WebServlet("/PagaLavoroServlet")
public class PagaLavoroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagaLavoroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idLavoro = request.getParameter("idLavoro");
		String Pagamento = request.getParameter("Pagamento");
		System.out.println(idLavoro);
		System.out.println(Pagamento);
		if(idLavoro == null)
		{
			System.out.println("Ricevuto valore nullo");
		}
		else {
			System.out.println("Servlet: ricevuta richiesta di update");
			int idLavor = Integer.parseInt(idLavoro);
			BigDecimal Pagament = new BigDecimal(Pagamento);
		try {
			DatabaseQuary.updatePagamento(idLavor,Pagament);
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
