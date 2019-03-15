import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application implements EventHandler<ActionEvent>{

    Button button;
    final String password="1234";
    PasswordField pass=new PasswordField();
    Label label1=new Label("Card Number");
    public static void main(String[] args) {

        launch(args);
    }
    public void start(Stage primaryStage)throws Exception{

        primaryStage.setTitle("Bank Account");
        button=new Button("  Log In  ");

        GridPane grid=new GridPane();
        grid.setHgap(20);
        grid.setVgap(20);
        grid.add(label1,1,1);
        grid.add(pass,2,1);
        grid.add(button,2,3,2,3);
        button.setOnAction(this);



        Scene scene=new Scene(grid,350,215);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource()==button){
            String x=pass.getText();
            if(x.compareTo(password)==0){
                mainmenu mm=new mainmenu();
                mm.displaymainm();
            }
            else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Wrong Card Number");
                alert.setContentText("Please enter the right card number");
                alert.showAndWait();
            }
        }
    }
}
