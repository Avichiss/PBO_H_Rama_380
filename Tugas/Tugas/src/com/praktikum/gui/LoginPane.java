package com.praktikum.gui;

import com.praktikum.main.LoginSystem;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginPane extends VBox {
    public LoginPane(Stage stage) {
        Label title = new Label("Login Sistem Lost & Found");
        title.setFont(Font.font("Segoe UI",16));

        ComboBox<String> loginType = new ComboBox<>();
        loginType.getItems().addAll("Mahasiswa", "Admin");
        loginType.setPromptText("Pilih Login");
        loginType.setPrefWidth(150);

        TextField username = new TextField();
        username.setPromptText("Username");
        username.setPrefWidth(250);

        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        password.setPrefWidth(250);

        Button login = new Button("Login");
        login.setPrefWidth(80);
        login.setStyle(
                "-fx-background-color: #E0E0E0;" + "-fx-border-color: #B0B0B0;" + "-fx-text-fill: black;" + "-fx-font-size: 13px;" + "-fx-font-weight: normal;" + "-fx-background-radius: 3;" + "-fx-border-radius: 3;"
        );

        Button keluar = new Button("Keluar");
        keluar.setPrefWidth(80);
        keluar.setStyle(
                "-fx-background-color: #E0E0E0;" + "-fx-border-color: #B0B0B0;" + "-fx-text-fill: black;" + "-fx-font-size: 13px;" + "-fx-font-weight: normal;" + "-fx-background-radius: 3;" + "-fx-border-radius: 3;"
        );

        keluar.setOnAction( e -> {
            System.exit(0);
        });

        Label message = new Label();
        message.setTextFill(Color.DARKRED);

        login.setOnAction(e -> {
            User tryLogin = LoginSystem.doLogin(username.getText(), password.getText());

            if (tryLogin == null) {
                message.setText("Login gagal");
            } else {
                LoginSystem.currentUser = tryLogin;

                if (tryLogin instanceof Admin && "Admin".equals(loginType.getValue())) {
                    stage.setScene(new Scene(new AdminDashboard(stage), 1000, 600));
                } else if (tryLogin instanceof Mahasiswa && "Mahasiswa".equals(loginType.getValue())) {
                    stage.setScene(new Scene(new MahasiswaDashboard(stage), 1000, 600));
                } else {
                    message.setText("Login gagal");
                }
            }
        });

        this.setSpacing(15);
        this.setPadding(new Insets(40));
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #F2F2F2;");

        HBox n = new HBox(login, keluar);
        n.setAlignment(Pos.CENTER);
        n.setSpacing(15);
        n.setStyle("-fx-background-color: #F2F2F2;");

        this.getChildren().addAll(title, loginType, username, password, n, message);

    }
}
