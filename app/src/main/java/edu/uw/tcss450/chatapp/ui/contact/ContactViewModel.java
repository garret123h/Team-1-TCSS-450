package edu.uw.tcss450.chatapp.ui.contact;

public class ContactViewModel {
    private String name;

    private String id;

    public ContactViewModel(String name, String id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }
}
