package uz.salvadore.commons.domain.exception;

import uz.salvadore.commons.model.exceptions.BusinessLogicException;

import java.util.List;

public abstract class AbstractDomainException extends RuntimeException implements BusinessLogicException {
  private final int code;
  private final String message;
  private List<String> details;

  protected AbstractDomainException(final int code, final String message) {
    super(message);
    this.code = code;
    this.message = message;
  }

  protected AbstractDomainException(final int code, final String message, final List<String> details) {
    super(message);
    this.code = code;
    this.message = message;
    this.details = details;
  }
}
