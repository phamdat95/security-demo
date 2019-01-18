package com.example.bootemo.service.imp;

import com.example.bootemo.model.Group;
import com.example.bootemo.repository.GroupRepository;
import com.example.bootemo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GroupServiceImp implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Group> findAll() {
        return (List<Group>) groupRepository.findAll();
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public void save(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void remove(Long id) {
        groupRepository.delete(findById(id));
    }
}
