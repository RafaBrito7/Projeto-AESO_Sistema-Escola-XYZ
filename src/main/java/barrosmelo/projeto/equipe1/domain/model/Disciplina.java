package barrosmelo.projeto.equipe1.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_disciplina")
	private Long id;

	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name = "nome_disciplina")
	private String nomeDisciplina;

	@Column(name = "carga_horaria")
	private Double cargaHoraria;

	@ManyToOne
	@JoinColumn(name = "id_turma")
	private Turma turma;

	public Disciplina() {

	}

	public Long getId() {
		return id;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public Double getCargaHoraria() {
		return cargaHoraria;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
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
		Disciplina other = (Disciplina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nomeDisciplina=" + nomeDisciplina + ", cargaHoraria=" + cargaHoraria
				+ ", turma=" + turma + "]";
	}
}
