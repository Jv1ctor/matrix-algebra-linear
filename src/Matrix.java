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
        this.elements[index] = Math.round(value);
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns(){
        return this.columns;
    }

    public double[] getElements(){ return this.elements; }

    @Override
    public String toString(){
        StringBuilder text = new StringBuilder();
        for(int i = 0; i < rows * columns; i ++){
            int indexCols = i % columns;
            text.append(elements[i]).append("  ");
            if(indexCols == columns - 1){
                text.append("\n");
            }
        }

        return text.toString();
    }
}
