package com.example.bootemo.repository;

import com.example.bootemo.model.Group;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GroupRepository extends PagingAndSortingRepository<Group,Long> {
}
