import java.util.Scanner;

//Filters the text so that only alphabetic characters, blanks and newlines remain
public class Uppg1Filter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            String string = scan.nextLine() + '\n';
            for (int counter = 0; string.length() > counter; counter++) {
                if (string.charAt(counter) == 32 || string.charAt(counter) > 64 && string.charAt(counter) < 91 || string.charAt(counter) > 96 && string.charAt(counter) < 123 ){
                    System.out.print(string.charAt(counter));
                } else if (string.charAt(counter) == '\n'){
                    System.out.println();
                } else {
                    System.out.print(' ');
                }
            }
        }
    }
}
