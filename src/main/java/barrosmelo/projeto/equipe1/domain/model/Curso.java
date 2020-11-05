package barrosmelo.projeto.equipe1.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso")
	private Long id;

	@Column(name = "nome_curso")
	private String nomeCurso;

	@Column(name = "carga_horaria_total")
	private Double cargaHorariaTotal;

	@ManyToOne
	@JoinColumn(name = "serieId")
	private Serie serie;

	public Curso() {

	}

	public Curso(String nomeCurso, Double cargaHorarioTotal, Long serieId) {
		this.nomeCurso = nomeCurso;
		this.cargaHorariaTotal = cargaHorarioTotal;
		this.serie.setSerieId(serieId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Double getCargaHorariaTotal() {
		return cargaHorariaTotal;
	}

	public void setCargaHorariaTotal(Double cargaHorariaTotal) {
		this.cargaHorariaTotal = cargaHorariaTotal;
	}	

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nomeCurso=" + nomeCurso + ", cargaHorariaTotal=" + cargaHorariaTotal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
