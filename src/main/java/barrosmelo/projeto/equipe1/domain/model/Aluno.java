package barrosmelo.projeto.equipe1.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	@EqualsAndHashCode.Include
	private Long idAluno;

	private String nome;

	@Column(name = "data_nascimento")
	private Date dataNascimento;

	private String cpf;

	private Boolean vinculo;

	@Column(name = "data_vinculo")
	@CreationTimestamp
	private Date dataVinculo;

	@Column(name = "numero_matricula")
	private String numeroMatricula;

	@ManyToOne
	@JoinColumn(name = "idTurma")
	private Turma turma;

	@ManyToMany
	@JoinTable(name = "aluno_nota", joinColumns = @JoinColumn(name = "id_pessoa"), inverseJoinColumns = @JoinColumn(name = "id_nota"))
	private List<Nota> notas;
	
	@OneToOne
	@JoinColumn(name = "id_credencial")
	private Credencial usuario;
}
