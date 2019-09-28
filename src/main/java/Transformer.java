
public class Transformer {

    public boolean isConsonant(char character) {
        switch (character) {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                return false;
            default:
                return true;
        }
    }
}
