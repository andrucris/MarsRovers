import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main( String[] args ) {
        readData();
    }

    public static void readData( ) {
//        Scanner sc = new Scanner(System.in);


        int x = 5;
        int y = 5;
        int x1 = 1;
        int y1 = 2;
        String compassPoint1 = "N";
        String route1 = "LMLMLMLMM";
        int x2 = 3;
        int y2 = 3;
        String compassPoint2 = "E";
        String route2 = "MMRMMRMRRM";


        Coordinates plateauRightCoordinates = getPlateauRightCoordinates(x, y);

        Plateau plateau = createPlateau();
        plateau.setUpperRightCoordinates(plateauRightCoordinates);

        Position robot1Position = getRobotPosition(x1, y1, compassPoint1);
        plateau.deployRobot(route1, robot1Position);

        Position robot2Position = getRobotPosition(x2, y2, compassPoint2);
        plateau.deployRobot(route2, robot2Position);


    }

    public static Coordinates getPlateauRightCoordinates( int x, int y ) {
        return new Coordinates(x, y);
    }

    public static Position getRobotPosition( int x, int y, String cardinalCompassPoint ) {
        return new Position(new Coordinates(x, y), CardinalCompassPoints.valueOf(cardinalCompassPoint));
    }

    private static Plateau createPlateau( ) {

        Plateau plateau = new Plateau();
        return plateau;
    }
}


