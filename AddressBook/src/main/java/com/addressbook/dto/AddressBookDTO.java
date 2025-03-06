package com.addressbook.dto;

import lombok.Getter;
import lombok.Setter;




import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;


@Getter
@Setter
public class AddressBookDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\s]*$", message = "Name must start with capital letter and contain only alphabets and spaces")
    private String name;

    private String email;
    private String phone;
}