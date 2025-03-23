import java.util.Arrays;

public class Matrix {
    private int rows;
    private int columns;
    private double[] elements;

    Matrix(int rows, int columns, double[] elements){
        if(elements.length != (rows * columns)){
            throw new IllegalArgumentException("Quantidade de elementos incompatível com as dimensões da matriz");
        }
        this.rows = rows;
        this.columns = columns;
        this.elements = elements;
    }

    public double get(int i, int j){
        int index = i * columns + j;
        return this.elements[index];
    }

    public void set(int i, int j, double value){
        int index = i * columns + j;
        this.elements[index] = value;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns(){
        return this.columns;
    }

    public void show(){

        for(int i = 0; i < rows * columns; i ++){
            int indexCols = i % columns;
            System.out.print(elements[i] + "  ");

            if(indexCols == columns - 1){
                System.out.print("\n");
            }
        }
    }
}
