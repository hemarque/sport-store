package com.store.infrastructure.controller;

import com.store.application.service.PartService;
import com.store.domain.repository.PartRepository;
import com.store.infrastructure.database.repository.InMemoryPartRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartControllerTest {
    @Test
    public void shouldGetAllParts(){
        PartRepository repository = new InMemoryPartRepository();
        PartService service = new PartService(repository);
        PartController controller = new PartController(service);

        List parts = controller.findAll();

        assertEquals(5, parts.size());
    }
}
