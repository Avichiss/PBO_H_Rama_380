package com.praktikum.gui;

import com.praktikum.data.DataStore;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        DataStore.userList.add(new Admin("Admin380", "Password380"));
        DataStore.userList.add(new Mahasiswa("Ramanda", "380"));

        LoginPane loginPane = new LoginPane(stage);
        Scene scene = new Scene(loginPane, 600, 400);

        stage.setTitle("Lost & Found Kampus");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
