package barrosmelo.projeto.equipe1.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Serie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_serie")
	private Long serieId;

	@Column(name = "nome_serie")
	private String nomeSerie;

	@OneToMany(mappedBy = "serie")
	private List<Curso> cursos = new ArrayList<>();

	public Serie() {

	}

	public Long getSerieId() {
		return serieId;
	}

	public void setSerieId(Long id) {
		this.serieId = id;
	}

	public String getNomeSerie() {
		return nomeSerie;
	}

	public void setNomeSerie(String nomeSerie) {
		this.nomeSerie = nomeSerie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serieId == null) ? 0 : serieId.hashCode());
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
		Serie other = (Serie) obj;
		if (serieId == null) {
			if (other.serieId != null)
				return false;
		} else if (!serieId.equals(other.serieId))
			return false;
		return true;
	}
}
