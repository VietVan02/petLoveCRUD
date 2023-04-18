package com.stc.petlove.services.Impl;

import com.stc.petlove.dtos.LoaiThuCungDto;
import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.exceptions.NotFoundException;
import com.stc.petlove.repositories.LoaiThuCungRepository;
import com.stc.petlove.services.LoaiThuCungService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoaiThuCungServiceImpl implements LoaiThuCungService {
    private final LoaiThuCungRepository loaiThuCungRepository;

    public LoaiThuCungServiceImpl(LoaiThuCungRepository loaiThuCungRepository) {
        this.loaiThuCungRepository = loaiThuCungRepository;
    }

    @Override
    public LoaiThuCung getLoaiThuCung(String id) {
        return loaiThuCungRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("Loại thú cưng có id %s không tồn tại", id)));
    }

    private LoaiThuCung getLoaiThuCung(LoaiThuCungDto dto, LoaiThuCung loaiThuCung) {
        loaiThuCung.setMaLoaiThuCung(dto.getMaLoaiThuCung().trim().toUpperCase());
        loaiThuCung.setTenLoaiThuCung(dto.getTenLoaiThuCung().trim());

        loaiThuCungRepository.save(loaiThuCung);
        return loaiThuCung;
    }

    @Override
    public LoaiThuCung createLoaiThuCung(LoaiThuCungDto dto) {
        LoaiThuCung loaiThuCung = new LoaiThuCung();

        return getLoaiThuCung(dto,loaiThuCung);
    }

    @Override
    public LoaiThuCung updateLoaiThuCung(String id, LoaiThuCungDto dto) {
        LoaiThuCung loaiThuCung = getLoaiThuCung(id);


        return getLoaiThuCung(dto,loaiThuCung);
    }

    @Override
    public LoaiThuCung deleteLoaiThuCung(String id) {
        LoaiThuCung loaiThuCung = getLoaiThuCung(id);
        loaiThuCungRepository.delete(loaiThuCung);
        return loaiThuCung;
    }
}
