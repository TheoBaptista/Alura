package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;



@WebServlet("/aplication")
public class AplicationService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	List<Empresa> empresas = new Banco().getEmpresas();
		
	Gson gson = new Gson();
	String json = gson.toJson(empresas);
	
	String valor = request.getHeader("accept");
	
	
	if(valor.contains("json")){
		
		response.setContentType("application/json");// aplicando no corpo da requisicao o tipo de conteudo que sera enviado
		response.getWriter().print(json);
		
		/*
		 * Devolvendo Json para o cliente atraves de uma requisicao http
		 * Usei o gson do google
		 */
		
		
	}else if(valor.contains("XML")){
		
		
		/*
		 * Agora usei o xstream para passar para xml o conteudo da list empresas
		 */
		
		XStream xstream = new XStream();
		xstream.alias("empresa", Empresa.class);
		//usamos esse metodo para usar o nome simples da classe e nao o full quali name
		String xml = xstream.toXML(empresas); 

		response.setContentType("application/xml");
		response.getWriter().print(xml);
			
		
		
	}else {
		
		response.setContentType("application/json");// aplicando no corpo da requisicao o tipo de conteudo que sera enviado
		response.getWriter().print(json);
	}
	
	
	
	
	
	
	
	
	
		
	}

}
