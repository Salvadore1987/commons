package uz.salvadore.commons.model.exceptions;

import java.util.List;

public interface BusinessLogicException {

  String getMessage();
  String getCode();
  List<String> getDetails();

}
