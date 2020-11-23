package barrosmelo.projeto.equipe1.domain.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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

	@ManyToMany
	@JoinTable(name = "curso_turma", joinColumns = @JoinColumn(name = "id_curso"), inverseJoinColumns = @JoinColumn(name = "turma_id"))
	private Set<Turma> turma;

	@ManyToMany
	@JoinTable(name = "curso_disciplina", joinColumns = @JoinColumn(name = "id_curso"), inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
	private Set<Disciplina> disciplinas;

	public Curso() {

	}

	public Long getId() {
		return id;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public Double getCargaHorariaTotal() {
		return cargaHorariaTotal;
	}

	public Set<Turma> getTurma() {
		return turma;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public void setCargaHorariaTotal(Double cargaHorariaTotal) {
		this.cargaHorariaTotal = cargaHorariaTotal;
	}

	public void setTurma(Set<Turma> turma) {
		this.turma = turma;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
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

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nomeCurso=" + nomeCurso + ", cargaHorariaTotal=" + cargaHorariaTotal + ", turma="
				+ turma + ", disciplinas=" + disciplinas + "]";
	}
}
