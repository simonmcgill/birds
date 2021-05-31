import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Program {

    public static void main(String args[]) {

        SinglyLinkedList<Bird> birdList = new SinglyLinkedList<>();

        // get the birds
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

        // sort the birds

        birdList.sort();

        // print all

        birdList.printAll();

        String[] foreignBirds = new String[birdList.getSize()];
        int count = 0;

        // get the foreign birds
        try {
            File birdFile = new File("birds2.txt");

            Scanner scanner = new Scanner(birdFile);
            while (scanner.hasNextLine()) {
                String birdName = scanner.nextLine();

                Bird currentBird = new Bird(birdName);

                String name = currentBird.getName();

                foreignBirds[count] = name;
                count++;

            }
            scanner.close();
        } catch (FileNotFoundException error) {
            System.out.println("Error reading the file");
            error.printStackTrace();
        }

        // remove birds
        for (String bird : foreignBirds) {
            if (bird == null)
                continue;
            birdList.removeByName(bird);
        }

        birdList.printAll();
    }
}
