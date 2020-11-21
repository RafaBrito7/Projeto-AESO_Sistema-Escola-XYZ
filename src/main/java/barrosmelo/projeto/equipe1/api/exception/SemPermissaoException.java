package barrosmelo.projeto.equipe1.api.exception;

public class SemPermissaoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public SemPermissaoException(String msg) {
		super(msg);
	}
}
