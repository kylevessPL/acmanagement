package pl.piasta.acmanagement.infrastructure.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "AC_UNITS")
@Getter
@Setter
public class AcUnitsEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "MANUFACTURER", nullable = false, length = 100)
    private String manufacturer;

    @Column(name = "PRODUCT_NAME", nullable = false, length = 100)
    private String productName;

    @Column(name = "VOLTAGE", nullable = false)
    private Integer voltage;

    @Column(name = "CURRENT", nullable = false)
    private Integer current;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcUnitsEntity that = (AcUnitsEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(manufacturer, that.manufacturer) && Objects.equals(productName, that.productName) && Objects.equals(voltage, that.voltage) && Objects.equals(current, that.current);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manufacturer, productName, voltage, current);
    }
}
