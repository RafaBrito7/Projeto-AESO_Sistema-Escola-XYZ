package barrosmelo.projeto.equipe1.domain.model;

import javax.persistence.Entity;

@Entity
public class Adm extends Pessoa{

	private String permissao;
	
	public Adm() {
		
	}

	public String isPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}	
}
