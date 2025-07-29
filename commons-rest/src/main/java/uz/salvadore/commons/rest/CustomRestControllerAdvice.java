package uz.salvadore.commons.rest;

import com.fasterxml.jackson.core.JsonParseException;
import jakarta.persistence.PersistenceException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import uz.salvadore.commons.model.BaseErrorCode;
import uz.salvadore.commons.model.dto.ErrorDto;
import uz.salvadore.commons.model.dto.FieldError;
import uz.salvadore.commons.model.dto.RestResponse;
import uz.salvadore.commons.model.dto.ValidationError;
import uz.salvadore.commons.model.exceptions.AbstractBusinessLogicException;

import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
public class CustomRestControllerAdvice extends BaseControllerAdvice {

  @ExceptionHandler(AbstractBusinessLogicException.class)
  protected ResponseEntity<RestResponse<ErrorDto>> abstractDomainException(final AbstractBusinessLogicException ex,
                                                                           final WebRequest request) {
    log.error(ex.getMessage());
    return getErrorData(ex.getMessage(), ex.getCode());
  }

  @ExceptionHandler(PersistenceException.class)
  protected ResponseEntity<RestResponse<ErrorDto>> persistenceException(final RuntimeException ex,
                                                                        final WebRequest request) {
    log.error(ex.getMessage());
    return getErrorData(BaseErrorCode.DATABASE_OPERATION_ERROR.getMessage(),
      BaseErrorCode.DATABASE_OPERATION_ERROR.getCode());
  }

  @ExceptionHandler(NoSuchElementException.class)
  protected ResponseEntity<RestResponse<ErrorDto>> noSuchElementException(final RuntimeException ex, final WebRequest request) {
    log.error(ex.getMessage());
    return getErrorData(BaseErrorCode.VALUE_NOT_PRESENT_ERROR.getMessage(),
      BaseErrorCode.VALUE_NOT_PRESENT_ERROR.getCode());
  }

  @ExceptionHandler(DateTimeParseException.class)
  protected ResponseEntity<RestResponse<ErrorDto>> dateTimeParseException(final DateTimeParseException ex,
                                                                          final WebRequest request) {
    log.error(ex.getMessage());
    return getErrorData(BaseErrorCode.INVALID_DATE_TIME_ERROR.getMessage(),
      BaseErrorCode.INVALID_DATE_TIME_ERROR.getCode());
  }

  @ExceptionHandler(JsonParseException.class)
  protected ResponseEntity<RestResponse<ErrorDto>> jsonParseException(final JsonParseException ex,
                                                                      final WebRequest request) {
    log.error(ex.getMessage());
    return getErrorData(BaseErrorCode.JSON_PARSE_ERROR.getMessage(),
      BaseErrorCode.JSON_PARSE_ERROR.getCode());
  }

  @ExceptionHandler(DataAccessException.class)
  protected ResponseEntity<RestResponse<ErrorDto>> dataAccessException(final DataAccessException ex,
                                                                       final WebRequest request) {
    log.error(ex.getMessage());
    return getErrorData(BaseErrorCode.DATABASE_ACCESS_ERROR.getMessage(),
      BaseErrorCode.DATABASE_ACCESS_ERROR.getCode());
  }

  @ExceptionHandler(Exception.class)
  protected ResponseEntity<RestResponse<ErrorDto>> dataAccessException(final Exception ex,
                                                                       final WebRequest request) {
    log.error(ex.getMessage());
    return getErrorData(BaseErrorCode.UNKNOWN_ERROR.getMessage(),
      BaseErrorCode.UNKNOWN_ERROR.getCode());
  }

  @ExceptionHandler(ConstraintViolationException.class)
  protected ResponseEntity<RestResponse<ValidationError>> violationException(final ConstraintViolationException ex,
                                                                             final WebRequest request) {
    log.error(ex.getMessage());
    final List<FieldError> errors = ex.getConstraintViolations().stream()
      .map(error -> {
        final String fieldName = error.getPropertyPath().toString();
        return FieldError.builder().field(fieldName).message(error.getMessage()).build();
      }).toList();
    return getValidationErrorData(errors);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex,
                                                                final HttpHeaders headers,
                                                                final HttpStatusCode status,
                                                                final WebRequest request) {
    log.error(ex.getMessage());
    return ResponseEntity.badRequest()
      .body(RestResponse.<ErrorDto>builder()
        .httpCode(HttpStatus.BAD_REQUEST.value())
        .object(ErrorDto.builder().errorCode(BaseErrorCode.JSON_PARSE_ERROR.getCode()).errorMessage(BaseErrorCode.JSON_PARSE_ERROR.getMessage()).build())
        .build());
  }

}
