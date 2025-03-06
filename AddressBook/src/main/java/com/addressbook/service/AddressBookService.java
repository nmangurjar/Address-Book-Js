package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService {

    public AddressBook getContact() {
        return new AddressBook(1L, "John Doe", "john.doe@gmail.com", "1234567890");
    }

    public String addContact(AddressBookDTO addressBookDTO) {
        return "Contact Added: " + addressBookDTO.getName();
    }

    public String updateContact(Long id, AddressBookDTO addressBookDTO) {
        return "Updated Contact: " + addressBookDTO.getName() + " with ID: " + id;
    }

    public String deleteContact(Long id) {
        return "This is DELETE Mapping for contact: " + id;
    }
}

