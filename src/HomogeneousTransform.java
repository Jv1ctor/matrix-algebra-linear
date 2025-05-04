import java.util.Arrays;

public interface HomogeneousTransform {

     static Matrix toHomogeneousVector(Vector vector, double hElement){
        double[] elements = vector.getElements();
        double[] elementsHomogeneous = Arrays.copyOf(elements, elements.length + 1);
        elementsHomogeneous[elementsHomogeneous.length - 1] = hElement;

        return new Matrix(vector.getDim() + 1, 1, elementsHomogeneous);
    }

    static Vector fromHomogenousVector(Matrix matrix){
        double[] elementsMatrixHomo = matrix.getElements();
        double[] elementsVector = Arrays.copyOf(elementsMatrixHomo, elementsMatrixHomo.length - 1);

        return new Vector(matrix.getRows() - 1, elementsVector);
    }


    static Matrix toHomogenousTransformLinear(Matrix matrixA){
       int hRows = matrixA.getRows() + 1;
       int hColumns = matrixA.getColumns() + 1;
       Matrix hMatrix = new Matrix(hRows, hColumns, new double[hRows * hColumns]);

       for(int i = 0; i < hMatrix.getRows(); i++){
         for (int j = 0; j < hMatrix.getColumns(); j++){
           if(j < hMatrix.getColumns() - 1 && i < hMatrix.getRows() - 1){
             hMatrix.set(i, j, matrixA.get(i, j));
           }
         }
       }
       hMatrix.set(hRows - 1, hColumns - 1,1);

       return hMatrix;
    }

    static Matrix toHomogenousOperatorLinear(Matrix matrixA, Vector vectorX){
        int hColumns = matrixA.getColumns() + 1;
        Matrix hMatrix = toHomogenousTransformLinear(matrixA);


        for(int i = 0; i < vectorX.getDim(); i++){
            hMatrix.set(i, hColumns - 1, vectorX.get(i));
        }


        return hMatrix;
    }
}

