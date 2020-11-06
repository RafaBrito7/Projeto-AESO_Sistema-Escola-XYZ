package barrosmelo.projeto.equipe1.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Matriculado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_matriculado")
	private Long idmatriculado;
	
	public Matriculado() {
		
	}

	public Long getIdmatriculado() {
		return idmatriculado;
	}

	public void setIdmatriculado(Long idmatriculado) {
		this.idmatriculado = idmatriculado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idmatriculado == null) ? 0 : idmatriculado.hashCode());
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
		Matriculado other = (Matriculado) obj;
		if (idmatriculado == null) {
			if (other.idmatriculado != null)
				return false;
		} else if (!idmatriculado.equals(other.idmatriculado))
			return false;
		return true;
	}
	
	
}
