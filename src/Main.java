import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Matrix A = new Matrix(2, 2, new double[]{ 5, 3, 2, 1});
        Matrix M = new Matrix(2, 3, new double[]{21, 14, 9, 6, 15, 18});
        Matrix systemA = new Matrix(3, 4, new double[]{ 1, 1, 2, 9, 2, 4, -3, 1, 3, 6, -5, 0 });

        Vector vector2d = new Vector(2, new double[]{1, 2});
        Vector result2d = LinearTransform.translate2D(vector2d, 5, 6);


        Vector vector3d = new Vector(3, new double[]{1, 2, 3});
        Vector result3d = LinearTransform.translate3D(vector3d, 5, 6, 7);


        System.out.println(result2d);
        System.out.println(result3d);
    }


}

