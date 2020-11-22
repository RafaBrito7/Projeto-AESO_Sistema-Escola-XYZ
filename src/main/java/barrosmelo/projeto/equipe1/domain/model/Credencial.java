package barrosmelo.projeto.equipe1.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Credencial {

	@Id
	@Column(name = "id_credendial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCredencial;

	@NotBlank
	@NotEmpty
	@NotNull
	private String usuario;

	@NotBlank
	@NotEmpty
	@NotNull
	private String senha;

	@NotBlank
	@NotEmpty
	@NotNull
	private String TipoUsuario;

	public Credencial() {

	}

	public Long getIdCredencial() {
		return idCredencial;
	}

	public void setIdCredencial(Long idCredencial) {
		this.idCredencial = idCredencial;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoUsuario() {
		return TipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCredencial == null) ? 0 : idCredencial.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credencial other = (Credencial) obj;
		if (idCredencial == null) {
			if (other.idCredencial != null)
				return false;
		} else if (!idCredencial.equals(other.idCredencial))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Credencial [idCredencial=" + idCredencial + ", usuario=" + usuario + ", senha=" + senha
				+ ", TipoUsuario=" + TipoUsuario + "]";
	}
}