import java.util.Arrays;
public class Vector {
    private int dim;
    private int[] elements;

    public Vector(int dim, int[] elements) {
        this.dim = dim;
        this.elements = elements;
    }

    public int get(int i) {
        return elements[i];
    }

    public void set(int i, int value) {
        elements[i] = value;
    }

    public void printVector() {
        System.out.println(Arrays.toString(elements));
    } // esse método mostra o vetor completo

    public static void main(String[] args) {
        Vector vetor = new Vector(3, new int[]{1, 2, 3});

        System.out.println("Valor no índice 1: " + vetor.get(1)); // vai mostrar o valor que tem no indice 1
        vetor.set(1, 10); // altera o valor do indice 1 por 10
        System.out.println("Novo valor no índice 1: " + vetor.get(1));

        System.out.print("Vetor completo: ");
        vetor.printVector(); //vai retornar o vetor com a mudança de valor
    }
}
