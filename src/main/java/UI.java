
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UI {

    private final Transformer wrangler;
    private final Scanner userInput;
    private final ArrayList<String> list;
    private final ArrayList<Character> listFirstLetter;
    private final ArrayList<String> listRest;

    public UI(Transformer wrangler, Scanner userInput, ArrayList<String> list, ArrayList<Character> listFirstLetter, ArrayList<String> listRest) {
        this.wrangler = wrangler;
        this.userInput = userInput;
        this.list = list;
        this.listFirstLetter = listFirstLetter;
        this.listRest = listRest;
    }

    public void start() {
        System.out.println("I'm here to switch around the starting consonants of two consecutive words.");
        System.out.println("Give me words.");
        System.out.println("Type :* to exit.");

        while (true) {

            list.clear();
            listFirstLetter.clear();
            listRest.clear();

            System.out.print("> ");
            String read = userInput.nextLine();

            String[] parts = read.split(" ");
            list.addAll(Arrays.asList(parts));

            if (read.contains(":*")) {
                System.out.println("Bye bye :* :* :*");
                break;
            }

            if (read.isEmpty()) {
                System.out.println("That's not words. Give me words.");
                continue;
            }

            if (parts.length == 1) {
                System.out.println("What's that? Give me at least 2 words. Try 'shiro miro'.");
                continue;
            }

            for (int i = 0; i < list.size(); i++) {
                String listaRead = list.get(i);
                listFirstLetter.add(listaRead.charAt(0));
                listRest.add(listaRead.substring(1));
            }

            for (int i = 0; i < list.size() - 1; i++) {
                if (!wrangler.isConsonant(listFirstLetter.get(i))) {
                    System.out.println("Word " + list.get(i) + " starts with a vowel (" + listFirstLetter.get(i) + "), no consonant switching for that pair. I'll hide that pair.");
                }
                if (i % 2 == 0 && wrangler.isConsonant(listFirstLetter.get(i + 1))) {
                    System.out.println(listFirstLetter.get(i + 1) + listRest.get(i) + " " + listFirstLetter.get(i) + listRest.get(i + 1));
                } else if (i % 2 != 0 && i > list.size() - 3) {
                    System.out.println(listFirstLetter.get(i + 1) + listRest.get(i + 1));
                }
            }
        }
    }

}