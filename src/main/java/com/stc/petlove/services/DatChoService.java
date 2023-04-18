package com.stc.petlove.services;

import com.stc.petlove.dtos.DatChoDto;
import com.stc.petlove.entities.DatCho;

public interface DatChoService {
    DatCho getDatCho(String id);

    DatCho createDatCho (DatChoDto dto);

    DatCho updateDatCho (String id, DatChoDto dto);

    DatCho deleteDatCho (String id);
}
