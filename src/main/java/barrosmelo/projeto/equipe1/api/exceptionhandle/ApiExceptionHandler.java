package barrosmelo.projeto.equipe1.api.exceptionhandle;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import barrosmelo.projeto.equipe1.api.exception.EntidadeEmUsoException;
import barrosmelo.projeto.equipe1.api.exception.EntidadeNaoEncontradaException;
import barrosmelo.projeto.equipe1.api.exception.RestricoesVioladasException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	private HttpStatus status;
	private TipoProblema tipoProblema;
	Problema problema;
	private String detalhe;

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		tipoProblema = tipoProblema.RESTRICOES_VIOLADAS;
		detalhe = "Verificar o preenchimento dos campos obrigatórios.";
		problema = createProblemBuilder(status, tipoProblema, detalhe);

		return handleExceptionInternal(ex, problema, headers, status, request);
	}

	@ExceptionHandler(RestricoesVioladasException.class)
	public ResponseEntity<?> handleRestricoesVioladasException(RestricoesVioladasException e, WebRequest request) {
		status = HttpStatus.BAD_REQUEST;
		tipoProblema = TipoProblema.RESTRICOES_VIOLADAS;
		detalhe = e.getMessage();

		problema = createProblemBuilder(status, tipoProblema, detalhe);
		return handleExceptionInternal(e, problema, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<?> handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException e,
			WebRequest request) {
		status = HttpStatus.NOT_FOUND;
		tipoProblema = TipoProblema.ENTIDADE_NAO_ENCONTRADA;
		detalhe = e.getMessage();

		problema = createProblemBuilder(status, tipoProblema, detalhe);
		return handleExceptionInternal(e, problema, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(EntidadeEmUsoException.class)
	public ResponseEntity<?> handleEntidadeEmUsoException(EntidadeEmUsoException e,
			WebRequest request) {
		status = HttpStatus.CONFLICT;
		tipoProblema = TipoProblema.ENTIDADE_EM_USO;
		detalhe = e.getMessage();

		problema = createProblemBuilder(status, tipoProblema, detalhe);
		return handleExceptionInternal(e, problema, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleEntidadeEmUsoException(ConstraintViolationException e,
			WebRequest request) {
		status = HttpStatus.BAD_REQUEST;
		tipoProblema = TipoProblema.ERRO_DE_VALIDACAO;
		detalhe = e.getMessage();

		problema = createProblemBuilder(status, tipoProblema, detalhe);
		return handleExceptionInternal(e, problema, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	

	private Problema createProblemBuilder(HttpStatus status, TipoProblema tipoProblema, String detail) {
		return new Problema(status.value(), tipoProblema.getUri(), tipoProblema.getTitulo(), detalhe);
	}
}
