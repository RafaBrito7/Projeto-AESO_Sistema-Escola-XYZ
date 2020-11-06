package barrosmelo.projeto.equipe1.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bimestre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bimestre")
	private Long id;

	@Column(name = "tipo_bimestre")
	private String tipoBimestre;

	public Bimestre() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoBimestre() {
		return tipoBimestre;
	}

	public void setTipoBimestre(String tipoBimestre) {
		this.tipoBimestre = tipoBimestre;
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
		Bimestre other = (Bimestre) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bimestre [id=" + id + ", tipoBimestre=" + tipoBimestre + "]";
	}

}
