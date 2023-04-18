package com.stc.petlove.services;

import com.stc.petlove.dtos.TaiKhoanDto;
import com.stc.petlove.entities.TaiKhoan;

public interface TaiKhoanService {
    TaiKhoan getTaiKhoan(String id);
    TaiKhoan createTaiKhoan (TaiKhoanDto dto);

    TaiKhoan updateTaiKhoan (String id, TaiKhoanDto dto);

    TaiKhoan deleteTaiKhoan (String id);
}
