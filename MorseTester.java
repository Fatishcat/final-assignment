import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class MorseTester {

	public static void main(String[] args) {
		MorseTree myTree = new MorseTree();
		Scanner sysScnr = new Scanner(System.in);
		
		try 
		{
			File dataFile = new File("morsecode.txt");
			Scanner scnr = new Scanner(dataFile);
			
			while(scnr.hasNextLine()) 
			{
				//takes in one line and creates a new tree node with the first character
				String line = scnr.nextLine();
				TreeNode<Character> newNode = new TreeNode<Character>(line.charAt(0));
				myTree.setRoot(myTree);
				
				// searches the rest of the 
				for(int i = 1; i < line.length(); i++) 
				{
					if(line.charAt(i) == 'o') 
					{
						if(i == line.length() - 1) 
						{
							myTree.getRoot().insertLeft(newNode);
							break;
						} else {
							myTree.setRoot(myTree.getRoot().getLeft());
						}
					} 
					else if(line.charAt(i) == '-') 
						{
							if(i == line.length() - 1) 
							{
								myTree.getRoot().insertRight(newNode);
								break;
							} else {
								myTree.setRoot(myTree.getRoot().getRight());
							}
						}
					}
				}
			myTree.setRoot(myTree);

		} catch (FileNotFoundException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		  }
		
		System.out.println(myTree.preOrder());
		System.out.println(myTree.postOrder());
		
		System.out.println("Enter a short phrase you wish to be converted to Morse Code: ");
		String userString = sysScnr.nextLine();
		System.out.println(myTree.encode(userString));
		
		System.out.println("Enter a Morse Code you wish to be converted to English: ");
		String userMorse = sysScnr.nextLine();
		System.out.println(myTree.decode(userMorse));
		
		
	}

}
