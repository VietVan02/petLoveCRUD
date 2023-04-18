package com.stc.petlove.controllers;

import com.stc.petlove.dtos.LoaiThuCungDto;
import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.services.LoaiThuCungService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/loai-thu-cung")
public class LoaiThuCungController {
    private final LoaiThuCungService loaiThuCungService;

    public LoaiThuCungController(LoaiThuCungService loaiThuCungService) {
        this.loaiThuCungService = loaiThuCungService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoaiThuCung> getLoaiThuCung(@PathVariable String id) {
        return new ResponseEntity<>(loaiThuCungService.getLoaiThuCung(id), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<LoaiThuCung> create(@Valid @RequestBody LoaiThuCungDto dto) {
        return new ResponseEntity<>(loaiThuCungService.createLoaiThuCung(dto), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<LoaiThuCung> update(@PathVariable String id, @Valid @RequestBody LoaiThuCungDto dto) {
        return new ResponseEntity<>(loaiThuCungService.updateLoaiThuCung(id, dto), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<LoaiThuCung> delete(@PathVariable String id) {
        return new ResponseEntity<>(loaiThuCungService.deleteLoaiThuCung(id), HttpStatus.OK);
    }
}
