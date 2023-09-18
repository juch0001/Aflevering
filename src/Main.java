import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final String BLUE_BOLD = "\033[1;34m";  // blå
    public static void main(String[] args) {
        Database superoDatabase = new Database();

        System.out.println("Welcome to the SUPERHERO UNIVERSE!");

        Scanner scanner = new Scanner(System.in);
        boolean runProgram = true;

        while (runProgram) {
            System.out.println("\nChoose your next step and enter a number:");
            System.out.println("1 Create");
            System.out.println("2 See complete list of superhero");
            System.out.println("3 Search for a superhero");
            System.out.println("9 Close");

            int menuNumber = scanner.nextInt();

            if (menuNumber == 1) {
                Scanner superheroInput = new Scanner(System.in);

                System.out.println("Enter the superhero name: ");
                String superheroName = superheroInput.next();
                System.out.println("Enter the true name (first and last): ");
                String firstName = superheroInput.next();
                String lastName = superheroInput.next();
                System.out.println("Enter superpower: ");
                String abilities = superheroInput.next();
                System.out.println("Enter which kind of creature the superhero is: ");
                String type = superheroInput.next();
                System.out.println("You have entered: " + superheroName + " " + firstName + lastName + " " + abilities + " " + type);

                superoDatabase.addSuperhero(superheroName, firstName, lastName, abilities, type);

            } else if (menuNumber == 2) {
                ArrayList<Superhero> superheroListe = superoDatabase.getSuperheroListe();
                if (superheroListe.isEmpty()) {
                    System.out.println("Ingen superhelte.");
                } else {
                    System.out.println("Liste over superhelte:");
                    for (Superhero superhero1 : superheroListe) {
                        if (superhero1 != null)
                            System.out.println(BLUE_BOLD + " Superhero: " + superhero1.getSuperheroName() + "\u001B[0m" + "\n" + " Name: " + superhero1.getFirstName() + " " + superhero1.getLastName() + "\n" + " Abilities: " + superhero1.getAbilities() + "\n" + " Type: " + superhero1.getType());
                    }
                }
            } else if (menuNumber ==3){
                Scanner seachInput = new Scanner(System.in);
                System.out.println("Enter the superheroname");
                String searchName = seachInput.next();

                Superhero foundSuperhero = superoDatabase.searchSuperhero(searchName);
                if (foundSuperhero != null) {
                    System.out.println("Superhero found");
                    System.out.println("Name " + foundSuperhero.getSuperheroName());
                    System.out.println("True Name " + foundSuperhero.getFirstName() + " " + foundSuperhero.getLastName());
                    System.out.println("Abilities " + foundSuperhero.getAbilities());
                    System.out.println("Type " + foundSuperhero.getType());

                } else {
                    System.out.println("Superhero not found");
                }
            } else if (menuNumber == 9) {
                System.out.println("We hope to see you again soon");
                runProgram = false;

            }

        }
    }
}