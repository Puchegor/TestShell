package com.elmareos.testshell;

import androidx.annotation.NonNull;

public class Topic {
    private String nameTopic;
    private int idTopic;

    public Topic(String name, int id){
        this.nameTopic = name;
        this.idTopic = id;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public void setNameTopic(String nameTopic) {
        this.nameTopic = nameTopic;
    }

    public String getNameTopic() {
        return nameTopic;
    }

    public int getIdTopic() {
        return idTopic;
    }

    @NonNull
    @Override
    public String toString() {
        return getNameTopic();
    }
}
