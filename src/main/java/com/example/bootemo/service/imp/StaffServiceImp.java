package com.example.bootemo.service.imp;

import com.example.bootemo.model.Staff;
import com.example.bootemo.repository.StaffRepository;
import com.example.bootemo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class StaffServiceImp implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Page<Staff> findAll(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }

    @Override
    public Staff findById(Long id) {
        return staffRepository.findById(id).get();
    }

    @Override
    public void save(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void remove(Long id) {
        staffRepository.delete(findById(id));
    }

    @Override
    public Page<Staff> findByCodeAndName(String code, String name, Pageable pageable) {
        return staffRepository.findAllByCodeContainingOrFullNameContaining(code, name, pageable);
    }
}
