import java.util.Scanner;

public class Scrabble {


    public static void main(String[] args) {
        String word;
        int totalValue = 0;

        //read in input
        System.out.println("Type in your word and hit enter. Use `?` for Blank spaces");
        Scanner scan = new Scanner(System.in);
        word = scan.nextLine();

        //check if word is valid
        if(word.matches("[a-zA-Z?]+")){
            System.out.println("Word is valid");
        }
        else {
            System.out.println("Word is invalid");
            return;
        }

        //allcaps word and turn into all uppercase
        String capsWord = word.strip().toUpperCase();
        String cleanWord = capsWord.replaceAll("[^a-zA-Z ]", "");

        //Add all letter values together
        for (int i = 0; i < cleanWord.length(); i++) {
            String currentTile = cleanWord.substring(i,i+1);
            totalValue = totalValue + LetterTile.valueOf(currentTile).getPoints();
        }


        //display the final point value
        System.out.print("Total points:");
        System.out.println(totalValue);
    }


}


enum LetterTile {

    A(1), E(1), I(1), O(1), U(1), L(1), N(1), S(1), T(1), R(1),
    D(2), G(2),
    B(3), C(3), M(3), P(3),
    F(4), H(4), V(4), W(4), Y(4),
    K(5),
    J(8), X(8),
    Q(10), Z(10);

    int points;
    LetterTile(int p) {
        points = p;
    }
    int getPoints() {
        return points;
    }
}
