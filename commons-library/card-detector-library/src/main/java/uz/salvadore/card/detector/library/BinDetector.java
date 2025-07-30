package uz.salvadore.card.detector.library;

import java.util.Arrays;
import java.util.regex.Pattern;

public class BinDetector implements BinDetect {

  private static final Pattern DIGITS_ONLY = Pattern.compile("\\d+");

  @Override
  public ProcessingType detect(final String pan) {
    if (pan == null) {
      return ProcessingType.UNKNOWN;
    }
    
    final String trimmedPan = pan.trim();
    if (trimmedPan.length() < 6 || !DIGITS_ONLY.matcher(trimmedPan).matches()) {
      return ProcessingType.UNKNOWN;
    }
    
    final int bin6 = Integer.parseInt(trimmedPan.substring(0, 6));
    
    return Arrays.stream(ProcessingType.values())
      .filter(type -> type.ranges().stream()
        .anyMatch(range -> range.min() <= bin6 && range.max() >= bin6))
      .findFirst()
      .orElse(ProcessingType.UNKNOWN);
  }
}