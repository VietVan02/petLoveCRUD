package com.stc.petlove.services.Impl;

import com.stc.petlove.dtos.DichVuDto;
import com.stc.petlove.entities.DichVu;
import com.stc.petlove.exceptions.NotFoundException;
import com.stc.petlove.repositories.DichVuRepository;
import com.stc.petlove.services.DichVuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DichVuServiceImpl implements DichVuService {
    private final DichVuRepository dichVuRepository;

    public DichVuServiceImpl(DichVuRepository dichVuRepository) {
        this.dichVuRepository = dichVuRepository;
    }

    @Override
    public DichVu getDichVu(String id) {
        return dichVuRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("Dịch vụ có id %s không tồn tại", id)));
    }
    private DichVu getDichVu(DichVuDto dto, DichVu dichVu) {
        dichVu.setMaDichVu(dto.getMaDichVu().trim().toUpperCase());
        dichVu.setTenDichVu(dto.getTenDichVu().trim());
        dichVu.setNoiDung(dto.getNoiDung().trim());
        dichVu.setGiaDichVus(dto.getGiaDichVus());

        dichVuRepository.save(dichVu);
        return dichVu;
    }
    @Override
    public DichVu createDichVu(DichVuDto dto) {

        DichVu dichVu = new DichVu();

        return getDichVu(dto,dichVu);
    }

    @Override
    public DichVu updateDichVu(String id, DichVuDto dto) {
        DichVu dichVu = getDichVu(id);

        return getDichVu(dto,dichVu);
    }

    @Override
    public DichVu deleteDichVu(String id) {
        DichVu dichVu = getDichVu(id);
        dichVuRepository.delete(dichVu);
        return dichVu;
    }

}
