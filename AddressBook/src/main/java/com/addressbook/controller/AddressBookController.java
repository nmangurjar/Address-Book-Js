package com.addressbook.controller;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;
import com.addressbook.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@Slf4j
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @GetMapping
    public ResponseEntity<List<AddressBook>> getContacts() {
        log.info("Fetching all contacts");
        List<AddressBook> addressList = addressBookService.getAllContacts();
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addContact(@RequestBody AddressBookDTO addressBookDTO) {
        log.info("Adding new contact: {}", addressBookDTO.getName());
        String response = addressBookService.addContact(addressBookDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        log.info("Updating contact with ID: {}", id);
        String response = addressBookService.updateContact(id, addressBookDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        log.info("Deleting contact with ID: {}", id);
        String response = addressBookService.deleteContact(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}