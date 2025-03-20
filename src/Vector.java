import java.util.Arrays;
public class Vector {
    private int dim;
    private double[] elements;

    public Vector(int dim, double[] elements) {
        if(dim != elements.length){
            throw new Error("Quantidade de elementos incompatível com as dimensões do vetor");
        }

        this.dim = dim;
        this.elements = elements;
    }

    public int getDim(){
        return this.dim;
    }

    public double get(int i) {
        return elements[i];
    }

    public void set(int i, double value) {
        elements[i] = value;
    }

    public void show() {
        System.out.println(Arrays.toString(elements));
    } // esse método mostra o vetor completo
}
