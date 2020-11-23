package barrosmelo.projeto.equipe1.api.exceptionhandle;

public enum TipoProblema {

	ERRO_DE_REQUISICAO("/erro-de-requisicao", "Erro de requisição"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
	ENTIDADE_NAO_ENCONTRADA("entidade-nao-encontrada", "Entidade não encontrada"),
	RESTRICOES_VIOLADAS("/restricoes-violadas", "Restrições violadas"),
	ERRO_DE_VALIDACAO("/erro-de-validacao", "Erro de validação");
	
	private String titulo;
	private String uri;
	
	TipoProblema(String titulo, String path) {
		this.uri = "htts://localhost:9090/" + path;
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getUri() {
		return uri;
	}	
}
