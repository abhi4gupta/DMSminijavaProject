//package sample;

package sample;
// intially my graph contains no vertex no edge
//we have to add vertex and edges by user interface provided by this programme
import javafx.animation.Animation;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Translate;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Signup {
      Stage window=new Stage();
    @FXML
    private TextField fn;
    @FXML
    private TextField ln;
    @FXML
    private TextField cp;
    @FXML
    private TextField cfp;
    @FXML
    private Button ok;
    @FXML
    private AnchorPane Anch;

    public void popup() throws Exception
    {
        Parent boot = FXMLLoader.load(getClass().getResource("Signup.fxml"));

        window.setTitle("SignUp");
        window.setScene(new Scene(boot,1200,700));


      window.showAndWait();



    }


      //  window.close();

//    public void buttonsin(ActionEvent event) throws IOException {
//        System.out.println("open");
//       // window.close();
//        System.out.println("close");
//        String fnn = fn.getText();
//        String lnn=ln.getText();
//        String cpp = cp.getText();
//        String cfpp=cfp.getText();
//
//       // Parent boot = FXMLLoader.load(getClass().getResource("Sample.fxml"));
//
//
//
//    }

    public void buttonclo(ActionEvent event) throws IOException {
        window.initModality(Modality.APPLICATION_MODAL);
        window.close();
    }
}
