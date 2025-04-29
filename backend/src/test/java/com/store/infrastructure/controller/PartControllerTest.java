package com.store.infrastructure.controller;

import com.store.application.dto.PartDTO;
import com.store.application.service.PartService;
import com.store.domain.repository.PartRepository;
import com.store.infrastructure.database.repository.InMemoryPartRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PartControllerTest {
    @Test
    public void shouldGetAllParts() {
        PartRepository repository = new InMemoryPartRepository();
        PartService service = new PartService(repository);
        PartController controller = new PartController(service);

        List parts = controller.findAll();

        assertEquals(5, parts.size());
    }

    @Test
    public void shouldSavePart() {
        PartRepository repository = new InMemoryPartRepository();
        PartService service = new PartService(repository);
        PartController controller = new PartController(service);
        PartDTO part = new PartDTO(null, "type", "option", 10.0f);

        PartDTO response = controller.save(part);

        assertEquals("type", response.getType());
        assertNotNull(response.getId());
    }
}
