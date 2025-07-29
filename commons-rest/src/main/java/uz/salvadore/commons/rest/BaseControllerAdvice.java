package uz.salvadore.commons.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.salvadore.commons.model.dto.ErrorDto;
import uz.salvadore.commons.model.dto.ErrorsDto;
import uz.salvadore.commons.model.dto.FieldError;
import uz.salvadore.commons.model.dto.RestResponse;
import uz.salvadore.commons.model.dto.ValidationError;

import java.util.List;

public class BaseControllerAdvice extends ResponseEntityExceptionHandler {

  protected ResponseEntity<RestResponse<ErrorDto>> getErrorData(final String message, final String code) {
    return ResponseEntity.badRequest()
      .body(RestResponse.<ErrorDto>builder()
        .httpCode(HttpStatus.BAD_REQUEST.value())
        .object(ErrorDto.builder().errorCode(code).errorMessage(message).build())
        .build());
  }

  protected ResponseEntity<RestResponse<ErrorsDto>> getErrorsData(final List<ErrorDto> errors) {
    return ResponseEntity.badRequest()
      .body(RestResponse.<ErrorsDto>builder()
        .httpCode(HttpStatus.BAD_REQUEST.value())
        .object(ErrorsDto.builder().errors(errors).build())
        .build());
  }

  protected ResponseEntity<RestResponse<ValidationError>> getValidationErrorData(final List<FieldError> errors) {
    return ResponseEntity.unprocessableEntity()
      .body(RestResponse.<ValidationError>builder()
        .httpCode(HttpStatus.BAD_REQUEST.value())
        .object(ValidationError.builder().fieldErrors(errors).build())
        .build());
  }

}
