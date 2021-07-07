package pl.piasta.acmanagement.domain.customers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private String streetName;
    private String houseNumber;
    private String zipCode;
    private String city;
    private String phoneNumber;
    private String email;
    private DocumentType documentType;
    private String documentId;
}
