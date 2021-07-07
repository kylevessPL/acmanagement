package pl.piasta.acmanagement.infrastructure.model;

import lombok.Getter;
import lombok.Setter;
import pl.piasta.acmanagement.domain.customers.model.DocumentType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMERS")
@Getter
@Setter
public class CustomersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 50)
    private String lastName;

    @Column(name = "STREET_NAME", nullable = false, length = 100)
    private String streetName;

    @Column(name = "HOUSE_NUMBER", nullable = false)
    private String houseNumber;

    @Column(name = "ZIP_CODE", nullable = false, length = 10)
    private String zipCode;

    @Column(name = "CITY", nullable = false, length = 50)
    private String city;

    @Column(name = "PHONE_NUMBER", nullable = false, length = 15)
    private String phoneNumber;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "DOCUMENT_TYPE", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column(name = "DOCUMENT_ID", nullable = false, length = 10)
    private String documentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomersEntity that = (CustomersEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(streetName, that.streetName) && Objects.equals(houseNumber, that.houseNumber) && Objects.equals(zipCode, that.zipCode) && Objects.equals(city, that.city) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(email, that.email) && Objects.equals(documentType, that.documentType) && Objects.equals(documentId, that.documentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, streetName, houseNumber, zipCode, city, phoneNumber, email, documentType, documentId);
    }
}
