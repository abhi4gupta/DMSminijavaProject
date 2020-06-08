package sample;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.util.ArrayList;

public class Main extends Application {
    UserHandler us= new UserHandler();
    DocumentHandler dh=new DocumentHandler();

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Document Management System");
        Image image =new Image((getClass().getResourceAsStream("DMS.png")));

        Label ik=new Label("DMS");
        ik.setGraphic(new ImageView(image));
        ik.setFont(new Font("Arial",50));
        TextField a1 = new TextField("");
        a1.setPromptText("username");
        Label l1 = new Label("username");

        PasswordField a2 = new PasswordField();
          a2.setPromptText("Your password");
        Label l2 = new Label("password");
        Button but=new Button("sign in");
        Button but2=new Button("signup");
        TilePane rroot = new TilePane();
        VBox root=new VBox();
        but.setOnAction(e->{
            if(us.checkUser(a1.getText(),a2.getText())){
               User crnt=us.finduser(a1.getText(),a2.getText());
            Stage window=new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("welcome  ");
            Label kll=new Label(" Welcome "+crnt.getFirstName());
                FadeTransition fd=new FadeTransition(Duration.seconds(0.8),kll);
                fd.setFromValue(20.0);
                fd.setToValue(0.0);
                fd.setCycleCount(Animation.INDEFINITE);
                fd.play();
            Label klk2=new Label("Manage your Document here");
            klk2.setFont(new Font("Arial",50));
            kll.setAlignment(Pos.TOP_CENTER);
            kll.setFont(new Font("Arial",50));
               kll.setTextFill(Color.BLACK);
               klk2.setTextFill(Color.BLACK);
            //kll.setStyle("blue");
            kll.setMinSize(200,100);
            Image image1 =new Image((getClass().getResourceAsStream("yourP.png")));
            Image image2 =new Image((getClass().getResourceAsStream("create.jpg")));
            Image image3 =new Image((getClass().getResourceAsStream("allfile.jpg")));

            Button ok1=new Button("your projects");
            ok1.setGraphic(new ImageView(image1));
            Button ok2=new Button("create new project");
            ok2.setGraphic(new ImageView(image2));
            Button ok3=new Button("all projects");
            ok3.setGraphic(new ImageView(image3));
            ok1.setMinSize(200,50);
            ok2.setMinSize(200,50);
            ok3.setMinSize(200,50);






                      ok1.setOnAction(e4-> {
                                  Stage texi = new Stage();
                                  VBox kl=new VBox();

                                  texi.initModality(Modality.APPLICATION_MODAL);
                                  texi.setTitle("welcome  ");

                          Image image9 =new Image((getClass().getResourceAsStream("cli.jpg")));

                          Label lll=new Label("Click here ");
                          Label lll1=new Label("");
                          lll.setFont(new Font("Arial",50));
                          lll1.setGraphic(new ImageView(image9));


                                  ArrayList<String> ss = dh.userfilenames(crnt.getUserName());
                                  ChoiceBox chi = new ChoiceBox(FXCollections.observableArrayList(ss));
                                  chi.setMinSize(200,50);
                                  chi.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {


                                                                                                  public void changed(ObservableValue ov, Number value, Number new_value) {
                                                                                                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                                                                                      VBox pane = new VBox();
                                                                                                      Image image =new Image((getClass().getResourceAsStream("openicon2.jpg")));
                                                                                                      Image image4 =new Image((getClass().getResourceAsStream("del.png")));

                                                                                                      Button bn1 = new Button("open");
                                                                                                      bn1.setGraphic(new ImageView(image));
                                                                                                      bn1.setMaxSize(100,100);
                                                                                                      Button bn2 = new Button("delete");
                                                                                                      bn2.setGraphic(new ImageView(image4));
                                                                                                      bn1.setOnAction(e3 -> {
                                                                                                          Stage tex = new Stage();
                                                                                                          tex.initModality(Modality.APPLICATION_MODAL);
                                                                                                          tex.setTitle("  ");
                                                                                                          String[] s = {"Font", "Arial", "Verdana", "Tahoma"};
                                                                                                          ChoiceBox bbutt1 = new ChoiceBox(FXCollections.observableArrayList(s));
                                                                                                          bbutt1.getSelectionModel().select(0);
                                                                                                          String[] s1 = {"color", "green", "blue", "red"};
                                                                                                          ChoiceBox bbutt2 = new ChoiceBox(FXCollections.observableArrayList(s1));
                                                                                                          bbutt2.getSelectionModel().select(0);
                                                                                                          Button bbutt3 = new Button("save");
                                                                                                          TextArea tft = new TextArea();
                                                                                                          tft.setMinWidth(400);
                                                                                                          tft.setMinHeight(400);
                                                                                                          tft.setText(dh.getDocument(crnt.getUserName(), ss.get(new_value.intValue())).getDocs());
                                                                                                          bbutt1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

                                                                                                                                                                             // if the item of the list is changed
                                                                                                                                                                             public void changed(ObservableValue ov, Number value, Number new_value) {
                                                                                                                                                                                 // set the text for the label to the selected item
                                                                                                                                                                                 tft.setFont(new Font(s[new_value.intValue()], 13.00));
                                                                                                                                                                             }
                                                                                                                                                                         }
                                                                                                          );
                                                                                                          bbutt2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

                                                                                                                                                                             // if the item of the list is changed
                                                                                                                                                                             public void changed(ObservableValue ov, Number value, Number new_value) {

                                                                                                                                                                                 // set the text for the label to the selected item
                                                                                                                                                                                 tft.setStyle("-fx-text-inner-color: " + s1[new_value.intValue()] + ";");
                                                                                                                                                                             }
                                                                                                                                                                         }
                                                                                                          );
                                                                                                          bbutt3.setOnAction(ee -> {
                                                                                                              tex.close();
                                                                                                          });
                                                                                                          VBox nb = new VBox();
                                                                                                          HBox h1 = new HBox();
                                                                                                          HBox h2 = new HBox();
                                                                                                          h1.setSpacing(30);
                                                                                                          // h1.getChildren().addAll(ll1,ll2,ll3);
                                                                                                          h2.getChildren().addAll(bbutt1, bbutt2, bbutt3);
                                                                                                          nb.getChildren().addAll(h1, tft, h2);
                                                                                                          tex.setScene(new Scene(nb, 800, 500));
                                                                                                          tex.showAndWait();
                                                                                                      });
                                                                                                      bn2.setOnAction(e5->{
                                                                                                          dh.deletedoc(crnt.getUserName(),ss.get(new_value.intValue()));
                                                                                                      });
                                                                                                      pane.getChildren().addAll(bn1, bn2);
                                                                                                      pane.setSpacing(10);

                                                                                                      alert.getDialogPane().setExpandableContent(pane);
                                                                                                      alert.showAndWait();


                                                                                                  }
                                                                                              }
                                  );

                          kl.getChildren().addAll(lll,lll1,chi);
                          kl.setAlignment(Pos.CENTER);

                                  texi.setScene(new Scene(kl,1200,700));
                                  texi.showAndWait();
                              });
                          /*Button bj1=new Button("empty");
                          Button bj2=new Button("empty");
                          Button bj4=new Button("empty");
                          Button bj5=new Button("empty");
                          Button bj3=new Button("empty");

                          if(ss.size()>=1)
                              bj1.setText(ss.get(0));
                          if(ss.size()>=2)
                              bj2.setText(ss.get(1));
                          if(ss.size()>=3)
                              bj3.setText(ss.get(2));
                          if(ss.size()>=4)
                              bj4.setText(ss.get(3));
                          if(ss.size()>=5)
                              bj5.setText(ss.get(4));*/

                       //Document dd =dh.getDocument(crnt.getUserName(), ss.get(new_value.intValue()));











            ok2.setOnAction(e3->{
                Alert alert= new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("add your Document");
                alert.setHeaderText("Details");
                VBox pane=new VBox();
                TextField b1=new TextField("");
                TextField b2 = new TextField("");
                TextField b3=new TextField("");
                TextField b4 = new TextField("");
               // TextField b5=new TextField("");
                Label l11=new Label("Document name");
               Label l12=new Label("Category");
                Label l13=new Label("Topic");
                Label l14=new Label("Tag");
               // Label l15=new Label("");
                Button butt1=new Button("add contain");
                butt1.setOnAction(e4->{
                    Stage tex= new Stage();
                    tex.initModality(Modality.APPLICATION_MODAL);
                    tex.setTitle("  ");
                    Image image7 =new Image((getClass().getResourceAsStream("ed.png")));

                    Label ll1=new Label(b1.getText());
                    Label ll2=new Label(b2.getText());
                    Label ll3=new Label(b3.getText());
                    Label ll4=new Label("text editor");

                    ll4.setFont(new Font("Verdana",50));
                    ll4.setGraphic(new ImageView(image7));
                    String[] s={"Font","Arial","Verdana","Tahoma"};
                   ChoiceBox bbutt1=new ChoiceBox(FXCollections.observableArrayList(s));
                   bbutt1.getSelectionModel().select(0);
                   String[] s1={"color","green","blue","red"};
                    ChoiceBox bbutt2=new ChoiceBox(FXCollections.observableArrayList(s1));
                    bbutt2.getSelectionModel().select(0);
                    Button bbutt3=new Button("save");
                    TextArea tft=new TextArea();
                    tft.setMinWidth(400);
                    tft.setMinHeight(400);
                    bbutt1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {


                        public void changed(ObservableValue ov, Number value, Number new_value)
                        {


                            tft.setFont(new Font(s[new_value.intValue()],13.00));
                            dh.addDocument(crnt.getUserName(),l11.getText(),l12.getText(),l13.getText(),l14.getText(),tft.getText());
                        }
                    }
                    );
                    bbutt2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

                        // if the item of the list is changed
                        public void changed(ObservableValue ov, Number value, Number new_value)
                        {
                            // set the text for the label to the selected item
                            tft.setStyle("-fx-text-inner-color: "+s1[new_value.intValue()]+";");
                        }
                      }
                    );

                    bbutt3.setOnAction(ee->{

                            dh.addDocument(crnt.getUserName(),b1.getText(),b2.getText(),b3.getText(),b4.getText(),tft.getText());
                                   tex.close();
                    });
                    VBox nb= new VBox();
                    HBox h1 =new HBox();
                    HBox h2=new HBox();
                    h1.setSpacing(30);
                    h1.getChildren().addAll(ll1,ll2,ll3);
                    h2.getChildren().addAll(bbutt1,bbutt2,bbutt3);
                    nb.getChildren().addAll(ll4,h1,tft,h2);
                    tex.setScene(new Scene(nb,800,500));
                    tex.showAndWait();

                });
                pane.getChildren().addAll(l11,b1,l12,b2,l13,b3,l14,b4,butt1);
                pane.setSpacing(8);

                alert.getDialogPane().setExpandableContent(pane);
                alert.showAndWait();

            });
            ok3.setOnAction(ed->{
                Stage texi = new Stage();
                VBox kl=new VBox();
                texi.initModality(Modality.APPLICATION_MODAL);
                texi.setTitle("welcome  ");
                Image image10 =new Image((getClass().getResourceAsStream("cli.jpg")));
                Label lll=new Label("Click here to search");
                Label lll1=new Label("");
                lll.setFont(new Font("Arial",50));
                lll1.setGraphic(new ImageView(image10));
                String [] ss={"Categories","tag","Topic"};
                ChoiceBox chi = new ChoiceBox(FXCollections.observableArrayList(ss));
                chi.setMinSize(200,50);
                chi.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                    public void changed(ObservableValue ov, Number value, Number new_value) {
                        Stage texit = new Stage();
                        VBox kll=new VBox();
                        texit.initModality(Modality.APPLICATION_MODAL);
                        texit.setTitle("welcome  ");
                        Image image11 =new Image((getClass().getResourceAsStream("search.png")));
                            Label kjk=new Label("search by "+ss[new_value.intValue()]);
                            kjk.setFont(new Font("Arial",50));
                            kjk.setGraphic(new ImageView(image11));
                        TextField ty=new TextField();
                        ty.setMinSize(50,50);
                        Label kjkk = new Label();
                      ty.setOnAction(er-> {
                                  String dd = dh.searchanything(ty.getText());
                                  kjkk.setText(dd);
                                  kjkk.setFont(new Font("Ariel",50));
                                  ty.setText("");
                              });
                        kll.getChildren().addAll(kjk,ty,kjkk);
                        kll.setAlignment(Pos.CENTER);
                        texit.setScene(new Scene(kll,1200,700));
                        texit.showAndWait();
                    }
                });
              kl.getChildren().addAll(lll,lll1,chi);
              kl.setAlignment(Pos.CENTER);
              texi.setScene(new Scene(kl,1200,700));
               texi.showAndWait();
            });
            VBox lay= new VBox();
            lay.setAlignment(Pos.CENTER);
            lay.setSpacing(10);
            lay.getChildren().addAll(kll,klk2,ok1,ok2,ok3);
            window.setScene(new Scene(lay,1200,700));
            window.showAndWait();}
            else{
                Alert alert= new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(" enter correct username or password");
                alert.setContentText("enter correct value");
                alert.showAndWait();
            }

        });
        but2.setOnAction(e->{
            Alert alert= new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Crerate your Acoount");
            alert.setHeaderText("sign up detail");
            VBox pane=new VBox();
            TextField b1=new TextField("");
            TextField b2 = new TextField("");
            TextField b3=new TextField("");
            TextField b4 = new TextField("");
            TextField b5=new TextField("");
            Label l11=new Label("First name");
            Label l12=new Label("Last Name");
            Label l13=new Label("username");
            Label l14=new Label("create password");
            Label l15=new Label("confirm password");
            pane.getChildren().addAll(l11,b1,l12,b2,l13,b3,l14,b4);
            pane.setSpacing(8);


            alert.getDialogPane().setExpandableContent(pane);
            alert.showAndWait();
            us.addUser(new User(b1.getText(),b2.getText(),b3.getText(),b4.getText()));

        });


       root.getChildren().addAll(ik,l1,a1,l2,a2,but,but2);
       root.setSpacing(8);
       rroot.getChildren().add(root);
        rroot.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(rroot, 1200, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
