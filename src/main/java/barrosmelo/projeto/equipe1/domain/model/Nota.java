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
public class Nota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nota")
	@EqualsAndHashCode.Include
	private Long idNota;

	private Double nota;

	@ManyToOne
	@JoinColumn(name = "idAluno")
	private Aluno aluno;

	private String bimestre;

	@Column(name = "tipo_prova")
	private String tipoProva;
}