package barrosmelo.projeto.equipe1.api.exception;

public class EntidadeEmUsoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EntidadeEmUsoException(Long id) {
		super(String.format("A credencial de id %d está em uso.", id));
	}
}
