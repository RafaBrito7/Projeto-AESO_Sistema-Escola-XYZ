package barrosmelo.projeto.equipe1.api.exception;

public class RestricoesVioladasException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RestricoesVioladasException(String msg) {
		super(msg);
	}

}
