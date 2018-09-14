package core;

import java.beans.EventHandler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HomeScreen extends Application {
	private Button solnBtn;
	private TextField leftOperandTxtBox;
	private TextField rightOperandTxtBox;
	private TextField answerTxtBox;
	private ComboBox<String> operatorDropDown;
	
	public static void main(String[] args)
	{
		launch (args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		initUI(primaryStage);

	}

	private void initUI(Stage primaryStage) {

		Pane canvas = new Pane();				
		
		
		
		
		addControlToCanvas(canvas);
		
		Scene scene = new Scene(canvas,320,200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simple Caculator APP");
		primaryStage.show();
		
		
	}

	private void addControlToCanvas(Pane canvas) {
		int row1 = 20;
		int row2 = 60;
		int txtBoxWidth = 50;
		
		Label lable = new Label("Simple Caculator using JAVAFX");
		lable.setFont(Font.font("Serif",FontWeight.NORMAL,20));
		lable.relocate(20,row1);
		
	    leftOperandTxtBox = new TextField();
		leftOperandTxtBox.setMaxWidth(txtBoxWidth);
		leftOperandTxtBox.relocate(20, row2);
		
		operatorDropDown = new ComboBox<String>();
		operatorDropDown.getItems().addAll("+", "-", "*", "/", "%");
		operatorDropDown.setValue("+"); 
		operatorDropDown.relocate(80, row2);
		
		rightOperandTxtBox = new TextField();
		rightOperandTxtBox.setMaxWidth(txtBoxWidth);
		rightOperandTxtBox.relocate(150, row2);
		
		answerTxtBox = new TextField();
		answerTxtBox.setMaxWidth(txtBoxWidth);
		answerTxtBox.relocate(250,row2);
		answerTxtBox.setEditable(false);
		
	    solnBtn = new Button("=");
		solnBtn.relocate(210, row2);
		
		setSolnBtnClickHandler();
		
		canvas.getChildren().addAll(lable,leftOperandTxtBox,rightOperandTxtBox, 
				operatorDropDown,solnBtn,answerTxtBox);
	}

	private void setSolnBtnClickHandler() {
		solnBtn.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Double leftOperand = Double.valueOf(leftOperandTxtBox.getText());
				Double rightOperand = Double.valueOf(rightOperandTxtBox.getText());
				String operator = operatorDropDown.getValue();
				ArithmeticSolver solver = new ArithmeticSolver();
				String answer = String.valueOf(solver.solve(operator,leftOperand,rightOperand));
				answerTxtBox.setText(answer);
			}
		});
		
	}

}
 