package uz.salvadore.commons.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum BaseErrorCode {
  UNKNOWN_ERROR("B_10001", "Unknown error"),
  DATABASE_OPERATION_ERROR("B_10001", "Error while execute database operation"),
  VALUE_NOT_PRESENT_ERROR("B_10002", "Value is not present"),
  INVALID_DATE_TIME_ERROR("B_10003", "Error while parsing date"),
  JSON_PARSE_ERROR("B_10004", " Error while parsing json"),
  DATABASE_ACCESS_ERROR("B_10005", "Error while execute database operation! Please contact with administrator");

  String code;
  String message;
}
