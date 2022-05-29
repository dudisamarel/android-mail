package com.example.android_mail;

import java.io.Serializable;
import java.util.ArrayList;

public class Mail implements Serializable {
    String name;
    int avatar;
    String subject;
    String content;
    String date;
    ArrayList<String> replay;

    public Mail(String name, int avatar, String subject, String content, String date) {
        this.name = name;
        this.avatar = avatar;
        this.subject = subject;
        this.content = content;
        this.date = date;
        this.replay = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public void insertReplys(String reply) {this.replay.add(reply);}

    public ArrayList<String> getReplys() {return this.replay;}
}
