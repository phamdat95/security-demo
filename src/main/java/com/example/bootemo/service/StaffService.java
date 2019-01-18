package com.example.bootemo.service;

import com.example.bootemo.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StaffService {

    Page<Staff> findAll(Pageable pageable);

    Staff findById(Long id);

    void save(Staff staff);

    void remove(Long id);

    Page<Staff> findByCodeAndName(String code, String name, Pageable pageable);
}
