public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        float[] elements = { 1, 2, 3, 4, 5, 6 , 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        Matrix matriz = new Matrix(4, 4, elements);
        matriz.show();

        float item = matriz.get(1, 3);
        System.out.println(item);

        matriz.set(1, 3, 20);
        matriz.show();
    }
}