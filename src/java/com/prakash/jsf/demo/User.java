/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prakash.jsf.demo;

/**
 *
 * @author Dell 
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class User implements Serializable {

    private String firstName;
    private String middleName;
    private String lastName;
    private String faculty;
    private String program;

    private Map<String, Map<String, String>> data = new HashMap<>();

    private Map<String, String> facultyList;
    private Map<String, String> programList;

    private ArrayList<User> userList;

    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, String>> data) {
        this.data = data;
    }

    public Map<String, String> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(Map<String, String> facultyList) {
        this.facultyList = facultyList;
    }

    public Map<String, String> getProgramList() {
        return programList;
    }

    public void setProgramList(Map<String, String> programList) {
        this.programList = programList;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    @PostConstruct
    public void init() {

        userList = new ArrayList<>();

        facultyList = new HashMap<>();
        facultyList.put("Management", "Management");
        facultyList.put("Science And Technology", "Science And Technology");

        Map<String, String> map = new HashMap<>();
        map.put("BBA", "BBA");
        map.put("BBS", "BBS");
        data.put("Management", map);

        map = new HashMap<>();
        map.put("BE Comp", "BE Comp");
        map.put("BCA", "BCA");
        data.put("Science And Technology", map);
    }

    public void onFacultyChange() {
        if (faculty != null && !faculty.equals("")) {
            programList = data.get(faculty);
        } else {
            programList = new HashMap<>();
        }
    }

    public void save() {

        User theUser = new User();

        theUser.setFirstName(firstName);
        theUser.setMiddleName(middleName);
        theUser.setLastName(lastName);
        theUser.setFaculty(faculty);
        theUser.setProgram(program);
        userList.add(theUser);
        
        
        firstName=null;
        middleName=null;
        lastName=null;
        faculty=null;
        onFacultyChange();
        program=null;
    }

    public void delete(User theUser) {
        userList.remove(theUser);
    }

    public void update(User theUser) {
        firstName = theUser.firstName;
        middleName = theUser.middleName;
        lastName = theUser.lastName;
        faculty = theUser.faculty;
        onFacultyChange();
        program = theUser.program;
        delete(theUser);
    }
}

