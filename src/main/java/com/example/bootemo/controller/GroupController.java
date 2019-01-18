package com.example.bootemo.controller;

import com.example.bootemo.model.Group;
import com.example.bootemo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class  GroupController {
    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/group/",method = RequestMethod.GET)
    public ResponseEntity<List<Group>> listAllGroup(){
        List<Group> groups = groupService.findAll();
        if (groups.isEmpty()){
            return new ResponseEntity<List<Group>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
    }

    @RequestMapping(value = "/group/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> getGroup(@PathVariable Long id){
        System.out.println("Fetching group with id " + id);
        Group customer = groupService.findById(id);
        if (customer == null) {
            System.out.println("Group with id " + id + " not found");
            return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Group>(customer, HttpStatus.OK);
    }

    //-------------------Create a Customer--------------------------------------------------------

    @RequestMapping(value = "/group/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody Group group, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating group " + group.getName());
        groupService.save(group);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/group/{id}").buildAndExpand(group.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Customer --------------------------------------------------------

    @RequestMapping(value = "/group/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Group> updateCustomer(@PathVariable("id") long id, @RequestBody Group group) {
        System.out.println("Updating group " + id);

        Group currentGroup = groupService.findById(id);

        if (currentGroup == null) {
            System.out.println("Group with id " + id + " not found");
            return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
        }

        currentGroup.setName(group.getName());
        currentGroup.setDescription(group.getDescription());
        currentGroup.setId(group.getId());

        groupService.save(currentGroup);
        return new ResponseEntity<Group>(currentGroup, HttpStatus.OK);
    }

    //------------------- Delete a Customer --------------------------------------------------------

    @RequestMapping(value = "/group/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Group> deleteGroup(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting group with id " + id);

        Group customer = groupService.findById(id);
        if (customer == null) {
            System.out.println("Unable to delete. Group with id " + id + " not found");
            return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
        }

        groupService.remove(id);
        return new ResponseEntity<Group>(HttpStatus.NO_CONTENT);
    }
}
