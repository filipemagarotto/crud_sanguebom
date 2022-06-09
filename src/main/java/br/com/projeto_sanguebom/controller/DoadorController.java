package br.com.projeto_sanguebom.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto_sanguebom.jdbc.doadorDAO;
import br.com.projeto_sanguebom.model.Doador;

/**
 * Servlet implementation class DoadorController
 */
@WebServlet("/doadorcontroller.do")
public class DoadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		doadorDAO dao = new doadorDAO();
		
		if(acao!=null && acao.equals("exc")) {
			String id = request.getParameter("id");
			Doador doador = new Doador();
			doador.setId(Integer.parseInt(id));
			dao.deletarDoador(doador);	

			response.sendRedirect("/projeto_sanguebom/index.jsp");
			
		} else if(acao!=null && acao.equals("alt")) {
			String id = request.getParameter("id");
			Doador doador = dao.buscarPorId(Integer.parseInt(id));
			System.out.println(doador.getId());
			request.setAttribute("doador", doador);
			RequestDispatcher saida = request.getRequestDispatcher("frmdoador.jsp");
			saida.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doadorDAO dao = new doadorDAO();
		
		String id = request.getParameter("idCadastro");
		String nome = request.getParameter("nomeCadastro");
		String cpf = request.getParameter("cpfCadastro");
		String telefone = request.getParameter("telefoneCadastro");
		String email = request.getParameter("emailCadastro");
		String nascimento = request.getParameter("nascimentoCadastro");
		String uf = request.getParameter("ufCadastro");
		String cidade = request.getParameter("cidadeCadastro");
		String tipoSanguineo = request.getParameter("tipoSanguineoCadastro");
		
		Calendar c1 = Calendar.getInstance();
		int dia = c1.get(Calendar.DAY_OF_MONTH);
		int mes = c1.get(Calendar.MONTH)+1;
		int ano = c1.get(Calendar.YEAR);
		int hora = c1.get(Calendar.HOUR_OF_DAY);
		int minuto = c1.get(Calendar.MINUTE);
		
		String criacao = Integer.toString(dia)+"/"+Integer.toString(mes)+
				"/"+Integer.toString(ano)+" "+Integer.toString(hora)+":"+Integer.toString(minuto);
		
		Doador doador = new Doador();
		
		System.out.println("id " + id);
		System.out.println("nome " + nome);
		if(id!=null && id!="" && id!="0") {
			doador.setId(Integer.parseInt(id));
			doador.setDataUltimaModificacao(criacao);
		} else {
			doador.setDataUltimaModificacao(null);
			doador.setDataCriacao(criacao);
		}
		doador.setNome(nome);
		doador.setCpf(cpf);
		doador.setEmail(email);
		doador.setUf(uf);
		doador.setDataNascimento(nascimento);
		doador.setTelefone(telefone);
		doador.setCidade(cidade);
		doador.setTipo_sanguineo(tipoSanguineo);
		
		dao.cadastrar(doador);
		
		response.sendRedirect("/projeto_sanguebom/index.jsp");
	
	}

}
