package com.aasem.recyclerviewwithmasterdetail;

import java.util.Comparator;

/**
 * Created by inspire_info_soft on 5/2/2018.
 */

public class DataStudent {
    String rollNumber, name, contactNumber;
    int id,image;

    public DataStudent(int id, String rollNumber, String name, String contactNumber,int image) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.contactNumber = contactNumber;
        this.id = id;
        this.image=image;
    }

    public static final Comparator<DataStudent> SORT_BY_NAME = new Comparator<DataStudent>() {
        @Override
        public int compare(DataStudent dataStudent, DataStudent t1) {
            return dataStudent.name.compareTo(t1.name);
        }
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
