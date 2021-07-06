package pl.piasta.acmanagement.api.customers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.piasta.acmanagement.api.customers.model.AddCustomerRequest;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@Validated
public class CustomersServiceController {

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void addCustomer(@RequestBody @Valid AddCustomerRequest request) {
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(@PathVariable @Min(1) Long id, @RequestBody @Valid AddCustomerRequest request) {
    }
}
