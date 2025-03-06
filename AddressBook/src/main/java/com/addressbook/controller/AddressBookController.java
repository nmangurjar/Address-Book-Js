
package com.addressbook.controller;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressBookController {

    @GetMapping
    public ResponseEntity<AddressBook> getEmployees() {
        AddressBook address = new AddressBook(1L, "John Doe", "john.doe@gmail.com", "1234567890");
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody AddressBookDTO addressBookDTO) {
        return new ResponseEntity<>("Contact Added: " + addressBookDTO.getName(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        return new ResponseEntity<>("Updated Contact: " + addressBookDTO.getName() + " with ID: " + id, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        return new ResponseEntity<>("This is DELETE Mapping for contact: " + id, HttpStatus.OK);
    }
}
