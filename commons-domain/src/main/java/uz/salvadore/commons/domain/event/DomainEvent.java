package uz.salvadore.commons.domain.event;

public interface DomainEvent<T> {
  void fire();
}
