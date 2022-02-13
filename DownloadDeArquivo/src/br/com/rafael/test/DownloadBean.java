package br.com.rafael.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

@Named
@RequestScoped
public class DownloadBean implements Serializable {

	@Inject
	private FacesContext fc;
	@Inject
	private ExternalContext ec;
	
	public String download() {
		HttpServletResponse response = (HttpServletResponse) this.ec.getResponse();
		response.setHeader("Content-Disposition", "attachment;filename=\"aula JSF.pdf\"");
		response.setContentType("application/pdf");
		
		int totalBytes = 0;
		
		try (InputStream in = this.ec.getResourceAsStream("/WEB-INF/JSF.pdf")) {
			OutputStream out = response.getOutputStream();
			totalBytes = this.copy(in, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		response.setContentLength(totalBytes);
		
		this.fc.responseComplete();
		
		return null;
	}
	
	private int copy(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		int len;
		int totalBytes = 0;
		
		while(true) {
			len = in.read(buffer);
			if (len < 0) {
				break;
			}
			totalBytes += len;
			out.write(buffer, 0, len);
		}
		
		return totalBytes;
	}
}
