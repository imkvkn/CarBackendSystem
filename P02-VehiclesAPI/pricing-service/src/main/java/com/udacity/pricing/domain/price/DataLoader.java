
package com.udacity.pricing.domain.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Component
public class DataLoader implements ApplicationRunner {

    private PriceRepository priceRepository;

    /**
     * Holds {ID: Price} pairings (current implementation allows for 20 vehicles)
     */
    private static final List<Price> PRICES = LongStream
            .range(1, 20)
            .mapToObj(i -> new Price("USD", randomPrice()))
            .collect(Collectors.toList());

    @Autowired
    public DataLoader(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public void run(ApplicationArguments args) {
        priceRepository.saveAll(PRICES);
    }

    /**
     * Gets a random price to fill in for a given vehicle ID.
     * @return random price for a vehicle
     */
    private static BigDecimal randomPrice() {
        return new BigDecimal(ThreadLocalRandom.current().nextDouble(1, 5))
                .multiply(new BigDecimal(5000d)).setScale(2, RoundingMode.HALF_UP);
    }
}