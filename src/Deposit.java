import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class Deposit {

    private long val;

    public void setVal(long val) {
        this.val = val;
    }

    public long getVal() {
        return val;
    }

    mainmenu m=new mainmenu();
    History h=new History();
    public void displayDep(String d){
        setVal(0);
        Stage Depos=new Stage();
        Depos.setTitle(d);
        Depos.initModality(Modality.APPLICATION_MODAL);
        Label label1=new Label("Enter value");
                Text tec=new Text();
                tec.setText(d);
                tec.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD,15));

        label1.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD,15));
        GridPane grid=new GridPane();
        grid.setPadding(new Insets(10));
        grid.add(tec,1,1);


        Button b1=new Button("1");
        Button b2=new Button("2");
        Button b3=new Button("3");
        Button b4=new Button("4");
        Button b5=new Button("5");
        Button b6=new Button("6");
        Button b7=new Button("7");
        Button b8=new Button("8");
        Button b9=new Button("9");
        Button b0=new Button("0");
        Button enter=new Button("Enter");
        Button cancel=new Button("Close");


        HBox h1=new HBox();
        HBox h2=new HBox();
        HBox h3=new HBox();
        HBox h4=new HBox();


        h1.getChildren().addAll(b1,b2,b3);
        h2.getChildren().addAll(b4,b5,b6);
        h3.getChildren().addAll(b7,b8,b9);
        h4.getChildren().add(b0);

        h4.setPadding(new Insets(1,30,10,30));
        h1.setSpacing(1);
        h2.setSpacing(1);
        h3.setSpacing(1);
        VBox vb=new VBox();

        Label label2=new Label("");

        vb.setPadding(new Insets(15,7,0,5));
        vb.getChildren().addAll(label1,label2,h1,h2,h3,h4);
        vb.setSpacing(1);

        grid.add(enter,3,3);
        grid.add(cancel,1,3);
        grid.add(vb,2,2);
        Scene scene=new Scene(grid,260,240);
        Depos.setScene(scene);

        Depos.show();

        b1.setOnAction(e->{
            setVal(getVal()*10+1);
            label1.setText(Long.toString(getVal()));
        });
        b2.setOnAction(e->{
            setVal(getVal()*10+2);
            label1.setText(Long.toString(getVal()));
        });
        b3.setOnAction(e->{
            setVal(getVal()*10+3);
            label1.setText(Long.toString(getVal()));
        });
        b4.setOnAction(e->{
            setVal(getVal()*10+4);
            label1.setText(Long.toString(getVal()));
        });
        b5.setOnAction(e->{
            setVal(getVal()*10+5);
            label1.setText(Long.toString(getVal()));
        });
        b6.setOnAction(e->{
            setVal(getVal()*10+6);
            label1.setText(Long.toString(getVal()));
        });
        b7.setOnAction(e->{
            setVal(getVal()*10+7);
            label1.setText(Long.toString(getVal()));
        });
        b8.setOnAction(e->{
            setVal(getVal()*10+8);
            label1.setText(Long.toString(getVal()));
        });
        b9.setOnAction(e->{
            setVal(getVal()*10+9);
            label1.setText(Long.toString(getVal()));
        });
        b0.setOnAction(e->{
            setVal(getVal()*10+0);
            label1.setText(Long.toString(getVal()));
        });
        enter.setOnAction(e->{
            if(d.compareTo("Withdrawal")==0&&getVal()>m.moneygetter()){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Insufficient money");
                alert.setContentText("Try again");
                alert.showAndWait();
                label1.setText("Enter value");
                setVal(0);
            }
            else if (d.compareTo("Withdrawal")==0&&getVal()<=m.moneygetter()){
                m.moneysetter(m.moneygetter()-getVal());
                h.setBack("Withdrew : "+getVal());
                h.res();
                Depos.close();

            }
            else {
                m.moneysetter(m.moneygetter()+getVal());
                h.setBack("Deposited : "+getVal());
                h.res();
                Depos.close();
            }


        });
        cancel.setOnAction(e->{
            setVal(0);
            Depos.close();});
    }

}
