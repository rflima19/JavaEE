package br.com.rafael.test;

import java.io.InputStream;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named("download")
@RequestScoped
public class DownloadBean implements Serializable {

	private StreamedContent file;

	public DownloadBean() {
		super();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("/download/fileDownload.pdf");
		this.file = new DefaultStreamedContent(in, "application/pdf", "doc.pdf");
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

}
