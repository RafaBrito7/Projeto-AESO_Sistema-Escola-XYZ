package barrosmelo.projeto.equipe1.api.exceptionhandle;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Problema {

	private Integer status;
	private String tipo;
	private String titulo;
	private String detalhe;

	private String mensagemDoUsuario;
	private LocalDateTime timeStamp;	

	public Problema(Integer status, String tipo, String titulo, String detalhe) {
		this.status = status;
		this.tipo = tipo;
		this.titulo = titulo;
		this.detalhe = detalhe;
	}

	public Integer getStatus() {
		return status;
	}

	public String getTipo() {
		return tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public String getMensagemDoUsuario() {
		return mensagemDoUsuario;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
}
