package com.example.bootemo.repository;

import com.example.bootemo.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StaffRepository extends PagingAndSortingRepository<Staff,Long> {

    Page<Staff> findAllByCodeContainingOrFullNameContaining (String code, String name, Pageable pageable);
}
