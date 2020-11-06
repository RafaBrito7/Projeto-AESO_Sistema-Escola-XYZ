package barrosmelo.projeto.equipe1.domain.model;

public class Nota {
	
	private Long id_nota;
	private Double nota;
	
	public Nota() {
		// TODO Auto-generated constructor stub
	}

	public Long getId_nota() {
		return id_nota;
	}

	public void setId_nota(Long id_nota) {
		this.id_nota = id_nota;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_nota == null) ? 0 : id_nota.hashCode());
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
		Nota other = (Nota) obj;
		if (id_nota == null) {
			if (other.id_nota != null)
				return false;
		} else if (!id_nota.equals(other.id_nota))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nota [id_nota=" + id_nota + ", nota=" + nota + "]";
	}
	
}
