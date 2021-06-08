package two;

public class Point {
    private double x;
    private double y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Point(Point p){
        this.x = p.getX();
        this.y = p.getY();
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }
    public double distance(Point p){
        return Math.sqrt(Math.pow(p.getX()-this.x,2)+Math.pow(p.getY()-this.y,2));
    }
    public double distanceFromOrigin(){
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }
}
