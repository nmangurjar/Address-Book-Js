package com.addressbook.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressBook {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public AddressBook(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}