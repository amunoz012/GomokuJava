package two;

public class Rectangle extends Shape implements Movable{
    private double lowerLeftX;
    private double lowerLeftY;
    private double upperRightX;
    private double upperRightY;

    public Rectangle(){
        this.lowerLeftX = 0;
        this.lowerLeftY = 0;
        this.upperRightX = 1;
        this.upperRightY = 1;
    }

    public Rectangle(Point low, Point up){
        this.lowerLeftX = low.getX();
        this.lowerLeftY = low.getY();
        this.upperRightX = up.getX();
        this.upperRightY = up.getY();
    }

    public Rectangle(double w, double h){
        this.lowerLeftX = 0;
        this.lowerLeftY = 0;
        this.upperRightX = w;
        this.upperRightY = h;
    }

    public Rectangle(double x1, double y1, double x2, double y2){
        this.lowerLeftX = x1;
        this.lowerLeftY = y1;
        this.upperRightX = x2;
        this.upperRightY = y2;
    }

    public double area(){
        return Math.abs(upperRightX-lowerLeftX)*Math.abs(upperRightY-lowerLeftY);
    }

    public double perimeter(){
        return (Math.abs(upperRightX-lowerLeftX)+Math.abs(upperRightY-lowerLeftY))*2;
    }

    public double distanceFromOrigin(){
        Point p = new Point(lowerLeftX,lowerLeftY);

        return p.distanceFromOrigin();
    }

    public boolean inBounds(Point p){
        double x = p.getX();
        double y = p.getY();
        if ( x >= lowerLeftX && x <= upperRightX && y >= lowerLeftY && y <= upperRightY){
            return true;
        }
        else{
            return false;
        }
    }

    public void setPosition(double x, double y){
        double dx = this.upperRightX - this.lowerLeftX;
        double dy = this.upperRightY - this.lowerLeftY;
        this.lowerLeftX = x;
        this.lowerLeftY = y;
        this.upperRightX = this.lowerLeftX + dx;
        this.upperRightY = this.lowerLeftY + dy;
    }

    public void move(double dx, double dy){
        this.lowerLeftX += dx;
        this.upperRightX += dx;
        this.upperRightY += dy;
        this.lowerLeftY += dy;
    }

    public double width(){
        return upperRightX-lowerLeftX;
    }

    public double height(){
        return upperRightY-lowerLeftY;
    }

    public double getLowerLeftX(){
        return lowerLeftX;
    }

    public double getLowerLeftY(){
        return lowerLeftY;
    }

    public double getUpperRightX() {
        return upperRightX;
    }

    public double getUpperRightY() {
        return upperRightY;
    }

    public void setLowerLeftX(double lowerLeftX) {
        this.lowerLeftX = lowerLeftX;
    }

    public void setLowerLeftY(double lowerLeftY) {
        this.lowerLeftY = lowerLeftY;
    }

    public void setUpperRightX(double upperRightX) {
        this.upperRightX = upperRightX;
    }

    public void setUpperRightY(double upperRightY) {
        this.upperRightY = upperRightY;
    }
}
