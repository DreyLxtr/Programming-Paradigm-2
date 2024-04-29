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

public class T505 extends Application{
   
   // these are declared outside of any method so they are accessible throught the class
   private TextField numField1;
   private TextField numField2;
   private Label resultLabel;
   
   @Override
   
      public void start (Stage stage){
      
      // create label for title
      Label titleLabel = new Label ("Simple Calculator");
         titleLabel.setTextFill(Color.GREEN);
         titleLabel.setFont(Font.font("Arial", 20));
     
      // create text field for user entry on first number
      numField1 = new TextField();
         numField1.setMaxWidth(80);
      
      // create text field for user entry on second number
      numField2 = new TextField();
         numField2.setMaxWidth(80);
      
      // create button to display addition result 
      Button addButton = new Button("+");
         addButton.setOnAction(e -> calculateResult('+'));
      
      // create button to display subtraction result
      Button minusButton = new Button("-");
         minusButton.setOnAction(e -> calculateResult('-'));
      
      // create button to display multiplication result   
      Button multiplyButton = new Button("x");
         multiplyButton.setOnAction(e -> calculateResult('*'));
      
      // create button to display division result
      Button divideButton = new Button("÷");
         divideButton.setOnAction(e -> calculateResult('/'));
      
      // create label for result
      resultLabel = new Label ("Answer: ");
         resultLabel.setTextFill(Color.RED);
         resultLabel.setFont(Font.font("Arial", 20));
      
      // create VBox to hold components
      VBox root = new VBox();
         root.setSpacing(10);
         root.setAlignment(Pos.CENTER);
      
      // add components in the VBox
      root.getChildren().addAll(titleLabel, numField1, numField2, addButton, minusButton, multiplyButton, divideButton, resultLabel);
      
      // create scene
      Scene scene = new Scene(root, 400, 300);
      
      // add the scene to the stage and make it visible
      stage.setScene(scene);
         stage.setTitle("T505");
         stage.show();
      }
      
      // method to calculate the inputed numbers
      private void calculateResult (char operator){
         
         // convert the inputed numbers from the text field to double
         double num1 = Double.parseDouble(numField1.getText());
         double num2 = Double.parseDouble(numField2.getText());
         double result = 0;
         
         // perfom the calculation
         switch (operator){
            
            // addition
            case '+':
               result = num1 + num2;
               break;
            
            // subtraction
            case '-':
               result = num1 - num2;
               break;
            
            // multiplication
            case '*':
               result = num1 * num2;
               break;
            
            // division  
            case '/':
               if (num2 != 0){
                  result = num1 / num2;
               }
               else {
                  resultLabel.setText("Cannot divide by zero");
                  return;
               }
               break;
         }
         
         // display the result
         resultLabel.setText("Answer: " + result);
      }
      
      public static void main (String [] args){
         launch(args);
      }
}
