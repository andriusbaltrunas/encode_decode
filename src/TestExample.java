import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by andriusbaltrunas on 3/26/2018.
 */
public class TestExample {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] items;
        while (true) {
            System.out.println("Iveskite du skaicius ir veiksma tarp ju!!!");

            String line = sc.nextLine();

            items = line.split(" ");

            if (items.length == 3) {
                if (items[1].equals("+") || items[1].equals("-")) {
                    break;
                }
            }
        }

        int a = getCorrectNumb(items[0], sc, false);
        int b = getCorrectNumb(items[2], sc, true);

        switch (items[1]){
            case "+":
                sum(a, b);
                break;
            case "-":
                minus(a,b);
                break;
        }


    }

    private static int  getCorrectNumb(String numb, Scanner scanner, boolean isSecondNumb){
        int result = 0;
        try{
            result = Integer.valueOf(numb);
            if(isSecondNumb && result == 0){
                throw new NumberFormatException();
            }
        }catch (NumberFormatException e){
            while (true){
                String numbPosition = isSecondNumb ? "antra" : "pirma";
                System.out.println("Blogai skaicius, iveskite "+numbPosition+" nauja skaiciu");
                try {
                    result = scanner.nextInt();
                    if ((isSecondNumb && result !=0) || !isSecondNumb){
                        break;
                    }
                }catch (InputMismatchException ex){
                    scanner.nextLine();
                }
            }
        }

        return result;
    }

    private static void sum(int numb, int numb2){
        System.out.println("suma " +(numb + numb2));
    }

    private static void minus(int numb, int numb2){
        System.out.println("skirtumas " + (numb - numb2));
    }

}
