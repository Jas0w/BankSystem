package ru.pinchuk.entity;

import org.springframework.validation.*;

public class ClientFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Client.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Client client = (Client) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "First name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "Last name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "Phone number is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "Address is required");
    }
}
