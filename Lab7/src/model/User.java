/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Image;

/**
 *
 * @author zherenxiao
 */
public class User {
    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private String gender;
    private String phone;
    private String email;
    private String continent;
    private Image photo;
    private String hobbies;

    public User(String firstname, String lastname, int age, String gender, String phone, String email, String continent, String hobbies, Image photo) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.continent = continent;
        this.photo = photo;
        this.hobbies = hobbies;
    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }
    
    
   
    public String getHobbies(){
        return this.hobbies;
    }
    
    

    public int getAge() {
        return age;
    }


    public String getPhone() {
        return phone;
    }

    public String getContinent() {
        return continent;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }
    
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "User{" + "first name=" + firstname + ", last name=" + lastname + ", age=" + age + ", gender=" + gender + ", Email=" + phone+ ", phone=" + email + ", continent=" + continent + ", hobbies=" + hobbies + '}';
    }

    
    
    
}
