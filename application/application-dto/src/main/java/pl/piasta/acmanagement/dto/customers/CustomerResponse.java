package pl.piasta.acmanagement.dto.customers;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class CustomerResponse {

    private final String firstName;
    private final String lastName;
    private final String streetName;
    private final String houseNumber;
    private final String zipCode;
    private final String city;
    private final String phoneNumber;
    private final String email;
    private final String documentType;
    private final String documentId;
}
