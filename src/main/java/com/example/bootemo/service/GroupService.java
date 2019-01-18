package com.example.bootemo.service;

import com.example.bootemo.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAll();

    Group findById(Long id);

    void save(Group group);

    void remove(Long id);
}
