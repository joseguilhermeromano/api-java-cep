package br.com.zeguitech.apis.addresses.controller;

import br.com.zeguitech.apis.addresses.model.Address;
import br.com.zeguitech.apis.addresses.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    // Create Address
    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    // Read All Addresses
    @GetMapping
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    // Read Address by ID
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update Address
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address addressDetails) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            Address existingAddress = address.get();
            existingAddress.setStreet(addressDetails.getStreet());
            existingAddress.setNumber(addressDetails.getNumber());
            existingAddress.setComplement(addressDetails.getComplement());
            existingAddress.setNeighborhood(addressDetails.getNeighborhood());
            existingAddress.setCity(addressDetails.getCity());
            existingAddress.setState(addressDetails.getState());
            existingAddress.setZipcode(addressDetails.getZipcode());
            return ResponseEntity.ok(addressRepository.save(existingAddress));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete Address
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
