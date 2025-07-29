package uz.salvadore.commons.model.exceptions;

public class AbstractValidationException extends RuntimeException {
  private final String field;
  private final String message;

  protected AbstractValidationException(final String field, final String message) {
    super(message);
    this.field = field;
    this.message = message;
  }
}
