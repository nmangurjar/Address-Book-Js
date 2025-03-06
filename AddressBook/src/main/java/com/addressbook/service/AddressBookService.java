package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookService {

    private List<AddressBook> contactList = new ArrayList<>();
    private Long idCounter = 1L;

    public List<AddressBook> getAllContacts() {
        log.info("Retrieving all contacts");
        return contactList;
    }

    public String addContact(AddressBookDTO addressBookDTO) {
        AddressBook newContact = new AddressBook(idCounter++, addressBookDTO.getName(), addressBookDTO.getEmail(), addressBookDTO.getPhone());
        contactList.add(newContact);
        log.info("Contact Added: {}", newContact.getName());
        return "Contact Added: " + newContact.getName();
    }

    public String updateContact(Long id, AddressBookDTO addressBookDTO) {
        for (AddressBook contact : contactList) {
            if (contact.getId().equals(id)) {
                contactList.remove(contact);
                AddressBook updatedContact = new AddressBook(id, addressBookDTO.getName(), addressBookDTO.getEmail(), addressBookDTO.getPhone());
                contactList.add(updatedContact);
                log.info("Updated Contact: {} with ID: {}", updatedContact.getName(), id);
                return "Updated Contact: " + updatedContact.getName() + " with ID: " + id;
            }
        }
        log.warn("Contact Not Found with ID: {}", id);
        return "Contact Not Found with ID: " + id;
    }

    public String deleteContact(Long id) {
        for (AddressBook contact : contactList) {
            if (contact.getId().equals(id)) {
                contactList.remove(contact);
                log.info("Deleted Contact with ID: {}", id);
                return "Deleted Contact with ID: " + id;
            }
        }
        log.warn("Contact Not Found with ID: {}", id);
        return "Contact Not Found with ID: " + id;
    }
}