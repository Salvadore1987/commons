package uz.salvadore.commons.domain.event.publisher;

import uz.salvadore.commons.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {
  void publish(T domainEvent);
}
