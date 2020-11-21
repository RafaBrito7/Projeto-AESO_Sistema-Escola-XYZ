package barrosmelo.projeto.equipe1.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_professor")
	@EqualsAndHashCode.Include
	private Long idProfessor;

	private String nome;

	@Column(name = "data_nascimento")
	private Date dataNascimento;

	private String cpf;

	private Boolean vinculo;

	@Column(name = "data_vinculo")
	@CreationTimestamp
	private Date dataVinculo;

	private Boolean permissao;

	@ManyToOne
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;
	
	@OneToOne
	@JoinColumn(name = "id_credencial")
	private Credencial usuario;
}
