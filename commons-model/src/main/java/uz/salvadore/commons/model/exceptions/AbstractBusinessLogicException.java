package uz.salvadore.commons.model.exceptions;

import java.util.List;

public abstract class AbstractBusinessLogicException extends RuntimeException implements BusinessLogicException {
  private final String code;
  private final String message;
  private final List<String> details;

  protected AbstractBusinessLogicException(final String code,
                                           final String message,
                                           final List<String> details) {
    this.code = code;
    this.message = message;
    this.details = details;
  }

}
