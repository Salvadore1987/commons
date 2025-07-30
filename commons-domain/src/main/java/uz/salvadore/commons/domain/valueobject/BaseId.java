package uz.salvadore.commons.domain.valueobject;

import java.io.Serializable;
import java.util.Objects;

public abstract class BaseId<T> implements Serializable {
  private final T value;

  protected BaseId(final T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (!(o instanceof BaseId<?> baseId)) return false;
    return Objects.equals(value, baseId.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
}
