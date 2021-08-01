package com.udacity.boogle.maps.web;

import com.udacity.boogle.maps.repository.MockAddressRepository;
import com.udacity.boogle.maps.entity.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/maps")
public class MapsController {

    @GetMapping
    public ResponseEntity<Address> get(@RequestParam(required = false) Double lat, @RequestParam(required = false) Double lon) {
        if(lat==null||lon==null){
            Address address=new Address("NOT VALID LAT/LON","NOT VALID LAT/LON","NOT VALID LAT/LON","NOT VALID LAT/LON");
            return new ResponseEntity<Address>(address,HttpStatus.NOT_FOUND);
        }
        Address address=MockAddressRepository.getRandom();
        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }
    /*@GetMapping
    public List<Address> getAllAddresses(){
        return MockAddressRepository.getAllAddress();
    }*/
}
