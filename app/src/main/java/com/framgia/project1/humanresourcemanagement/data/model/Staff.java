package com.framgia.project1.humanresourcemanagement.data.model;

/**
 * Created by nguyenxuantung on 11/03/2016.
 */
public class Staff {
    private int id;
    private int idDepartment;
    private int status;
    private int position;
    private String name;
    private String birthday;
    private String placeOfBirth;
    private String phoneNumber;
    private String imageAvatar;

    public Staff(int id, int idDepartment, int status, int position, String name, String birthday, String placeOfBirth, String phoneNumber, String imageAvatar) {
        this.id = id;
        this.idDepartment = idDepartment;
        this.status = status;
        this.position = position;
        this.name = name;
        this.birthday = birthday;
        this.placeOfBirth = placeOfBirth;
        this.phoneNumber = phoneNumber;
        this.imageAvatar = imageAvatar;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImageAvatar() {
        return imageAvatar;
    }

    public void setImageAvatar(String imageAvatar) {
        this.imageAvatar = imageAvatar;
    }
}
