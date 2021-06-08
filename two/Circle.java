package two;

public class Circle extends Shape implements Movable {
    private double centerX;
    private double centerY;
    private double radius;

    public Circle(){
        this.centerX = 0;
        this.centerY = 0;
        this.radius = 1;
    }

    public Circle(Point p, double r){
        this.centerY = p.getY();
        this.centerX = p.getX();
        this.radius = r;
    }

    public Circle(double x, double y, double radius){
        this.centerX = x;
        this.centerY = y;
        this.radius = radius;
    }

    public void setPosition(double x, double y){
        this.centerX = x;
        this.centerY = y;
    }

    public void move(double dx, double dy){
        this.centerY += dy;
        this.centerX += dx;
    }

    public double width(){
        return radius*2;
    }

    public double height(){
        return radius*2;
    }

    public double area(){
        return Math.PI*Math.pow(this.radius,2);
    }

    public double perimeter(){
        return Math.PI*2*this.radius;
    }

    public double distanceFromOrigin(){
        Point p = new Point(centerX, centerY);

        return p.distanceFromOrigin();
    }

    public boolean inBounds(Point p){
        Point c = new Point(this.centerX,this.centerY);

        if ( this.radius >= c.distance(p) ){
            return true;
        }
        else{
            return false;
        }
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getRadius() {
        return radius;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
