package com.example.sanjeev.alumninetwork.POJO_wrapper;

import com.example.sanjeev.alumninetwork.POJO.projects_model;

import java.util.ArrayList;
import java.util.List;


public class wrapper_project_model
{
    private List<projects_model> result = new ArrayList<projects_model>();
    public List<projects_model> getprojects() {
        return result;
    }
    public void setprojects(List<projects_model> projects) {
        this.result = projects;}
}
