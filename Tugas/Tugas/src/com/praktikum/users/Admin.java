package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.data.DataStore;
import com.praktikum.data.Item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Admin extends User implements AdminActions {

    private String username = "Admin380";
    private String password = "Password380";

    public Admin(String nama, String nim) {
        super(nama, nim);
    }

    public List<Item> getDaftarBarang() {
        return DataStore.reportedItem;
    }

    public List<Mahasiswa> getDaftarMahasiswa() {
        List<Mahasiswa> daftar = new ArrayList<>();
        for (User u : DataStore.userList) {
            if (u instanceof Mahasiswa) {
                daftar.add((Mahasiswa) u);
            }
        }
        return daftar;
    }

    public boolean tambahMahasiswa(String nama, String nim) {
        for (User u : DataStore.userList) {
            if (u instanceof Mahasiswa && u.getNim().equals(nim)) {
                return false;
            }
        }
        DataStore.userList.add(new Mahasiswa(nama, nim));
        return true;
    }

    public boolean hapusMahasiswa(String nim) {
        Iterator<User> it = DataStore.userList.iterator();
        while (it.hasNext()) {
            User u = it.next();
            if (u instanceof Mahasiswa && u.getNim().equals(nim)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean tandaiBarangClaimed(Item item) {
        if (item != null && "Reported".equalsIgnoreCase(item.getStatus())) {
            item.setStatus("Claimed");
            return true;
        }
        return false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void displayInfo(String nama, String nim) {
    }

    @Override
    public void displayAppMenu() {
    }

    @Override
    public void manageUsers() {
    }

    public void manageItems() {
    }
}
