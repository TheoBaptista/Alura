package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AutorizacaoFilter() {

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
		
		System.out.println("AutorizacaoFilter");
		
		String paramAcao = request.getParameter("acao");
		
		HttpServletRequest HttpRequest = (HttpServletRequest) request;
	    HttpServletResponse HttpResponse = (HttpServletResponse) response;
		
		HttpSession sessao = HttpRequest.getSession();
        boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
        boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));;
        //as unicas acoes que não precisamos de verificacao
        
        if(ehUmaAcaoProtegida & usuarioNaoEstaLogado) {
            HttpResponse.sendRedirect("entrada?acao=LoginForm");
            return;
        }

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
