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

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
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
}
