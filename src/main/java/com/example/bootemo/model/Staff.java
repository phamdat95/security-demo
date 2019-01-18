package com.example.bootemo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = Group.class)
    @JoinColumn(name = "nhom_id")
    private Group group;

    @NotEmpty
    private String date;

    @NotEmpty
    private String fullName;

    @Size(min = 10,max = 10,message = "Please fill 10 character!")
    private String code;

    @Size(min = 2,max = 3)
    private String sex;

    @NotEmpty
    @Pattern(regexp = "^$|[0-9]{10}",message = "Number phone with 10 number")
    private String phoneNumber;

    @Pattern(regexp = "^$|[0-9]{9}",message = "Number phone with 9 number")
    private String idStafff;

    @Email
    private String Email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdStafff() {
        return idStafff;
    }

    public void setIdStafff(String idStafff) {
        this.idStafff = idStafff;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Staff() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Staff(Group group, String date, @NotEmpty String fullName, @Size(min = 10, max = 10, message = "Please fill 10 character!") String code, @Size(min = 2, max = 3) String sex, @Pattern(regexp = "^$|[0-9]{10}", message = "Number phone with 10 number") String phoneNumber, @Pattern(regexp = "^$|[0-9]{9}", message = "Number phone with 9 number") String idStafff, String email, @NotEmpty String address) {
        this.group = group;
        this.date = date;
        this.fullName = fullName;
        this.code = code;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.idStafff = idStafff;
        Email = email;
        this.address = address;
    }

    @NotEmpty
    private String address;
}
