import java.util.Scanner;

public class UserInput {


    public static String website() {
        System.out.println("Enter a URL");
        Scanner input = new Scanner(System.in);
        String url = input.nextLine();

        return url;
    }
}
