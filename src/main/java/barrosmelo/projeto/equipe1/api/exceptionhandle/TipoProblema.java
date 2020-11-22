package barrosmelo.projeto.equipe1.api.exceptionhandle;

public enum TipoProblema {

	RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "recurso não encontrado"),
	ERRO_DE_REQUISICAO("/erro-de-requisicao", "Erro de requisição"),
	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel","mensagem incompreensível"),
	PROPRIEDADE_IGNORADA("/propriedade-ignorada","Propriedade ignorada"),
	PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
	ERRO_NO_ARGUMENTO_DA_URI("/erro-no-argumento-da-uri","Erro no argumento da URI"),
	ERRO_DE_SISTEMA("/erro-de-sistema","Erro de sistema"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
	ENTIDADE_NAO_ENCONTRADA("entidade-nao-encontrada", "Entidade não encontrada"),
	RESTRICOES_VIOLADAS("/restricoes-violadas", "Restrições violadas");
	
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
