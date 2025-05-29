import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {
    private int targetNumber;
    private int attempts;
    private final Random rand = new Random();

    @Override
    public void start(Stage primaryStage) {
        generateNewNumber();

        Label titleLabel = new Label("🎯 Tebak Angka 1–100");
        titleLabel.setStyle("-fx-font-size: 25px; -fx-text-fill: navy;");

        Label inputMessageLabel = new Label("Masukkan tebakan");
        inputMessageLabel.setStyle("-fx-text-fill: gray; -fx-font-size: 15px;");

        TextField inputField = new TextField();
        inputField.setPromptText("Masukkan angka");
        inputField.setPrefWidth(140);

        Button actionButton = new Button("\uD83C\uDFB2 Coba Tebak!");
        actionButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");

        HBox inputRow = new HBox(10, inputField, actionButton);
        inputRow.setAlignment(Pos.CENTER);

        Label attemptLabel = new Label("Jumlah percobaan: 0");
        attemptLabel.setStyle("-fx-font-size: 15px;");

        VBox root = new VBox(12, titleLabel, inputMessageLabel, inputRow, attemptLabel);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #f0f8ff;");

        actionButton.setOnAction(e -> {
            if (actionButton.getText().equals("\uD83D\uDD04 Main Lagi")) {
                generateNewNumber();
                inputField.clear();
                inputMessageLabel.setText("Masukkan tebakan");
                inputMessageLabel.setStyle("-fx-text-fill: gray; -fx-font-size: 15px;");
                attemptLabel.setText("Jumlah percobaan: 0");
                actionButton.setText("\uD83C\uDFB2 Coba Tebak!");
                actionButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                return;
            }

            String input = inputField.getText().trim();
            if (!input.matches("\\d+")) return;
            int guess = Integer.parseInt(input);
            attempts++;

            if (guess < targetNumber) {
                inputMessageLabel.setText("⬆ Terlalu kecil!");
                inputMessageLabel.setStyle("-fx-text-fill: orange; -fx-font-size: 15px;");
            } else if (guess > targetNumber) {
                inputMessageLabel.setText("⬇ Terlalu besar!");
                inputMessageLabel.setStyle("-fx-text-fill: orange; -fx-font-size: 15px;");
            } else {
                inputMessageLabel.setText("✅ Tebakan benar!");
                inputMessageLabel.setStyle("-fx-text-fill: green;");
                actionButton.setText("\uD83D\uDD04 Main Lagi");
                actionButton.setStyle("-fx-background-color: #0000ff; -fx-text-fill: white;");
            }

            attemptLabel.setText("Jumlah percobaan: " + attempts);
        });

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Tebak Angka Advance");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateNewNumber() {
        targetNumber = rand.nextInt(100) + 1;
        attempts = 0;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
