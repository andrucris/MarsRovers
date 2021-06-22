import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Plateau {

    private Coordinates upperRightCoordinates;
    private List<Robot> robots = new LinkedList<>();


    public Robot startRobot( String route, Position position ) {
        List<String> routeList = new LinkedList<>();
        String[] routeArray = route.split("");
        Robot robot = new Robot(position, routeArray);
        return robot;
    }

    public void deployRobot( String route, Position position ) {
        Robot robot = startRobot(route, position);
        calculateFinishPosition(robot);
        this.robots.add(robot);
    }

    public Position calculateFinishPosition( Robot robot ) {
        int xInitial = robot.getPosition().getCoordinates().getX();
        int yInitial = robot.getPosition().getCoordinates().getY();
        String headingInitial = robot.getPosition().getCardinalCompassPoints().name();
        System.out.println("initial " + " y is " + yInitial + " x is " + xInitial + " heading  " + headingInitial);

        for (int i = 0;i < robot.getRoutes().length;i++) {

            if ( Spin.M.name().equals(robot.getRoutes()[i]) ) {
                if ( CardinalCompassPoints.W.name().equals(headingInitial) ) {
                    if ( xInitial >= 1 ) {
                        xInitial = xInitial - 1;
                    }
                } else if ( CardinalCompassPoints.E.name().equals(headingInitial) ) {
                    if ( xInitial + 1 <= upperRightCoordinates.getX() ) {
                        xInitial = xInitial + 1;
                    }
                } else if ( CardinalCompassPoints.N.name().equals(headingInitial) ) {
                    if ( yInitial + 1 <= upperRightCoordinates.getY() ) {
                        yInitial = yInitial + 1;
                    }
                } else if ( CardinalCompassPoints.S.name().equals(headingInitial) ) {
                    if ( yInitial >= 1 ) {
                        yInitial = yInitial - 1;
                    }
                }
            } else if ( Spin.L.name().equals(robot.getRoutes()[i]) ) {
                if ( CardinalCompassPoints.W.name().equals(headingInitial) ) {
                    headingInitial = CardinalCompassPoints.S.name();
                } else if ( CardinalCompassPoints.S.name().equals(headingInitial) ) {
                    headingInitial = CardinalCompassPoints.E.name();
                } else if ( CardinalCompassPoints.E.name().equals(headingInitial) ) {
                    headingInitial = CardinalCompassPoints.N.name();
                } else if ( CardinalCompassPoints.N.name().equals(headingInitial) ) {
                    headingInitial = CardinalCompassPoints.W.name();
                }

            } else if ( Spin.R.name().equals(robot.getRoutes()[i]) ) {
                if ( CardinalCompassPoints.W.name().equals(headingInitial) ) {
                    headingInitial = CardinalCompassPoints.N.name();
                } else if ( CardinalCompassPoints.N.name().equals(headingInitial) ) {
                    headingInitial = CardinalCompassPoints.E.name();
                } else if ( CardinalCompassPoints.E.name().equals(headingInitial) ) {
                    headingInitial = CardinalCompassPoints.S.name();
                } else if ( CardinalCompassPoints.S.name().equals(headingInitial) ) {
                    headingInitial = CardinalCompassPoints.W.name();
                }

            }
            System.out.println("Route " + robot.getRoutes()[i] + " y is " + yInitial + " x is " + xInitial + " heading  " + headingInitial);
        }
        int xFinish = xInitial;
        int yFinish = yInitial;
        String headingFinish = headingInitial;


        Coordinates finishCoordinates = new Coordinates(xFinish, yFinish);
        CardinalCompassPoints headingFinishCardinalCompass = CardinalCompassPoints.valueOf(headingFinish);
        Position position = new Position(finishCoordinates, headingFinishCardinalCompass);
        System.out.println(position);
        return position;
    }


    ///GETTERS AND SETTERS
    public Coordinates getUpperRightCoordinates( ) {
        return upperRightCoordinates;
    }

    public void setUpperRightCoordinates( Coordinates upperRightCoordinates ) {
        this.upperRightCoordinates = upperRightCoordinates;
    }

    public List<Robot> getRobots( ) {
        return robots;
    }

    public void setRobots( List<Robot> robots ) {
        this.robots = robots;
    }

}
