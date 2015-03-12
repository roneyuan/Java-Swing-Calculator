import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Calculator extends JFrame {
	
	public static float number;	
	public static String totalInput;
	public static float firstnumber;
	public static float secondnumber;
	public static float totalnumber;
	public static String sign;
	public static String DisplayedText;
	public static String PressedText;
	public static boolean equalback = false;
	public static boolean looping = false;
	public static boolean decimalpoint = false;
	
	private JTextField display;
	
	public Calculator(int w, int h, Color clr) {
		super("Calculator");
		
		//Setting background window
		Container container = getContentPane();
		setSize(w,h);
		container.setBackground(clr);
		display = new JTextField("");
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		panel.setBackground(Color.WHITE);		
		panel.setLayout(new GridLayout(4,5,0,0));	
		container.add(panel, BorderLayout.CENTER);	
		display.setPreferredSize(new Dimension (400,60));
		Font font = new Font("Normal", Font.BOLD, 40);
		display.setFont(font);
		panel2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel2.add(display);
		container.add(panel2, BorderLayout.NORTH);
		
		final String[] ButtonNames = {"7","8","9","/","%","4","5","6","*","sqrt()","1","2","3","-","+/-","AC","0", ".","+", "="};

		ActionListener actionlistener =new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JButton x = (JButton)e.getSource();
				
				// Set displayed text in text field
				DisplayedText = display.getText();
				// get the selected button
				PressedText = x.getText();				
				
				//*****************************************************************************************
				// if +-*/% is pressed, the number before +-*/% pressed will be saved in firstnumber
				// set sign equals to PressText +-*/% for computing the total number in the next loop
				// DisplayedText = "" to clear the window
				// PressedText = "" to clear the window
				//*****************************************************************************************
				// if AC is pressed, clear everything
				// if +/- or sqrt() is pressed, firstnumber will be the number which is input
				// set the number equals to totalnumber for future computation
				// convert the float number to string in order to display on text field
				// set DisplayedText equals totalinput to display the number
				//*****************************************************************************************
				// whenever the number is put in, the number is converted to float in order to compute
				// if equal back equals true means that when you input the number after +-*/% is pressed,
				// it will clear the window and displayed the number you want to be +-*/%. Also, it would
				// set the firstnumber equals to totalnumber so that the totalnumber can be computed next
				// time. Finally, set equalback to false to stop looping again.
				//*****************************************************************************************
				// if +-*/% is pressed, save the number to secondnumber and do the computation.
				// set the number equals to totalnumber for future computation.
				
				if(PressedText == "+" || PressedText == "-" || PressedText == "*" || PressedText == "/" || PressedText ==  "%") {
					firstnumber = number;
					sign = PressedText;
					DisplayedText = "";
					PressedText = "";
				} else if(PressedText =="AC") {
					number = 0;
					secondnumber = 0;
					totalnumber = 0;
					DisplayedText = "";
					PressedText = "";
					decimalpoint = false;
				} else if (PressedText == "+/-"){
					firstnumber = number;
					totalnumber = -1 * firstnumber;
					number = totalnumber;
					equalback = true;
					totalInput = Float.toString(totalnumber);
					DisplayedText = totalInput;
					PressedText = "";
				} else if (PressedText == "sqrt()"){
					firstnumber = number;
					totalnumber =  (float) Math.sqrt(firstnumber);
					number = totalnumber;
					equalback = true;
					totalInput = Float.toString(totalnumber);
					DisplayedText = totalInput;
					PressedText = "";
				} else if (PressedText == "."){
					if(decimalpoint == false) {
						DisplayedText = "";
					} 
				} else {
					decimalpoint = true;
					if (PressedText != "=") {
						number = Float.parseFloat(DisplayedText + PressedText);
						if (equalback == true) { 
							DisplayedText = "";
							firstnumber = totalnumber;
							//number = totalnumber;
							equalback = false;
						} 	
					} else if (sign == "+"){
						secondnumber = number;
						totalnumber = firstnumber + secondnumber;
						number = totalnumber;
						//firstnumber = Float.parseFloat(DisplayedText);
						//firstnumber = totalnumber;
						//System.out.println(number);
						equalback = true;
						totalInput = Float.toString(totalnumber);
						DisplayedText = totalInput;
						PressedText = "";
					} else if (sign == "-"){
						secondnumber = number;
						totalnumber = firstnumber - secondnumber;
						number = totalnumber;
						equalback = true;
						totalInput = Float.toString(totalnumber);
						DisplayedText = totalInput;
						PressedText = "";
					} else if (sign == "*"){
						secondnumber = number;
						totalnumber = firstnumber * secondnumber;
						number = totalnumber;
						equalback = true;
						totalInput = Float.toString(totalnumber);
						DisplayedText = totalInput;
						PressedText = "";
					} else if (sign == "/"){
						secondnumber = number;
						totalnumber = firstnumber / secondnumber;
						number = totalnumber;
						equalback = true;
						totalInput = Float.toString(totalnumber);
						DisplayedText = totalInput;
						PressedText = "";
					} else if (sign == "%"){
						secondnumber = number;
						totalnumber = (int)firstnumber % (int)secondnumber;
						number = totalnumber;
						equalback = true;
						totalInput = Float.toString(totalnumber);
						DisplayedText = totalInput;
						PressedText = "";
					} else {
						DisplayedText = totalInput;
						PressedText = "";
					}
				} 
				
				display.setText(DisplayedText + PressedText);
				
				/*
				//SUCESS
				if(PressedText == "+") {
					//DisplayedText = "";
					firstnumber = number;
					DisplayedText = "";
					PressedText = "";
				} else {
					if (PressedText != "=") {
						number = Integer.parseInt(DisplayedText + PressedText);
					} else {
						secondnumber = number;
						totalnumber = firstnumber + secondnumber;
						totalInput = Integer.toString(totalnumber);
						DisplayedText = totalInput;
						PressedText = "";
					}				
				}
				*/
				
				//**********************************************************************
				//Method 2
				//**********************************************************************
				/*
				if(PressedText != "+" && PressedText !="-" && PressedText !="*" && PressedText !="/" && PressedText !="%" && PressedText !="sqrt()"){
					if(PressedText == "="){
					} else if (looping == true && PressedText != "+") {
						DisplayedText = "";
						looping = false;
						equalback = true;
						firstnumber = totalnumber;
					} else if (looping == true && PressedText != "-") {
						DisplayedText = "";
						looping = false;
						equalback = true;
						firstnumber = totalnumber;
					} else if (looping == true && PressedText != "*") {
						DisplayedText = "";
						looping = false;
						equalback = true;
						firstnumber = totalnumber;
					} else if (looping == true && PressedText != "/") {
						DisplayedText = "";
						looping = false;
						equalback = true;
						firstnumber = totalnumber;
					} else if (looping == true && PressedText != "%") {
						DisplayedText = "";
						looping = false;
						equalback = true;
						firstnumber = totalnumber;
					} else if (looping == true && PressedText != "sqrt()") {
						DisplayedText = "";
						looping = false;
						equalback = true;
						firstnumber = totalnumber;
					}  else {
						number = Float.parseFloat(DisplayedText + PressedText);
						equalback = true;
					}
					
				} 				
										
				if (PressedText == "+" && equalback == false) {
					if(looping == false){
						number = Float.parseFloat(DisplayedText);
					} else {
						number = totalnumber;
					}
					firstnumber = number;
					DisplayedText = "";
					PressedText = "";
					equalback = true;					
				} 	else if (PressedText == "-" && equalback == false) {
					if(looping == false){
						number = Float.parseFloat(DisplayedText);
					} else {
						number = totalnumber;
					}
					firstnumber = number;
					DisplayedText = "";
					PressedText = "";
					equalback = true;					
				}	else if (PressedText == "*" && equalback == false) {
					if(looping == false){
						number = Float.parseFloat(DisplayedText);
					} else {
						number = totalnumber;
					}
					firstnumber = number;
					DisplayedText = "";
					PressedText = "";
					equalback = true;					
				} 	else if (PressedText == "/" && equalback == false) {
					if(looping == false){
						number = Float.parseFloat(DisplayedText);
					} else {
						number = totalnumber;
					}
					firstnumber = number;
					DisplayedText = "";
					PressedText = "";
					equalback = true;					
				} 	else if (PressedText == "%" && equalback == false) {
					if(looping == false){
						number = Float.parseFloat(DisplayedText);
					} else {
						number = totalnumber;
					}
					firstnumber = number;
					DisplayedText = "";
					PressedText = "";
					equalback = true;					
				} 	else if (PressedText == "sqrt()" && equalback == false) {
					if(looping == false){
						number = Float.parseFloat(DisplayedText);
					} else {
						number = totalnumber;
					}
					firstnumber = number;
					DisplayedText = "";
					PressedText = "";
					equalback = true;					
				}  
												
				if (PressedText == "=" && equalback == true) {

					secondnumber = number;
					totalnumber = firstnumber + secondnumber;
					totalInput = Float.toString(totalnumber);					
					DisplayedText = totalInput;
					PressedText = "";

					equalback = false;
					
				} else if (PressedText == "+" && equalback == true){

					secondnumber = number;

					totalnumber = firstnumber + secondnumber;

					totalInput = Float.toString(totalnumber);

					DisplayedText = totalInput;
					firstnumber = Float.parseFloat(DisplayedText);
					PressedText = "";

					equalback = false;
					looping = true;
				} else if (PressedText == "-" && equalback == true){

					secondnumber = number;

					totalnumber = firstnumber - secondnumber;

					totalInput = Float.toString(totalnumber);

					DisplayedText = totalInput;
					firstnumber = Float.parseFloat(DisplayedText);
					PressedText = "";

					equalback = false;
					looping = true;
				} else if (PressedText == "*" && equalback == true){

					secondnumber = number;

					totalnumber = firstnumber * secondnumber;

					totalInput = Float.toString(totalnumber);

					DisplayedText = totalInput;
					firstnumber = Float.parseFloat(DisplayedText);
					PressedText = "";

					equalback = false;
					looping = true;
				} else if (PressedText == "/" && equalback == true){

					secondnumber = number;

					totalnumber = firstnumber / secondnumber;

					totalInput = Float.toString(totalnumber);

					DisplayedText = totalInput;
					firstnumber = Float.parseFloat(DisplayedText);
					PressedText = "";

					equalback = false;
					looping = true;
				} else if (PressedText == "%" && equalback == true){

					secondnumber = number;

					totalnumber = firstnumber % secondnumber;

					totalInput = Float.toString(totalnumber);

					DisplayedText = totalInput;
					firstnumber = Float.parseFloat(DisplayedText);
					PressedText = "";

					equalback = false;
					looping = true;
				} */
				
				/*
				else if (PressedText == "+" && equalback == true) {
					DisplayedText = totalInput;
					secondnumber = number;
					totalnumber = firstnumber + secondnumber;
					firstnumber = totalnumber;
					totalInput = Float.toString(totalnumber);					
					//DisplayedText = totalInput;
					PressedText = "";
					
				}*/
				
				
			
				
				/*
				if (PressedText == "+") {
					sign = "+";
					DisplayedText = "";
					PressedText = "";
				} else if (PressedText == "="){
					sign = "=";
					totalnumber = firstnumber + secondnumber;
					DisplayedText = totalInput;
					firstnumber = totalnumber;
					PressedText = "";
				} else {
					number = Float.parseFloat(DisplayedText + PressedText); 
					
					if (sign == "+") {
						
						secondnumber = Float.parseFloat(DisplayedText + PressedText);
						
						
						
						totalnumber = firstnumber + secondnumber;
						
						totalInput = Float.toString(totalnumber);
						DisplayedText = totalInput;
						firstnumber = totalnumber; 
					} 	
					
					firstnumber = Float.parseFloat(DisplayedText + PressedText);
				
				}
				*/
				//System.out.println("Tot" + totalnumber);			 
				//System.out.println("1:" +firstnumber);
				//System.out.println("2:" +secondnumber);
				//System.out.println("E:" +equalback);			
			}
		};
		
		for (int i = 0; i<ButtonNames.length; i++){
			JButton Button = new JButton(ButtonNames[i]);
			//Button.setAlignmentX(Component.TOP_ALIGNMENT);
			Button.addActionListener(actionlistener);
			//container.add(Button,BorderLayout.LINE_START);
			Font font2 = new Font("Normal",Font.BOLD,16);
			Button.setFont(font2);
			panel.add(Button);
		}	
		
		this.addWindowListener
		(new WindowListener() {
				public void	windowActivated(WindowEvent e) {}
				public void	windowClosed(WindowEvent e) {}
				public void	windowClosing(WindowEvent e) {
					System.exit(0);
				}
				public void	windowDeactivated(WindowEvent e) {}
				public void	windowDeiconified(WindowEvent e) {}
				public void	windowIconified(WindowEvent e) {}
				public void	windowOpened(WindowEvent e) {}
			});
				
		setVisible(true);
	}
	public static void main(String[] a) {
		new Calculator(450, 450, Color.WHITE);
	}
}


/*
 * *************************************************
 * Option 2
 * *************************************************
 * The other method
//Setting button
JButton one = new JButton("1");
JButton two = new JButton("2");
JButton three = new JButton("3");
JButton four = new JButton("4");
JButton five = new JButton("5");
JButton six = new JButton("6");
JButton seven = new JButton("7");
JButton eight = new JButton("8");
JButton nine = new JButton("9");
JButton zero = new JButton("0");

one.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//JButton = (JButton)e.getSource();
			 //b.getText()
			display.setText( display.getText() + "1");
		}
	});
two.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		//JButton = (JButton)e.g=etSource();
		display.setText( display.getText() + "2");
	}
});	

three.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		//JButton = (JButton)e.getSource();
		display.setText( display.getText() + "3");
	}
});

container.add(one, BorderLayout.WEST);
container.add(two, BorderLayout.CENTER);
container.add(three, BorderLayout.LINE_END);
**********************************************************
**********************************************************/

