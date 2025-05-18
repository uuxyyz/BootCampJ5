package com.colvir.lesson11.controller;

import com.colvir.lesson11.dto.SparePartDto;
import com.colvir.lesson11.services.SparePartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/SparePart")
public class SparePartController {
    private final SparePartService sparePartService;

    private void sparePartNotFound() {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "spare part not found");
    }

    private SparePartDto checkSparePartIfExists(SparePartDto sparePartDto) {
        if (Objects.isNull(sparePartDto)) {
            sparePartNotFound();
        }
        return sparePartDto;
    }

    @GetMapping("/{id}")
    public SparePartDto getById(@PathVariable int id) {
        return checkSparePartIfExists(sparePartService.findById(id));
    }

    @GetMapping
    public List<SparePartDto> findAll() {
        return sparePartService.findAll();
    }

    @PutMapping("/{id}")
    public SparePartDto save(@RequestBody SparePartDto sparePartDto, @PathVariable int id) {
        if (!Objects.equals(id, sparePartDto.getId())) {
            throw new IllegalArgumentException("Invalid ID");
        }
        return checkSparePartIfExists(sparePartService.save(sparePartDto));
    }

    @PostMapping
    public SparePartDto save(@RequestBody SparePartDto sparePartDto) {
        if (Objects.nonNull(sparePartDto.getId())) {
            throw new IllegalArgumentException("Shouldn't define ID");
        }
        return checkSparePartIfExists(sparePartService.save(sparePartDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        checkSparePartIfExists(sparePartService.findById(id));
        sparePartService.delete(id);
    }

}
