package com.addressbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressBookController {

    @GetMapping
    public ResponseEntity<String> getEmployees() {
        return new ResponseEntity<>("This is GET Mapping", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addEmployee() {
        return new ResponseEntity<>("This is POST Mapping", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id) {
        return new ResponseEntity<>("This is PUT Mapping for contact: " + id, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        return new ResponseEntity<>("This is DELETE Mapping for contact: " + id, HttpStatus.OK);
    }
}
