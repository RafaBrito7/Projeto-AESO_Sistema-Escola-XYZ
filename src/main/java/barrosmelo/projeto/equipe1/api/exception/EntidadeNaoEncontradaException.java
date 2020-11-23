package barrosmelo.projeto.equipe1.api.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaException(Long id) {
		super(String.format("Não existe credencial cadastrada com o id %d.", id));
	}
}
