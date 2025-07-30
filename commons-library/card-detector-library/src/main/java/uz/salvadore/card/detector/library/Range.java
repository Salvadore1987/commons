package uz.salvadore.card.detector.library;

import lombok.Builder;

@Builder
public record Range(Integer min, Integer max) {
}
