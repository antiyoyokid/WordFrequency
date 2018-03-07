import java.util.Scanner;

public class UserInput {

    /**
     * Promps reader for url
     * @return the url user entered
     */
    public static String website() {
        System.out.println("Enter a URL");
        Scanner input = new Scanner(System.in);
        String url = input.nextLine();

        return url;
    }
}
