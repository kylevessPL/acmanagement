package pl.piasta.acmanagement.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMERS_AC_SYSTEMS")
@Getter
@Setter
public class CustomersAcSystemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long customerId;

    @Column(name = "AC_SYSTEM_ID", nullable = false)
    private Long acSystemId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomersAcSystemsEntity that = (CustomersAcSystemsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(customerId, that.customerId) && Objects.equals(acSystemId, that.acSystemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, acSystemId);
    }
}
