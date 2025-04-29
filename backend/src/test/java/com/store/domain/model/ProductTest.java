package com.store.domain.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {
    @Test
    public void shouldSetPriceWhenCreated(){
        Product product = new Product(
                null,
                "Bicycle",
                "Island Bike",
                null,
                new ArrayList<>(Arrays.asList(
                        new Part(1L, "Frame Type", "Full-suspension", 130f),
                        new Part(2L, "Frame Finish", "Shiny", 25f),
                        new Part(3L, "Wheels", "Mountain wheels", 100f),
                        new Part(4L, "Rim Color", "Black", 20f),
                        new Part(5L, "Chain", "Single-speed chain", 43f)
                )));
        assertEquals(318f, product.getBasePrice());
    }

    @Test
    public void shouldUpdatePriceWhenCreated(){
        Product product = new Product(
                null,
                "Bicycle",
                "Island Bike",
                10000f,
                new ArrayList<>(Arrays.asList(
                        new Part(1L, "Frame Type", "Full-suspension", 130f),
                        new Part(2L, "Frame Finish", "Shiny", 25f),
                        new Part(3L, "Wheels", "Mountain wheels", 100f),
                        new Part(4L, "Rim Color", "Black", 20f),
                        new Part(5L, "Chain", "Single-speed chain", 43f)
                )));
        assertEquals(318f, product.getBasePrice());
    }
    @Test
    public void shouldUpdatePriceWhenPartsUpdated(){
        Product product = new Product(
                null,
                "Bicycle",
                "Island Bike",
                318f,
                new ArrayList<>(Arrays.asList(
                        new Part(1L, "Frame Type", "Full-suspension", 130f),
                        new Part(2L, "Frame Finish", "Shiny", 25f),
                        new Part(3L, "Wheels", "Mountain wheels", 100f),
                        new Part(4L, "Rim Color", "Black", 20f),
                        new Part(5L, "Chain", "Single-speed chain", 43f)
                )));

        product.setParts(new ArrayList<>(Arrays.asList(
                new Part(1L, "Frame Type", "Full-suspension", 1f),
                new Part(2L, "Frame Finish", "Shiny", 2.5f),
                new Part(3L, "Wheels", "Mountain wheels", 3f),
                new Part(4L, "Rim Color", "Black", 4f),
                new Part(5L, "Chain", "Single-speed chain", 5f)
        )));

        assertEquals(15.5f, product.getBasePrice());
    }
}
