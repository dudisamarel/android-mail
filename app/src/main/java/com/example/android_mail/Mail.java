package com.example.android_mail;

import java.io.Serializable;
import java.util.ArrayList;

public class Mail implements Serializable {
    String name;
    int avatar;
    String subject;
    String content;
    String date;
    ArrayList<Mail> replay;

    public Mail(String name, int avatar, String subject, String content, String date) {
        this.name = name;
        this.avatar = avatar;
        this.subject = subject;
        this.content = content;
        this.date = date;
        this.replay = new ArrayList<Mail>();
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

    public void insertReplys(Mail replyMail) {this.replay.add(replyMail);}

    public ArrayList<Mail> getReplys() {return this.replay;}
}
