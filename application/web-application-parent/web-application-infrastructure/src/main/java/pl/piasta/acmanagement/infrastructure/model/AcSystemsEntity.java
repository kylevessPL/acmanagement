package pl.piasta.acmanagement.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "AC_SYSTEMS")
@Getter
@Setter
public class AcSystemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "UNIT_ID", nullable = false)
    private Long unitId;

    @Column(name = "NEXT_MAINTAINANCE", nullable = false)
    private Instant nextMaintainance;

    @Column(name = "NOTIFICATIONS", nullable = false)
    private boolean notifications;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcSystemsEntity that = (AcSystemsEntity) o;
        return notifications == that.notifications && Objects.equals(id, that.id) && Objects.equals(unitId, that.unitId) && Objects.equals(nextMaintainance, that.nextMaintainance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, unitId, nextMaintainance, notifications);
    }
}
