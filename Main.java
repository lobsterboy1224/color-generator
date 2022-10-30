import java.util.*;
import java.awt.*;
import javax.swing.*;
// import java.lang.Boolean;
class Main extends colorGen{
	private static Scanner sc;
	private static Scanner sc2;

	//Prompt User to select a color from menu and return color selected color.
	static String getColor(){

    //Output Menu Options.
		System.out.print("Color Options:"
        + "\n-----------------------"
				+ "\n1: Red		2: Orange"
				+ "\n3: Yellow	4: Green"
				+ "\n5: Blue		6: Violet"
				+ "\n7: Pink		8: Brown"
				+ "\n9: Grey"
        + "\n-----------------------"
        + "\nEnter the number corresponding to the color you want: ");
    
		sc = new Scanner(System.in);
    //Declar Objects intialize empty objects.;
		String colorName = "";
		boolean valid = false;
    
		//Validate and Store Input
    //Promput user until correct input has been received.
		do {
			String numSelec = sc.next();
			switch (numSelec) {
			case "1":
        colorName = "Red";
        System.out.println("\nYou Selected " + colorName);
        valid = true;
		  	break;

			case "2":
        colorName = "Orange";
        System.out.println("\nYou Selected " + colorName);
        valid = true;
		  	break;

			case "3":
        colorName = "Yellow";
        System.out.println("\nYou Selected " + colorName);
        valid = true;
		  	break;

			case "4":
        colorName = "Green";
        System.out.println("\nYou Selected " + colorName);
        valid = true;
		  	break;

			case "5":
        colorName = "Blue";
        System.out.println("\nYou Selected " + colorName);
        valid = true;
		  	break;

			case "6":
        colorName = "Violet";
        System.out.println("\nYou Selected " + colorName);
        valid = true;
		  	break;

			case "7":  
        colorName = "Pink";
        System.out.println("\nYou Selected " + colorName);
        valid = true;
			  break;

			case "8":  
        colorName = "Brown";
        System.out.println("\nYou Selected " + colorName);
        valid = true;
		  	break;

			case "9":
        colorName = "Grey";
        System.out.println("\nYou Selected " + colorName);
        valid = true;
        break;
      
			default: System.out.println("\nInvalid Selection"
          + "\n-----------------------"
          + "\nColor Options:"
					+ "\n1: Red		2: Orange"
					+ "\n3: Yellow	4: Green"
					+ "\n5: Blue		6: Violet"
					+ "\n7: Pink		8: Brown"
					+ "\n9: Grey"
          + "\n-----------------------"
          + "\nSelect the color you wish to use: ");

			valid = false;
			break;

			}
		}
		while(!valid);

    //Return Color Object
    return colorName;
	};

  //Prompt the user to select 
	static int getNumColors(){
		sc2 = new Scanner(System.in);
		boolean valid = false;

    //Promput user to select the number of colors they wish to generate
		System.out.print("How many colors would you like to generate? (1-9): ");
		char numToGen;
		String strNum;
		valid = false;
		int i = 0;

    //Validate input, Ask user to re-inter selection if invalid.
		do {
			strNum = sc2.next();
			int length = strNum.length();
			numToGen = strNum.charAt(0);
			i = Character.getNumericValue(numToGen);  

			if(i < 1 || i >= 10 || length > 1) {
				valid = false;
				System.out.print("\nInvalid Selection"
						+ "\nHow many colors would you like to generate? (1-9): ");
			}
			else {
				System.out.println("\nYou Selected " + i + " Colors\n");
				valid = true;
			}
		}
		while(!valid);

		return i;
	}

  //for testing purposes.
	public static void main(String[] args) {
		//Prompt User To select a color
    	System.out.println("Running getColor().........................");
			String colorName = getColor();
    	System.out.println("Running getNumColors().....................");
			int num = getNumColors();
    	Color colorArr[];
    	colorArr = colorGen.generateColor(colorName, num);
      colorArr = colorGen.sortColors(colorArr);
			System.out.println("Validation Summary........................."
				+ "\nThere will be " + num + " variation(s) of " + colorName);
		//Frame and panel to display colors on
		JFrame frame = new JFrame("Random Color Generator");
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(500,500));

    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(500,500);
		//9 colors to be generate(to be changed based on customer requirements)
    	JButton button[] = new JButton[9];
	
		buttonPanel.setLayout(new GridLayout(3,3));
		int i = 0;
		while (i < num){
			button[i] = new JButton("#"+Integer.toHexString(colorArr[i].getRGB()).substring(2));
			button[i].setBackground(new Color(colorArr[i].getRed(), colorArr[i].getGreen(), colorArr[i].getBlue()));
    		buttonPanel.add(button[i]);
			i++;
		}

	frame.getContentPane().add(buttonPanel);
	frame.pack();
    frame.setVisible(true);
	}
  
}
