import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Random;

public class T504 extends Application{

   private int randomNumbers;
   private int attempts = 0;
   
   @Override
   
      public void start (Stage stage){
      // generate random numbers between 1 and 100
      Random random = new Random();
         randomNumbers = random.nextInt(100) + 1;
      
      // create label for title
      Label titleLabel = new Label ("Guess the number (1-100)");
         titleLabel.setTextFill(Color.GREEN);
         titleLabel.setFont(Font.font("Arial", 20));
      
      // create text field for user entry
      TextField guessField = new TextField();
         guessField.setMaxWidth(50);
      
      // create label for result
      Label resultLabel = new Label();
         resultLabel.setTextFill(Color.RED);
         resultLabel.setFont(Font.font("Arial", 11));
      
      // create button to display result
      Button guessButton = new Button();
         guessButton.setText("GUESS");
         guessButton.setOnAction(e -> {
            String guessText = guessField.getText();
               
               // attempt count goes up every time you guess a number
               if (!guessText.isEmpty()){
                  int guess = Integer.parseInt(guessText);
                  attempts++;
                  
                  // this will show up when you guess the correct number
                  if (guess == randomNumbers){
                     resultLabel.setText("Congratulations! You guessed the number in " + attempts + " attempts.");
                     guessButton.setDisable(true);
                  }
                  
                  // this will show up when you enter a number greater than the correct number
                  else if (guess < randomNumbers){
                     resultLabel.setText("Try a higher number");
                  }
                  
                  // this will show up when you enter a number less than the correct number
                  else{
                     resultLabel.setText("Try a lower number");
                  }
               }
            });
      
      // create VBox to hold components
      VBox root = new VBox();
         root.setSpacing(10);
         root.setAlignment(Pos.CENTER);
      
      // add the components to the VBox
      root.getChildren().addAll(titleLabel, guessField, guessButton, resultLabel);
      
      // create a scene
      Scene scene = new Scene (root, 300, 200);
      
      // add the scene to the stage and make it visible
      stage.setScene(scene);
         stage.setTitle("T504");
         stage.show();
      
      
      }
      
      public static void main (String [] args){
         launch(args);
      }
}
