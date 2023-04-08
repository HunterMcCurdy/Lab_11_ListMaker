import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        final String menu = " A - Add  D - Delete  P - Print  Q - Quit";
        boolean done = false;
        String cmd = "";
        displayList();
        do
        {

            // display the list
            // display the menu options
            // get a menu choice
            cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();
            int deletedItem = 0;
            String addedItem = "";

            // execute the choice
            switch(cmd)
            {
                case "A":
                    // prompt the user for a list item
                    addedItem = SafeInput.getNonZeroLenString(console, "What item would you like to add?");
                    list.add(addedItem);
                    break;

                case "D":
                    // prompt the user for the number of the item they want to delete
                    System.out.println("What item would you like to get rid of?");
                    deletedItem = in.nextInt();
                    deletedItem = deletedItem - 1;
                    list.remove(deletedItem);
                    // translate the number to an index by subtracting 1
                    // remove the item from the list
                    break;

                case "P":
                    displayList();
                    break;

                case "Q":
                    System.exit(0);
                    break;
            }



        }while(!done);

    }

    private static void displayList()
    {
        System.out.println("-----------------------------------");
        if(list.size() != 0)
        {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%3d%35s", i + 1, list.get(i));
                System.out.println();
            }
        }
        else
        {
            System.out.println("---        List is empty        ---");
        }
        System.out.println("-----------------------------------");

    }
}