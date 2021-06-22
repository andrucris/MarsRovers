import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 * //        int x = 5;
 * //        int y = 5;
 * //        int x1 = 1;
 * //        int y1 = 2;
 * //        String compassPoint1 = "N";
 * //        String route1 = "LMLMLMLMM";
 * //        int x2 = 3;
 * //        int y2 = 3;
 * //        String compassPoint2 = "E";
 * //        String route2 = "MMRMMRMRRM";
 */
public class Main {


    public static void main( String[] args ) {
        startSimulation();
    }


    public static void startSimulation( ) {

        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        scanner.nextLine();
        int y = scanner.nextInt();
        scanner.nextLine();

        int x1 = scanner.nextInt();
        scanner.nextLine();
        int y1 = scanner.nextInt();
        scanner.nextLine();
        String compassPoint1 = scanner.nextLine();
        String route1 = scanner.nextLine();


        int x2 = scanner.nextInt();
        scanner.nextLine();
        int y2 = scanner.nextInt();
        scanner.nextLine();
        String compassPoint2 = scanner.nextLine();
        String route2 = scanner.nextLine();

        Plateau plateau = createPlateau();
        Coordinates plateauRightCoordinates = calculateCoordinates(x, y);
        plateau.setUpperRightCoordinates(plateauRightCoordinates);

        Position robot1Position = calculatePosition(x1, y1, compassPoint1);
        plateau.deployRobot(route1, robot1Position);

        Position robot2Position = calculatePosition(x2, y2, compassPoint2);
        plateau.deployRobot(route2, robot2Position);


    }

    public static Coordinates calculateCoordinates( int x, int y ) {
        return new Coordinates(x, y);
    }

    public static Position calculatePosition( int x, int y, String cardinalCompassPoint ) {
        return new Position(new Coordinates(x, y), CardinalCompassPoints.valueOf(cardinalCompassPoint));
    }

    private static Plateau createPlateau( ) {
        Plateau plateau = new Plateau();
        return plateau;
    }
}


