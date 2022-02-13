package br.com.rafael.test.respostabinaria;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ArquivoServlet
 */
@WebServlet(description = "Servlet para enviar como resposta um arquivo para o cliente fazer download", urlPatterns = { "/arquivo" })
public class ArquivoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArquivoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (OutputStream out = response.getOutputStream()) {
			
			File path = new File("C:/Users/Rafa/Desktop/arquivo.zip");
			if (path.exists()) {
			
				// primeiro temos de informa ao browser qual tipo de dados estamos retornando
				response.setContentType("application/zip");
			
				// informa ao cliente uma sugestão de nome do arquivo
				response.setHeader("Content-Disposition", "attachment; filename=arquivo.zip");
			
			
				try (FileInputStream fileZip = new FileInputStream(path)) {
					byte[] buffer = new byte[1024];
					int qtdBytesLidos = 0;
					while ((qtdBytesLidos = fileZip.read(buffer)) > -1) {
						out.write(buffer, 0, qtdBytesLidos);
					}
				}
			} else {
				System.out.println("Erro: arquivo não encontrado!");
			}
		}
	}

}
