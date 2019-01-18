package com.example.bootemo.controller;

import com.example.bootemo.model.Group;
import com.example.bootemo.model.Staff;
import com.example.bootemo.service.GroupService;
import com.example.bootemo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private GroupService groupService;

    @ModelAttribute("group")
    public List<Group> getGroup(){
        return groupService.findAll();
    }

    @GetMapping("list")
    public ModelAndView showList(@PageableDefault(size = 5) Pageable pageable, @RequestParam("search")Optional<String> search){
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Staff> staff;
        if (!search.isPresent()){
            staff = staffService.findAll(pageable);
        } else {
            staff = staffService.findByCodeAndName(search.get(),search.get(),pageable);
            modelAndView.addObject("search", search.get());
        }
        modelAndView.addObject("staff",staff);
        return modelAndView;
    }
    @GetMapping("create")
    public ModelAndView showCreateFrom(){
        return new ModelAndView("create","staff",new Staff());
    }
    @PostMapping("create-staff")
    public ModelAndView createStaff(@Validated @ModelAttribute("staff") Staff staff, BindingResult result){
        ModelAndView modelAndView = new ModelAndView("create");
        if (result.hasFieldErrors()){
            modelAndView.addAllObjects(result.getModel());
        } else {
            staffService.save(staff);
            modelAndView.addObject("message","Created success");
        }
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Staff staff = staffService.findById(id);
        return new ModelAndView("edit","staff",staff);
    }
    @PostMapping("edit")
    public ModelAndView editStaff(@Validated @ModelAttribute("staff") Staff staff, BindingResult result){
        ModelAndView modelAndView = new ModelAndView("edit");
        if (result.hasFieldErrors()){
            modelAndView.addAllObjects(result.getModel());
        } else {
            staffService.save(staff);
            modelAndView.addObject("message","Updated success");
        }
        return modelAndView;
    }
    @GetMapping("delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Staff staff = staffService.findById(id);
        return new ModelAndView("delete","staff", staff);
    }
    @PostMapping("delete")
    public ModelAndView deleteStaff(@ModelAttribute("staff") Staff staff){
        staffService.remove(staff.getId());
        return new ModelAndView("redirect:list");
    }
}
