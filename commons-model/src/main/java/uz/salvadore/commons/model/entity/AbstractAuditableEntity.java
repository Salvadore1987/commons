package uz.salvadore.commons.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
public abstract class AbstractAuditableEntity {
  @CreationTimestamp
  @Column(
    name = "created_at",
    updatable = false
  )
  private LocalDateTime createdAt;
  @UpdateTimestamp
  @Column(
    name = "updated_at",
    insertable = false
  )
  private LocalDateTime updatedAt;
  @Column(
    name = "is_deleted",
    columnDefinition = "boolean default false"
  )
  private boolean deleted;
  @Version
  private Integer version;
}
