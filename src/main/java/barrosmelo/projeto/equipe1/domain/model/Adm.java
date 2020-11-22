package barrosmelo.projeto.equipe1.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Adm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_adm")
	@EqualsAndHashCode.Include
	private Long idAdm;

	@NotNull
	@NotEmpty
	@NotBlank
	private String nome;

	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	@NotNull
	@NotEmpty
	@NotBlank
	@Size(max = 11)
	private String cpf;

	private Boolean vinculo;

	@Column(name = "data_vinculo")
	@CreationTimestamp
	private Date dataVinculo;
	
	@NotNull
	private Boolean permissao;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "id_credencial")
	private Credencial credencial;
}
