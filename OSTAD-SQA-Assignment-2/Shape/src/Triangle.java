public class Triangle extends Shape{
    void draw(){

        System.out.println("This is a triangle");
    }
    double calculateArea(double base, double height){
        return 0.5*base*height;
    }
    
}
