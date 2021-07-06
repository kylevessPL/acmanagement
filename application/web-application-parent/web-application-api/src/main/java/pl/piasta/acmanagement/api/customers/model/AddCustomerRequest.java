package pl.piasta.acmanagement.api.customers.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class AddCustomerRequest implements Serializable {

    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;

    @NotBlank
    @Size(min = 2, max = 100)
    private String streetName;

    @NotBlank
    @Pattern(regexp = "^[0-9a-zA-Z ./]*$")
    @Size(max = 10)
    private String houseNumber;

    @NotBlank
    @Pattern(regexp = "^[0-9 \\-]*$")
    @Size(min = 2, max = 10)
    private String zipCode;

    @NotBlank
    @Size(min = 2, max = 50)
    private String city;

    @NotBlank
    @Pattern(regexp = "^[0-9]+$")
    @Size(min = 7, max = 15)
    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private DocumentType documentType;

    @NotBlank
    @Pattern(regexp = "^[0-9A-Z ]*$")
    @Size(min = 2, max = 10)
    private String documentId;
}
