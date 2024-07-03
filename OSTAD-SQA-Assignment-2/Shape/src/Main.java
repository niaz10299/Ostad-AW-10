public class Main {
    public static void main(String[] args) throws Exception {
       Shape shape = new Shape();
       Triangle t1 = new Triangle();
       Circle c1 = new Circle();
       Square s1 = new Square();

       t1.draw();
       c1.draw();
       s1.draw();
       System.out.println(t1.calculateArea(5, 10));
       System.out.println(c1.calculateArea(4));
       System.out.println(s1.calculateArea(3));

    }
}
