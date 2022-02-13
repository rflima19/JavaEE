package br.com.rafael.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@Named("upload")
@RequestScoped
public class UploadBean implements Serializable {

	private UploadedFile file;

	public UploadBean() {
		super();
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String upload() {
		String nameFile = this.file.getFileName();
		long sizeFile = this.file.getSize();
		
		String path = "C:/Users/Rafa/Desktop";
		UploadBean.copiarArquivoParaDiretorio(this.file, path);
		
		FacesMessage fm = new FacesMessage("Operação realizada", "O arquivo " + nameFile + " foi enviado com sucesso! Tamanho: " + sizeFile + " bytes");
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, fm);
		
		return null;
	}
	
	public void onUpload(FileUploadEvent event) {
		UploadedFile up = event.getFile();
		
		String path = "C:/Users/Rafa/Desktop";
		UploadBean.copiarArquivoParaDiretorio(up, path);
		
		String nameFile = up.getFileName();
		long sizeFile = up.getSize();
		
		FacesMessage fm = new FacesMessage("Operação realizada", "O arquivo " + nameFile + " foi enviado com sucesso! Tamanho: " + sizeFile + " bytes");
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, fm);
	}

	private static void copiarArquivoParaDiretorio(UploadedFile arquivo, String diretorio) {
		if (arquivo == null) {
			return;
		}
		OutputStream out = null;
		try {
			InputStream in = arquivo.getInputstream();
			File outFile = new File(diretorio, arquivo.getFileName());
			out = new FileOutputStream(outFile);
			byte[] buffer = new byte[1024];
			int qtdBytesLidos = 0;
			while ((qtdBytesLidos = in.read(buffer)) > -1) {
				out.write(buffer, 0, qtdBytesLidos);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
