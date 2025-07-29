package uz.salvadore.commons.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

  public static final String HEADER_MULTIPART_FORM = "multipart/form-data";
  public static final String HEADER_XLS_TYPE = "application/vnd.ms-excel";
  public static final String HEADER_OCTET_STREAM = "application/octet-stream";
  public static final String SOURCE_SYSTEM_HEADER = "Source-System";
  public static final String REQUEST_ID_HEADER = "Request-Id";
  public static final Integer SUCCESS_CODE = 0;
  public static final String SUCCESS_MESSAGE = "OK";
  public static final String TIMEZONE = "Asia/Karachi";
  public static final String DATE_PATTERN = "dd.MM.yyyy HH:mm:ss";

}
