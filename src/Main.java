
public class Main {

    public static void main(String[] args) {
        Matrix matriz1 = new Matrix(3, 4, new double[]{1, 1, 2, 9, 2, 4,-3, 1, 3, 6, -5, 0});

        Matrix result1 = LinearAlgebra.gauss(matriz1);

        System.out.println("Matriz:");
        matriz1.show();

        System.out.print("\n");
        System.out.println("Matriz escalonada:");
        result1.show();

        Matrix solve = LinearAlgebra.solve(matriz1);
        System.out.print("\n");
        System.out.println("Resolução do sistema com Gauss Jordan: ");

        if(solve != null){
            solve.show();
        }

    }
}