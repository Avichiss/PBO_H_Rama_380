package com.praktikum.gui;

import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AdminDashboard extends VBox {
    private Admin admin;

    public AdminDashboard(Stage stage) {
        if (!(LoginSystem.currentUser instanceof Admin)) {
            System.err.println("User bukan Admin!");
            return;
        }
        admin = (Admin) LoginSystem.currentUser;

        setPadding(new Insets(15));
        setSpacing(10);
        setStyle("-fx-background-color: #F2F2F2;");

        Label halo = new Label("Halo, Administrator");
        halo.setFont(Font.font("Segoe UI", FontWeight.NORMAL, 13));

        Label labelBarang = new Label("Laporan Barang");
        TableView<Item> barangTable = new TableView<>();
        barangTable.setPrefSize(400, 300);
        barangTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setVgrow(barangTable, Priority.ALWAYS);

        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getItemName()));
        TableColumn<Item, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getLocation()));
        TableColumn<Item, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getStatus()));
        barangTable.getColumns().addAll(namaCol, lokasiCol, statusCol);
        barangTable.setItems(FXCollections.observableArrayList(admin.getDaftarBarang()));

        Button claimedBtn = new Button("Tandai Claimed");
        claimedBtn.setOnAction(e -> {
            Item selected = barangTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                admin.tandaiBarangClaimed(selected);
                barangTable.setItems(FXCollections.observableArrayList(admin.getDaftarBarang()));
                selected.setStatus("Claimed");
                barangTable.refresh();
            }
        });

        VBox barangBox = new VBox(5, labelBarang, barangTable, claimedBtn);
        barangBox.setPrefWidth(400);

        Label labelMhs = new Label("Data Mahasiswa");
        TableView<Mahasiswa> mhsTable = new TableView<>();
        mhsTable.setPrefSize(400, 300);
        mhsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setVgrow(mhsTable, Priority.ALWAYS);

        TableColumn<Mahasiswa, String> colNama = new TableColumn<>("Nama");
        colNama.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getNama()));
        TableColumn<Mahasiswa, String> colNim = new TableColumn<>("NIM");
        colNim.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getNim()));
        mhsTable.getColumns().addAll(colNama, colNim);
        mhsTable.setItems(FXCollections.observableArrayList(admin.getDaftarMahasiswa()));

        TextField namaField = new TextField();
        namaField.setPromptText("Nama Mahasiswa");
        namaField.setPrefWidth(180);

        TextField nimField = new TextField();
        nimField.setPromptText("NIM");
        nimField.setPrefWidth(180);

        HBox inputBox = new HBox(10, namaField, nimField);
        Button tambahBtn = new Button("Tambah");
        tambahBtn.setOnAction(e -> {
            String nama = namaField.getText();
            String nim = nimField.getText();
            if (!nama.isEmpty() && !nim.isEmpty()) {
                admin.tambahMahasiswa(nama, nim);
                mhsTable.setItems(FXCollections.observableArrayList(admin.getDaftarMahasiswa()));
                namaField.clear();
                nimField.clear();
            }
        });

        Button hapusBtn = new Button("Hapus");
        hapusBtn.setOnAction(e -> {
            Mahasiswa selected = mhsTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                admin.hapusMahasiswa(selected.getNim());
                mhsTable.setItems(FXCollections.observableArrayList(admin.getDaftarMahasiswa()));
            }
        });

        HBox bawahtabel = new HBox(10,inputBox, tambahBtn, hapusBtn);

        VBox mhsBox = new VBox(5, labelMhs, mhsTable, bawahtabel);
        mhsBox.setPrefWidth(500);
        mhsBox.setPadding(new Insets(20, 0, 0, 0));

        HBox tabelRow = new HBox(30, barangBox, mhsBox);

        Button logoutBtn = new Button("Logout");
        logoutBtn.setStyle("-fx-background-color: #DD4A48; -fx-text-fill: white;");
        logoutBtn.setOnAction(e -> {
            stage.setScene(new Scene(new LoginPane(stage), 600, 400));
        });
        HBox logoutBox = new HBox(logoutBtn);
        logoutBox.setAlignment(Pos.CENTER_LEFT);

        getChildren().addAll(halo, tabelRow, logoutBox);
    }
}
