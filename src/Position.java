public class Position {

    private Coordinates coordinates;
    private CardinalCompassPoints cardinalCompassPoints;


    public Position( Coordinates coordinates, CardinalCompassPoints cardinalCompassPoints ) {
        this.coordinates = coordinates;
        this.cardinalCompassPoints = cardinalCompassPoints;
    }

    public Coordinates getCoordinates( ) {
        return coordinates;
    }

    public void setCoordinates( Coordinates coordinates ) {
        this.coordinates = coordinates;
    }

    public CardinalCompassPoints getCardinalCompassPoints( ) {
        return cardinalCompassPoints;
    }

    public void setCardinalCompassPoints( CardinalCompassPoints cardinalCompassPoints ) {
        this.cardinalCompassPoints = cardinalCompassPoints;
    }

    @Override
    public String toString( ) {
        final StringBuffer sb = new StringBuffer("");
        sb.append(coordinates);
        sb.append(" ");
        sb.append(cardinalCompassPoints);
        return sb.toString();
    }
}
