package com.stc.petlove.services.Impl;

import com.stc.petlove.dtos.TaiKhoanDto;
import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.exceptions.NotFoundException;
import com.stc.petlove.repositories.TaiKhoanRepository;
import com.stc.petlove.services.TaiKhoanService;
import org.springframework.stereotype.Service;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
    private final TaiKhoanRepository taiKhoanRepository;

    public TaiKhoanServiceImpl(TaiKhoanRepository taiKhoanRepository) {
        this.taiKhoanRepository = taiKhoanRepository;
    }

    @Override
    public TaiKhoan getTaiKhoan(String id) {
        return taiKhoanRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("Tài khoản có id %s không tồn tại", id)));
    }
    private TaiKhoan getTaiKhoan(TaiKhoanDto dto, TaiKhoan taiKhoan) {
        taiKhoan.setName(dto.getName().trim());
        taiKhoan.setEmail(dto.getEmail().trim());
        taiKhoan.setPassword(dto.getPassword());
        taiKhoan.setDienThoai(dto.getDienThoai().trim());
        taiKhoan.setRoles(dto.getRoles());

        taiKhoanRepository.save(taiKhoan);
        return taiKhoan;
    }
    @Override
    public TaiKhoan createTaiKhoan(TaiKhoanDto dto) {

        TaiKhoan taiKhoan = new TaiKhoan();
        return getTaiKhoan(dto, taiKhoan);
    }

    @Override
    public TaiKhoan updateTaiKhoan(String id, TaiKhoanDto dto) {
        TaiKhoan taiKhoan = getTaiKhoan(id);
        return getTaiKhoan(dto, taiKhoan);
    }

    @Override
    public TaiKhoan deleteTaiKhoan(String id) {
        TaiKhoan taiKhoan = getTaiKhoan(id);
        taiKhoanRepository.delete(taiKhoan);
        return taiKhoan;
    }
}
