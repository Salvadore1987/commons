package uz.salvadore.commons.domain.entity;

import java.io.Serializable;
import java.util.Objects;

public abstract class BaseEntity<T> implements Serializable {
  private T id;

  public T getId() {
    return this.id;
  }

  public void setId(final T id) {
    this.id = id;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    } else if (!(o instanceof BaseEntity)) {
      return false;
    } else {
      final BaseEntity<?> that = (BaseEntity)o;
      return this.id.equals(that.id);
    }
  }

  public int hashCode() {
    return Objects.hash(new Object[]{this.id});
  }
}
