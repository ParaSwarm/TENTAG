package com.violox.tentag.controllers;

import com.violox.tentag.domain.DbContext;
import com.violox.tentag.domain.Key;
import com.violox.tentag.domain.User;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "adminUserController")
@ViewScoped
public class AdminUserController implements Serializable {

    @Inject
    private Key<Integer> obj_key;

    @Inject
    private DbContext dbcontext;

    private ArrayList<User> users;

    @PostConstruct
    public void init() {
        if (users == null) {
            users = new ArrayList<>();

            users = dbcontext.User().get();

            for (User u : users) {
                u.fillGroups(dbcontext,obj_key);
            }
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

}
