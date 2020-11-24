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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	private Long idAluno;

	@NotBlank
	@NotEmpty
	@NotNull
	private String nome;

	@JsonIgnore
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@NotBlank
	@NotEmpty
	@NotNull
	@Size(max = 11)
	private String cpf;

	@JsonIgnore
	private Boolean vinculo;
	
	@Column(name = "is_logado")
	private Boolean isLogado;

	@JsonIgnore
	@Column(name = "data_vinculo")
	@CreationTimestamp
	private Date dataVinculo;

	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name = "numero_matricula")
	private String numeroMatricula;

	@ManyToOne
	@JoinColumn(name = "idTurma")
	private Turma turma;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "aluno_nota", joinColumns = @JoinColumn(name = "id_pessoa"), inverseJoinColumns = @JoinColumn(name = "id_nota"))
	private List<Nota> notas;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "id_credencial")
	private Credencial credencial;

	public Aluno() {
		this.isLogado = false;
	}

	public Long getIdAluno() {
		return idAluno;
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

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public Turma getTurma() {
		return turma;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public Credencial getCredencial() {
		return credencial;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
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

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}	

	public Boolean getIsLogado() {
		return isLogado;
	}

	public void setIsLogado(Boolean isLogado) {
		this.isLogado = isLogado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAluno == null) ? 0 : idAluno.hashCode());
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
		Aluno other = (Aluno) obj;
		if (idAluno == null) {
			if (other.idAluno != null)
				return false;
		} else if (!idAluno.equals(other.idAluno))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [idAluno=" + idAluno + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf
				+ ", vinculo=" + vinculo + ", dataVinculo=" + dataVinculo + ", numeroMatricula=" + numeroMatricula
				+ ", turma=" + turma + ", notas=" + notas + ", credencial=" + credencial + "]";
	}
}
