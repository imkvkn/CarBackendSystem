package com.udacity.pricing.api;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import com.udacity.pricing.service.PriceException;
import com.udacity.pricing.service.PricingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * Implements a REST-based controller for the pricing service.
 */
@RestController
@RequestMapping("/services/price")
public class PricingController {
    public PricingService pricingService;

    PricingController(PricingService pricingService){
        this.pricingService=pricingService;
    }
    /**
     * Gets the price for a requested vehicle.
     * @param vehicleId ID number of the vehicle for which the price is requested
     * @return price of the vehicle, or error that it was not found.
     */
    @GetMapping
    public Price get(@RequestParam Long vehicleId) {
        try {
            return PricingService.getPrice(vehicleId);
        } catch (PriceException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Price Not Found", ex);
        }

    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) throws PriceException {
        try {
            pricingService.deleteById(id);
            return new ResponseEntity<>("id deleted re",HttpStatus.OK);
        }catch(PriceException ex) {
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Price Not Found", ex);
        }
    }

}
