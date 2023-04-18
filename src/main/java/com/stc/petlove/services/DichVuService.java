package com.stc.petlove.services;

import com.stc.petlove.dtos.DichVuDto;
import com.stc.petlove.entities.DichVu;

public interface DichVuService {
    DichVu getDichVu(String id);

    DichVu createDichVu (DichVuDto dto);

    DichVu updateDichVu (String id, DichVuDto dto);

    DichVu deleteDichVu (String id);
}
