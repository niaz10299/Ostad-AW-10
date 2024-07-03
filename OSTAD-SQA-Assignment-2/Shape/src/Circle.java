public class Circle extends Shape{
    double PI = 3.1416;

    void draw(){
        System.out.println("This is a circle");

    }
    double calculateArea(double radius){
        return this.PI*radius*radius;

    }
}
