package uz.salvadore.commons.domain.entity;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class AggregateRoot<T> extends BaseEntity<T> {
}
