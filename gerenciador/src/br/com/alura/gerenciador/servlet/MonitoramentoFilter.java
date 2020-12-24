package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MonitoramentoFilter
 */
@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public MonitoramentoFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("MonitoramentoFilter");

		String acao = request.getParameter("acao");

		long inicio = System.currentTimeMillis();

		chain.doFilter(request, response);

		long fim = System.currentTimeMillis();

		System.out.println("Tempo de execucao da acao "+acao+" : "+(fim-inicio));

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
