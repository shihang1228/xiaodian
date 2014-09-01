package com.baldurtech.manager;

import com.baldurtech.domain.Contact;

public class ContactManager {
    
    public Contact show(String id) {
        if(id != null) {
            return new Contact(){{
                setId(1l);
                setName("Ren Jian");
            }};
        }else{
            return null;
        }
    }
}