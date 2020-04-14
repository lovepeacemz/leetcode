import javafx.util.Pair;

import java.util.Random;

public class test {

    public static void main(String[] args) {
/*        Point p = new Point(3,5);
        test(p);
        System.out.println(p.x);*/
        Integer [] a = new Integer[10];
        a[0] = 1;
        Integer [] b = a.clone();
        b[0] = 2;

        Point [] p = new Point[1];
        p[0] = new Point(1,1);
        Point [] pa = p.clone();
        pa[0] = new Point(2,2);
        System.out.println(p[0].x);
    }

    public static void test(Point p){
        int x = 0, left = 0;
        int a = x  / (int) (Math.pow(10, left));
        p = new Point(5,6);
        return;
    }
}

class Point {
    Random random = new Random();
    int x, y;
    Point(int x, int y){
        random.nextInt();
        this.x = x;
        this.y = y;
    }
}
