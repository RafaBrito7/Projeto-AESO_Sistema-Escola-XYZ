package barrosmelo.projeto.equipe1.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	private String nome;

	@Column(name = "data_nascimento")
	private Date dataNascimento;

	private String cpf;

	private Boolean vinculo;

	@Column(name = "data_vinculo")
	@CreationTimestamp
	private Date dataVinculo;

	private String usuario;

	private String senha;

	private Boolean permissao;

}
