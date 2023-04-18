package com.stc.petlove.controllers;

import com.stc.petlove.dtos.TaiKhoanDto;
import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.services.TaiKhoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/tai-khoan")
public class TaiKhoanController {
    private final TaiKhoanService taiKhoanService;

    public TaiKhoanController(TaiKhoanService taiKhoanService) {
        this.taiKhoanService = taiKhoanService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaiKhoan> getTaiKhoan(@PathVariable String id) {
        return new ResponseEntity<>(taiKhoanService.getTaiKhoan(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TaiKhoan> create(@Valid @RequestBody TaiKhoanDto dto) {
        return new ResponseEntity<>(taiKhoanService.createTaiKhoan(dto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<TaiKhoan> update(@PathVariable String id, @Valid @RequestBody TaiKhoanDto dto) {
        return new ResponseEntity<>(taiKhoanService.updateTaiKhoan(id, dto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<TaiKhoan> delete(@PathVariable String id) {
        return new ResponseEntity<>(taiKhoanService.deleteTaiKhoan(id), HttpStatus.OK);
    }
}
