import java.util.Arrays;

public class Matrix {
    private int rows;
    private int columns;
    private float[] elements;
    private int indexElements = 0;
    protected float[][] matrixElements;

    Matrix(int rows, int columns, float[] elements){
        this.rows = rows;
        this.columns = columns;
        if(elements.length <= (rows * columns)){
            this.elements = elements;
        }else{
            System.out.println(rows * columns);
            System.out.println(elements.length);
            throw new Error("Quantidade de elementos incompatível com as dimensões da matriz");
        }

        this.matrixElements = this.generateArrayMatrix();
    }

    private float[][] generateArrayMatrix(){
        float[][] array = new float[this.rows][];
        for(int i = 0; i < this.rows; i++){
            float[] columnsElements = new float[this.columns];
            for(int j = 0; j < this.columns; j++){
                columnsElements[j] = elements[indexElements];
                indexElements++;
            }

            array[i] = columnsElements;
        }

        return  array;
    }


    public float get(int i, int j){
        return this.matrixElements[i][j];
    }

    public void set(int i, int j, float value){
        this.matrixElements[i][j] = value;
    }

    public void show(){
        for(int i = 0; i < rows; i++){
            for (int j= 0; j < columns; j++){
                System.out.print(matrixElements[i][j] + "  ");

                if(j == columns - 1){
                    System.out.print("\n");
                }
            }
        }
    }
}
