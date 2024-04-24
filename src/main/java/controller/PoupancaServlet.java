package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContaPoupanca;

import java.io.IOException;

@WebServlet("/poupanca")
public class PoupancaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContaPoupanca c;
       
    public PoupancaServlet() {
        c = new ContaPoupanca();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("poupanca.jsp");
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
		}else if (cmd.equals("Rendimento")) {
			float taxaRendimento = Float.parseFloat(request.getParameter("taxaRendimento"));
			retorno = c.calcNovoSaldo(taxaRendimento);
			request.setAttribute("saida", retorno);
		} else if (cmd.equals("Dados")) {
			retorno = c.toString();
			request.setAttribute("saida", retorno);
		}
		RequestDispatcher rd = request.getRequestDispatcher("Poupanca.jsp");
		rd.forward(request, response);
	}

}
