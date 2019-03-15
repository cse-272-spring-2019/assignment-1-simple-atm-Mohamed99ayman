import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class mainmenu {

    private long money;
    public Text label1=new Text();
    public long moneygetter(){
        return money;
    }
    public void moneysetter(long money){
        this.money=money;
    }

    public void displaymainm(){
        Deposit d=new Deposit();
              Stage mainMenu=new Stage();
        mainMenu.setTitle("Main Menu");
        mainMenu.initModality(Modality.APPLICATION_MODAL);


        GridPane grid=new GridPane();
        grid.setPadding(new Insets(10));

        Text title = new Text("Main Menu");
        grid.add(title,1,0);

        title.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD,15));
        Button button1 = new Button("Withdrawal");
         label1=new Text("");
                    //BUTTONS
        Button button2 = new Button("Deposit");
        Button button3 = new Button("Balance Inquiry");


        Button button4 = new Button("Previous");
        Button button5 = new Button("Next");
        grid.setHgap(20);
        grid.setVgap(15);
        grid.add(button1,1,1);
        grid.add(button2,1,2);
        grid.add(button3,1,3);
        grid.add(button4,1,4);
        grid.add(button5,6,4);
        grid.add(label1,6,1);


        Scene scene=new Scene(grid,400,250);
        mainMenu.setScene(scene);
        mainMenu.show();
        button3.setOnAction(e ->{
            System.out.println(moneygetter());
            label1.setText("Your balance : "+Long.toString(d.m.moneygetter()));

        } );
        button2.setOnAction(e->{
           d.displayDep("Deposit");

        });
        button1.setOnAction(e->{

            d.displayDep("Withdrawal");

        });
        button4.setOnAction(e-> label1.setText(d.h.backClicked()));
        button5.setOnAction(e->label1.setText(d.h.nextClicked()));


    }
    /*public String getText(){
        System.out.println("HH");
        return label1.getText();

}*/
}