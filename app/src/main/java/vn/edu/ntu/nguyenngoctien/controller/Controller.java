package vn.edu.ntu.nguyenngoctien.controller;

import java.util.ArrayList;
import android.app.Application;

import vn.edu.ntu.nguyenngoctien.model.Friends;

public class Controller extends Application implements IController {
    ArrayList<Friends> listFriends = new ArrayList<>();

    public Controller() {
        listFriends.add(new Friends("Buoi", 60000, "Buoi nam roi"));
        listFriends.add(new Friends("Tao", 70000, "Tao Chau Doc"));
        listFriends.add(new Friends("Le", 80000, "Le chau Phi"));
        listFriends.add(new Friends("Le", 80000, "Le chau Phi"));
    }

    @Override
    public ArrayList<Friends> getListFriends() {
        return listFriends;
    }
}