package uz.salvadore.commons.domain.valueobject;

import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Objects;

@SuperBuilder
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
    if (o == null || getClass() != o.getClass()) return false;
    final BaseId<?> baseId = (BaseId<?>) o;
    return Objects.equals(value, baseId.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
}
