
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        ArrayList<Character> listFirstLetter = new ArrayList<>();
        ArrayList<String> listRest = new ArrayList<>();

        Transformer firstChar = new Transformer();

        Scanner userInput = new Scanner(System.in);

        UI ui = new UI(firstChar, userInput, list, listFirstLetter, listRest);
        ui.start();

    }
}


// for testing use
// moido kaso simo pasi samo pamu kon piika kissa aino pisa kona poika kalle oona

