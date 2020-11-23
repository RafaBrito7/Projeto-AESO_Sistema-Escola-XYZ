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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_professor")
	private Long idProfessor;

	@NotEmpty
	@NotBlank
	@NotNull
	private String nome;

	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@NotEmpty
	@NotBlank
	@NotNull
	@Size(max = 11)
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
	private Credencial credencial;

	public Professor() {

	}

	public Long getIdProfessor() {
		return idProfessor;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public Boolean getVinculo() {
		return vinculo;
	}

	public Date getDataVinculo() {
		return dataVinculo;
	}

	public Boolean getPermissao() {
		return permissao;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public Credencial getCredencial() {
		return credencial;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setVinculo(Boolean vinculo) {
		this.vinculo = vinculo;
	}

	public void setDataVinculo(Date dataVinculo) {
		this.dataVinculo = dataVinculo;
	}

	public void setPermissao(Boolean permissao) {
		this.permissao = permissao;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProfessor == null) ? 0 : idProfessor.hashCode());
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
		Professor other = (Professor) obj;
		if (idProfessor == null) {
			if (other.idProfessor != null)
				return false;
		} else if (!idProfessor.equals(other.idProfessor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Professor [idProfessor=" + idProfessor + ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", cpf=" + cpf + ", vinculo=" + vinculo + ", dataVinculo=" + dataVinculo + ", permissao=" + permissao
				+ ", disciplina=" + disciplina + ", credencial=" + credencial + "]";
	}
}
