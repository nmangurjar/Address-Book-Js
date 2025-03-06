package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.exception.AddressBookException;
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

    public AddressBook getContactById(Long id) {
        return contactList.stream()
                .filter(contact -> contact.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Contact Not Found with ID: " + id));
    }

    public String addContact(AddressBookDTO addressBookDTO) {
        AddressBook newContact = new AddressBook(idCounter++, addressBookDTO.getName(), addressBookDTO.getEmail(), addressBookDTO.getPhone());
        contactList.add(newContact);
        log.info("Contact Added: {}", newContact.getName());
        return "Contact Added: " + newContact.getName();
    }

    public String updateContact(Long id, AddressBookDTO addressBookDTO) {
        AddressBook contact = getContactById(id);
        contactList.remove(contact);
        AddressBook updatedContact = new AddressBook(id, addressBookDTO.getName(), addressBookDTO.getEmail(), addressBookDTO.getPhone());
        contactList.add(updatedContact);
        log.info("Updated Contact: {} with ID: {}", updatedContact.getName(), id);
        return "Updated Contact: " + updatedContact.getName() + " with ID: " + id;
    }

    public String deleteContact(Long id) {
        AddressBook contact = getContactById(id);
        contactList.remove(contact);
        log.info("Deleted Contact with ID: {}", id);
        return "Deleted Contact with ID: " + id;
    }
}
