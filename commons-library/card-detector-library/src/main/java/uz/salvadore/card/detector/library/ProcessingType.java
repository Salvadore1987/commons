package uz.salvadore.card.detector.library;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ProcessingType {
  HUMO(List.of(Range.builder().min(986000).max(986099).build())),
  UZCARD(List.of(
    Range.builder().min(860000).max(860099).build(),
    Range.builder().min(561400).max(561499).build())),
  VISA(List.of(Range.builder().min(400000).max(499999).build())),
  MASTERCARD(List.of(Range.builder().min(510000).max(559999).build(), Range.builder().min(222100).max(272099).build())),
  UNIONPAY(List.of(Range.builder().min(620000).max(629999).build())),
  CHINAPAY(List.of(Range.builder().min(630000).max(639999).build())),
  DISCOVER(List.of(
    Range.builder().min(601100).max(601199).build(),
    Range.builder().min(644000).max(649999).build(),
    Range.builder().min(65000).max(65999).build())),
  DINERS_CLUB(List.of(
    Range.builder().min(300000).max(305999).build(),
    Range.builder().min(380000).max(389999).build())),
  AMERICAN_EXPRESS(List.of(
    Range.builder().min(340000).max(349999).build(),
    Range.builder().min(370000).max(379999).build())),
  MIR(List.of(Range.builder().min(220000).max(220999).build())),
  UNKNOWN(List.of());

  List<Range> ranges;

  public List<Range> ranges() {
    return ranges;
  }
}