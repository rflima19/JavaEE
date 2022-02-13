package br.com.rafael.test.uploadarquivo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(name = "uploadServlet", 
			urlPatterns = {"/uploadServlet"} )
@MultipartConfig(location="C:/Users/Rafa/Downloads", 
			fileSizeThreshold=1024*1024, 
			maxFileSize=1024*1024*5, 
			maxRequestSize=1024*1024*5*5)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Collection<Part> parts = request.getParts();
//		
//		for (Part part : parts) {
//			System.out.println("Name do campo: " + part.getName());
//		}
		
		Part arquivo = request.getPart("arquivo");
		String ContentDisposition = arquivo.getHeader("Content-Disposition");
		//System.out.println(ContentDisposition);
		String fileName = this.getNameFile(ContentDisposition);
		//System.out.println(fileName);
		
		// grava o arquivo em disco
		arquivo.write(fileName);
		
		try (PrintWriter out = response.getWriter()) {
			response.setContentType("text/html");

			out.print("<!DOCTYPE html>\r\n");
			out.print("<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Upload</title>\r\n" + "</head>\r\n" + "<body>\r\n");
			out.print("<p>Upload do arquivo " + fileName + " concluido.</p>\r\n");
			out.print("</body>\r\n" + "</html>");
		}
	}
	
	/**
	 * Recupera o nome do arquivo do cabeçalho HTTP
	 * */
	private String getNameFile(String str) {
		String[] array1 = str.split(";");
		String aux = array1[array1.length - 1];
		String[] array2 = aux.split("=");
		String fileName = array2[array2.length - 1];
		fileName = fileName.replaceAll("\"", "");
		return fileName;
	}
}
