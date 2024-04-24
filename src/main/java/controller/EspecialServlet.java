package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContaEspecial;

import java.io.IOException;

@WebServlet("/especial")
public class EspecialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContaEspecial c;
       
    public EspecialServlet() {
    	c = new ContaEspecial();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("especial.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("btn");
		String retorno;
		if (cmd.equals("Deposito")) {
			String valorDeposito = request.getParameter("valorDeposito");
			retorno = c.deposito(Float.parseFloat(valorDeposito));
			request.setAttribute("saida", retorno);
		} else if (cmd.equals("Saque")) {
			float valorSaque = Float.parseFloat(request.getParameter("valorSaque"));
			retorno = c.sacar(valorSaque);
			request.setAttribute("saida", retorno);
		} else if (cmd.equals("Dados")) {
			retorno = c.toString();
			request.setAttribute("saida", retorno);
		}
		RequestDispatcher rd = request.getRequestDispatcher("especial.jsp");
		rd.forward(request, response);
	}

}
