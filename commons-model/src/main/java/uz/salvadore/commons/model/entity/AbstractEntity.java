package uz.salvadore.commons.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
public class AbstractEntity implements Serializable {
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
}
