import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Matrix A = new Matrix(2, 2, new double[]{ 5, 3, 2, 1});
        Matrix M = new Matrix(2, 3, new double[]{21, 14, 9, 6, 15, 18});
        Matrix systemA = new Matrix(3, 4, new double[]{ 1, 1, 2, 9, 2, 4, -3, 1, 3, 6, -5, 0 });

        System.out.println(LinearAlgebra.gauss(systemA));

//        Vector a = new Vector(2, new double[]{1, 2});
//        System.out.println(LinearAlgebra.times(A, a));
//        System.out.println(a);
//        Matrix MCode = LinearAlgebra.dot(A, M);
//        System.out.println(MCode);
    }

}

