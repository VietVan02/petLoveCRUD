package com.stc.petlove.services;

import com.stc.petlove.dtos.LoaiThuCungDto;
import com.stc.petlove.entities.LoaiThuCung;

public interface LoaiThuCungService {
    LoaiThuCung getLoaiThuCung(String id);
    LoaiThuCung createLoaiThuCung (LoaiThuCungDto dto);

    LoaiThuCung updateLoaiThuCung (String id, LoaiThuCungDto dto);

    LoaiThuCung deleteLoaiThuCung (String id);
}
