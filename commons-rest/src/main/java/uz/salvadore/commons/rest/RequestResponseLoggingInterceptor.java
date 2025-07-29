package uz.salvadore.commons.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

import static uz.salvadore.commons.model.Constants.DATE_PATTERN;

@Slf4j
public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

  public ClientHttpResponse intercept(final HttpRequest request, final byte[] body, final ClientHttpRequestExecution execution) throws IOException {
    final ZonedDateTime start = LocalDateTime.now().atZone(ZoneId.systemDefault());
    final ClientHttpResponse response = execution.execute(request, body);
    final ZonedDateTime end = LocalDateTime.now().atZone(ZoneId.systemDefault());
    this.logResponse(response, request, body, start, end);
    return response;
  }

  private void logResponse(final ClientHttpResponse response, final HttpRequest request, final byte[] body, final ZonedDateTime start, final ZonedDateTime end) throws IOException {
    final long difference = end.toInstant().toEpochMilli() - start.toInstant().toEpochMilli();
    final String requestStr = new String(body, StandardCharsets.UTF_8);
    final String responseStr = StreamUtils.copyToString(response.getBody(), Charset.defaultCharset());
    final LinkedHashMap<String, String> map = new LinkedHashMap();
    map.put("Request URI", String.format("%s", request.getURI()));
    map.put("Request Method", String.format("%s", request.getMethod()));
    map.put("Request Headers", String.format("%s", request.getHeaders()));
    map.put("Request content length", String.format("%s", body.length));
    map.put("Request body", requestStr);
    map.put("Response content length", String.format("%s", response.getBody().available()));
    map.put("Response body", responseStr);
    map.put("Response headers", response.getHeaders().toString());
    map.put("Response status code", String.format("%s", response.getStatusCode().value()));
    map.put("Response status message", String.format("%s", response.getStatusText()));
    map.put("Request Started at", String.format("%s", FORMATTER.format(start)));
    map.put("Response Finished at", String.format("%s", FORMATTER.format(end)));
    map.put("Total request time", String.format("%s", difference));
    log.info((new ObjectMapper()).writeValueAsString(map));
  }

}
