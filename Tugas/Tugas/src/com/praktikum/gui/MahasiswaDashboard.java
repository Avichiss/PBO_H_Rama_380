package com.praktikum.gui;

import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;
import com.praktikum.users.Mahasiswa;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MahasiswaDashboard extends VBox {

    private TableView<Item> table;
    private Mahasiswa currentMahasiswa;

    public MahasiswaDashboard(Stage stage) {
        if (LoginSystem.currentUser instanceof Mahasiswa) {
            currentMahasiswa = (Mahasiswa) LoginSystem.currentUser;
        } else {
            System.err.println("User bukan Mahasiswa!");
            return;
        }

        setPadding(new Insets(20));
        setSpacing(20);
        setStyle("-fx-background-color: #F2F2F2;");

        Label welcomeLabel = new Label("Selamat datang, " + currentMahasiswa.getNama());
        welcomeLabel.setFont(Font.font("Segoe UI", FontWeight.NORMAL, 14));

        Label instructionLabel = new Label("Laporkan Barang Hilang/Temuan");
        instructionLabel.setFont(Font.font("Segoe UI", 12));

        TextField namaBarangField = new TextField();
        namaBarangField.setPromptText("Nama Barang");
        namaBarangField.setPrefWidth(120);

        TextField deskripsiField = new TextField();
        deskripsiField.setPromptText("Deskripsi");
        deskripsiField.setPrefWidth(160);
        TextField lokasiField = new TextField();
        lokasiField.setPromptText("Lokasi");
        lokasiField.setPrefWidth(100);

        Button laporkanBtn = new Button("Laporkan");
        laporkanBtn.setPrefWidth(90);

        HBox inputForm = new HBox(10, namaBarangField, deskripsiField, lokasiField, laporkanBtn);
        inputForm.setAlignment(Pos.CENTER_LEFT);

        Label daftarLabel = new Label("Daftar Laporan Anda");
        daftarLabel.setFont(Font.font("Segoe UI", 13));

        table = new TableView<>();
        table.setStyle("-fx-font-size: 13px;");
        table.setPrefHeight(220);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getItemName()));

        TableColumn<Item, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getLocation()));

        table.getColumns().addAll(namaCol, lokasiCol);
        table.setItems(FXCollections.observableArrayList(currentMahasiswa.getReportedItems()));

        Button logoutBtn = new Button("Logout");
        logoutBtn.setPrefWidth(80);
        logoutBtn.setOnAction(e -> {
            LoginPane loginPane = new LoginPane(stage);
            stage.setScene(new Scene(loginPane, 600, 400));
        });

        laporkanBtn.setOnAction(e -> {
            String nama = namaBarangField.getText();
            String deskripsi = deskripsiField.getText();
            String lokasi = lokasiField.getText();

            if (!nama.isEmpty() && !deskripsi.isEmpty() && !lokasi.isEmpty()) {
                currentMahasiswa.reportItem(nama, deskripsi, lokasi);
                table.getItems().add(new Item(nama, deskripsi, lokasi));

                namaBarangField.clear();
                deskripsiField.clear();
                lokasiField.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Semua field harus diisi!", ButtonType.OK);
                alert.showAndWait();
            }
        });

        getChildren().addAll(welcomeLabel, instructionLabel, inputForm, daftarLabel, table, logoutBtn);
    }
}
