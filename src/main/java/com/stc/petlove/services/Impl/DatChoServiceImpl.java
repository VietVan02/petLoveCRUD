package com.stc.petlove.services.Impl;

import com.stc.petlove.dtos.DatChoDto;
import com.stc.petlove.entities.DatCho;
import com.stc.petlove.exceptions.NotFoundException;
import com.stc.petlove.repositories.DatChoRepository;
import com.stc.petlove.services.DatChoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DatChoServiceImpl implements DatChoService {

    private final DatChoRepository datChoRepository;

    public DatChoServiceImpl(DatChoRepository datChoRepository) {
        this.datChoRepository = datChoRepository;
    }

    @Override
    public DatCho getDatCho(String id) {
        return datChoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("Đặt chỗ có id %s không tồn tại", id)));
    }
    private DatCho getDatCho(DatChoDto dto, DatCho datCho) {
        datCho.setEmail(dto.getEmail().trim());
        datCho.setThongTinDatChos(dto.getThongTinDatChos());
        datCho.setThoiGian(dto.getThoiGian());
        datCho.setCanDan(dto.getCanDan().trim());
        datCho.setTrangThaiDatCho(dto.getTrangThaiDatCho().trim());

        datChoRepository.save(datCho);
        return datCho;
    }
    @Override
    public DatCho createDatCho(DatChoDto dto) {
        DatCho datCho = new DatCho();

        return getDatCho(dto, datCho);
    }



    @Override
    public DatCho updateDatCho(String id, DatChoDto dto) {
        DatCho datCho = getDatCho(id);

        return getDatCho(dto, datCho);
    }

    @Override
    public DatCho deleteDatCho(String id) {
        DatCho datCho = getDatCho(id);
        datChoRepository.delete(datCho);
        return datCho;
    }
}
