import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Program {
    public static void main(String args[]) {
        SinglyLinkedList<Bird> birdList = new SinglyLinkedList<>();

        try {
            File birdFile = new File("birds.txt");

            Scanner scanner = new Scanner(birdFile);
            while (scanner.hasNextLine()) {
                String birdName = scanner.nextLine();

                Bird currentBird = new Bird(birdName);

                if (!birdList.isIn(currentBird))
                    birdList.addFirst(currentBird);

                else
                    birdList.incrementOne(currentBird);

            }
            scanner.close();
        } catch (FileNotFoundException error) {
            System.out.println("Error reading the file");
            error.printStackTrace();
        }

    }
}
