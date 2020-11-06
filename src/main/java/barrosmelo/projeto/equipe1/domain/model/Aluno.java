package barrosmelo.projeto.equipe1.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno extends Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	private Long id;

	@Column(name = "numero_matricula")
	private String numeroMatricula;

	private BigDecimal nota;

	public Aluno() {

	}

	public Aluno(String nome, String cpf, String dataNascimento) {
		super(nome, cpf, dataNascimento);
	}

	public Aluno(String nome, String cpf, String dataNascimento, String numeroMatricula, BigDecimal nota) {
		super(nome, cpf, dataNascimento);
		this.numeroMatricula = numeroMatricula;
		this.nota = nota;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public BigDecimal getNota() {
		return nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
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
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", numeroMatricula=" + numeroMatricula + ", nota=" + nota + "]";
	}	
}
