package com.nikotin.menueinkauf;

//DV: This is the Class which is used to map the JSON Response to an Object
//in our case we will use the Menu Object from the Menu here todo: put Menu Object here
public class RetroMenuNormal {
    String subject;
    String project;

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getProject(){return project;}
    public void setProject(String project){this.project=project;}

}

