package MyPackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {


	public static void main(String[] args) {
		launch(args);
        double amount=0;
	}

	
	public void start(Stage primaryStage) throws Exception {
		// first scene login
		Logic user = new Logic(10);
		primaryStage.setTitle("ATM");
		Label cardNo = new Label("Card Number");
		PasswordField cardN = new PasswordField();
		Button btn = new Button ("Submit");
		Label valid = new Label ();
		
		//set bounds of first scene
		GridPane grid = new GridPane();
		grid.add(cardNo, 0, 0);
		grid.add(cardN, 1, 0);
		grid.add(btn, 1, 1);
		grid.add(valid, 1, 2);
		Scene scene = new Scene (grid , 300 , 80);
		primaryStage.setScene(scene);
		// second scene menu
		Button withdraw = new Button("Withdrawal");
		Button deposit = new Button("Deposit");
		Button balance = new Button("Balance Inquiry");
		Button pre = new Button("Previous Transaction");
		Button next = new Button("Next Transaction");
		//set bounds of second scene
		GridPane grid1 = new GridPane();
		grid1.add(withdraw, 0, 0);
		grid1.add(deposit, 0, 1);
		grid1.add(balance, 0, 2);
		grid1.add(pre, 0, 3);
		grid1.add(next, 0, 4);
		Scene scene1 = new Scene (grid1 , 500 , 200);
		//third scene withdrawal
		Label label = new Label ("Enter the amount you want to withdraw");
		TextField text = new TextField();
		Button button = new Button("Submit");
		Button back = new Button("Back");
		Button back1 = new Button("Back");
		Button back2 = new Button("Back");
		//set bounds of third scene
		GridPane grid2 = new GridPane();
		grid2.add(label, 0, 0);
		grid2.add(text, 0, 1);
		grid2.add(button, 1, 1);
		Scene scene2 = new Scene (grid2,500,200);
		//fourth scene Deposit
		Label label1 = new Label ("Enter the amount you want to deposit");
		TextField text1 = new TextField();
		Button button1 = new Button("Submit");
		//set bounds of fourth scene
		GridPane grid3 = new GridPane();
		grid3.add(label1, 0, 0);
		grid3.add(text1, 0, 1);
		grid3.add(button1, 1, 1);
		Scene scene3 = new Scene (grid3,500,200);
		// scene of balace
		Label lbl = new Label("Your balance now is: ");
		TextField out = new TextField();
		//bounds
		GridPane grid4 = new GridPane();
		grid4.add(lbl, 0, 0);
		grid4.add(out, 0, 1);
		grid4.add(back, 0, 2);
		Scene scene4 = new Scene (grid4,500,200);
		// scene of pre
		Label lbl1 = new Label("Previous transaction: ");
		TextField prev = new TextField();
		//bounds
		GridPane grid5 = new GridPane();
		grid5.add(lbl1, 0, 0);
		grid5.add(prev, 0, 1);
		grid5.add(back1, 0, 2);
		Scene scene5 = new Scene (grid5,500,200);
		// scene of next
		Label lbl2 = new Label("Next transaction: ");
		TextField next1 = new TextField();
		//bounds
		GridPane grid6 = new GridPane();
		grid6.add(lbl2, 0, 0);
		grid6.add(next1, 0, 1);
	    grid6.add(back2, 0, 2);
		Scene scene6 = new Scene (grid6,500,200);
		
		
		
		btn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
			 String cardNumber = cardN.getText();
			 if (cardNumber.equals("1234"))
			 {
				 valid.setText("correct password");
				 primaryStage.setScene(scene1);
			 }
			 else 
			 {
				 valid.setText("Wrong password");
			 }
			}});
		withdraw.setOnAction(new EventHandler<ActionEvent> () {

			
			public void handle(ActionEvent arg0) {
				primaryStage.setScene(scene2);
				
			}});
        button.setOnAction(new EventHandler<ActionEvent> () {

			
			public void handle(ActionEvent arg0) {
				double amount = Double.parseDouble(text.getText());
				user.withdraw(amount);
				primaryStage.setScene(scene1);
				
				
			}});
        deposit.setOnAction(new EventHandler<ActionEvent> () {

			
			public void handle(ActionEvent arg0) {
				primaryStage.setScene(scene3);
				
			}});
        button1.setOnAction(new EventHandler<ActionEvent> () {

			
			public void handle(ActionEvent arg0) {
				double amount = Double.parseDouble(text1.getText());
				user.deposit(amount);
				primaryStage.setScene(scene1);
				
			}});
         balance.setOnAction(new EventHandler<ActionEvent> () {

			
			public void handle(ActionEvent arg0) {
				double amount = 0;
				user.withdraw(amount);
				user.deposit(amount);
				primaryStage.setScene(scene4);
				out.setText("" + user.BalanceInquiry());
				
			}});
         pre.setOnAction(new EventHandler<ActionEvent> () {
	
 			public void handle(ActionEvent arg0) {
 				double[] amount1 = null;
 				user.previous();
 				primaryStage.setScene(scene5);
 				prev.setText("" + user.previous());
 			}});
         next1.setOnAction(new EventHandler<ActionEvent> () {
        		
  			public void handle(ActionEvent arg0) {
  				double[] amount1 = null;
  				user.nextt();
  				primaryStage.setScene(scene6);
  				next1.setText("" + user.nextt());
  			}});
         back.setOnAction(new EventHandler<ActionEvent> () {
     		
   			public void handle(ActionEvent arg0) {
   				primaryStage.setScene(scene1);
   			}});
         back1.setOnAction(new EventHandler<ActionEvent> () {
      		
    			public void handle(ActionEvent arg0) {
    				primaryStage.setScene(scene1);
    			}});
         back2.setOnAction(new EventHandler<ActionEvent> () {
      		
    			public void handle(ActionEvent arg0) {
    				primaryStage.setScene(scene1);
    			}});
		
		primaryStage.show();
		
	}


	
	

}