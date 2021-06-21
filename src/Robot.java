import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Robot {

    private Position position;
    private String[] routes;

    public Robot( Position position, String[] routes ) {
        this.position = position;
        this.routes = routes;
    }

    public Position getPosition( ) {
        return position;
    }

    public void setPosition( Position position ) {
        this.position = position;
    }

    public String[] getRoutes( ) {
        return routes;
    }

    public void setRoutes( String[] routes ) {
        this.routes = routes;
    }
}
