package barrosmelo.projeto.equipe1.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_disciplina")
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "nome_disciplina")
	private String nomeDisciplina;

	@Column(name = "carga_horaria")
	private Double cargaHoraria;

	@ManyToOne
	@JoinColumn(name = "id_turma")
	private Turma turma;
}
