public class LinearAlgebra{

    // Metodo para transpor uma matriz. A transposição troca as linhas pelas colunas.
    public static Matrix transpose(Matrix a) {
        Matrix result = new Matrix(a.getColumns(), a.getRows(), new double [a.getColumns() * a.getRows()]);

        // Percorre a matriz e troca os índices para fazer a transposição
        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getColumns(); j++) {
                result.set(j, i, a.get(i, j));
            }
        }
        return result;
    }
//
//    public static Vector transpose(Vector a) {
//        return new Vector(a.getDim(), a.getElements());
//    }
//

    // Metodo para somar duas matrizes.
    public static Matrix sum(Matrix a, Matrix b) {
        if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
            System.out.println("Erro: As matrizes devem ter as mesmas dimensões.");
            return null; // Ou qualquer outro valor que indique erro
        }

        Matrix result = new Matrix(a.getRows(), a.getColumns(), new double[a.getRows() * a.getColumns()]);

        // Percorre cada elemento da matriz e soma os valores correspondentes
        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getColumns(); j++) {
                result.set(i, j, a.get(i, j) + b.get(i, j));
            }
        }
        return result;


    }
    public static Vector sum(Vector a , Vector b){
        // Verificação das dimensoes
        if(a.getDim() != b.getDim()){
            throw new IllegalArgumentException("Os vetores precisam ter o mesmo tamanho");
        }
        //Criando o vetor resultante
        double[]resultData = new double[a.getDim()];

        for (int i = 0; i < a.getDim(); i++){
            resultData[i] = a.getElements()[i] + b.getElements()[i];
        }
        return new Vector(a.getDim(), resultData);
    }



    public static Object times(Object a, Object b){
        return switch (a) {
            case Matrix matrix when b instanceof Matrix -> timesMatrixMatrix(matrix, (Matrix) b);
            case Double v -> timesScalar((double) a, b);
            case Vector vector when b instanceof Vector -> timesVectorVector(vector, (Vector) b);
            case null, default -> throw new IllegalArgumentException("Tipos incompativeis para multiplicação");
        };
    }

    private static Vector timesVectorVector(Vector a, Vector b){
        if (a.getDim() != b.getDim()) {
            throw new IllegalArgumentException("Os Vetores devem ter o mesmo tamanho.");
        }

        int dim = a.getDim();
        Vector result = new Vector(dim, new double[dim]);
        for (int i = 0; i < dim; i++){
            result.set(i, a.get(i) * b.get(i));
        }

        return result;
    }

     private static Matrix timesMatrixMatrix(Matrix a, Matrix b){
         if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
             throw new IllegalArgumentException("As matrizes devem ter o mesmo tamanho.");
         }
         int rows = a.getRows();
         int cols = a.getColumns();
         Matrix result = new Matrix(rows, cols, new double[rows * cols]);
         for (int i = 0; i < rows; i++) {
             for (int j = 0; j < cols; j++) {
                 result.set(i, j, a.get(i, j) * b.get(i, j));
             }
         }

         return result;
     }


    private static Object timesScalar(double scalar, Object obj){
        if(obj instanceof Matrix matrix){
            int rows = matrix.getRows();
            int cols = matrix.getColumns();
            Matrix result = new Matrix(rows, cols, new double[rows * cols]);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result.set(i, j, scalar * matrix.get(i, j));
                }
            }


           return result;
        }else if( obj instanceof Vector vector){
            int dim = vector.getDim();
            Vector result = new Vector(dim, new double[dim]);
            for (int i = 0; i < dim; i++){
                result.set(i, scalar * vector.get(i));
            }

            return result;
        }

        throw  new IllegalArgumentException("Escalar pode ser multiplicado apenas por Matrix e Vector");
    }


    public static Matrix dot(Matrix a, Matrix b){
        int rowsA = a.getRows();
        int colsA = a.getColumns();
        int rowsB = b.getRows();
        int colsB = b.getColumns();

        if(colsA != rowsB){
            throw new IllegalArgumentException("Multiplicação não pode ser realizada por conta das dimensões");
        }

        Matrix result = new Matrix(rowsA, colsB, new double[rowsA * colsB]);
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                double value = 0;
                for (int t = 0; t < colsA; t++){
                    value += a.get(i, t) * b.get(t, j);
                }

                result.set(i, j, value);
            }
        }


        return result;
    }


    public static Matrix gauss(Matrix a){
        int rows = a.getRows();
        int cols = a.getColumns();
        Matrix result = new Matrix(a.getRows(), a.getColumns(), new double[rows * cols]);
        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getColumns(); j++) {
                result.set(i, j, a.get(i, j));
            }
        }


        for (int j = 0; j < rows; j++) {
            int maxRow = j;
            for (int i = j + 1; i < rows; i++) {
                if (Math.abs(result.get(i, j)) > Math.abs(result.get(maxRow, j))) {
                    maxRow = i;
                }
            }

            // Troca as linhas j e maxRow
            if (maxRow != j) {
                for (int c = 0; c < cols; c++) {
                    double temp = result.get(j, c);
                    result.set(j, c, result.get(maxRow, c));
                    result.set(maxRow, c, temp);
                }
            }

            if (result.get(j, j) == 0) {
                continue;
            }

            for (int i = j + 1; i < rows; i++){
                double k = - result.get(i,j) / result.get(j, j); // k = -A(i, j) / A(j, j)
                for (int c = j; c < result.getColumns(); c++){
                    double elementLine = result.get(i, c);
                    result.set(i, c, elementLine + k * result.get(j, c));
                }
            }
        }
        return result;
    }


    public static Matrix solve(Matrix a){
        int rows = a.getRows();
        int cols = a.getColumns();
        Matrix result = new Matrix(a.getRows(), a.getColumns(), new double[rows * cols]);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.set(i, j, a.get(i, j));
            }
        }

        int postExpandedMatrix = 0;
        int postConciousMatrix = 0;
        int n = 0;
        Matrix scaleMatrix = LinearAlgebra.gauss(result);

        for(int row = 0; row < rows; row++){
            double sumRowExpaned = 0;
            double sumRowConcious = 0;
            for(int col = 0; col < cols; col++){

                // soma as linhas da matriz ampliada
                sumRowExpaned += scaleMatrix.get(row, col);

                // soma as linhas da matriz dos concientes
                if(col < (cols - 1)){
                    sumRowConcious += scaleMatrix.get(row, col);
                }

                // conta a quantidade de incognitas
                if(col == cols - 1){
                    n++;
                }
            }

            if(sumRowExpaned > 0){
                postExpandedMatrix++;
            }

            if(sumRowConcious > 0){
                postConciousMatrix++;
            }
        }


        if(postConciousMatrix == postExpandedMatrix && postConciousMatrix < n ){
            System.out.println("Sistema possui infinitas soluções");
            return null;
        } else if (postExpandedMatrix > postConciousMatrix) {
            System.out.println("Sistema não possui solução");
            return null;
        }

        for(int j = rows - 1; j >= 0; j--){

            double pivot = scaleMatrix.get(j, j);
            for (int c = 0; c < cols; c++) {
                scaleMatrix.set(j, c, Math.abs(scaleMatrix.get(j, c) / pivot));
            }



            for(int i = rows - 1; i >= 0; i--){
                if(scaleMatrix.get(i, j) == 0){
                    continue;
                }

                if(i != j){
                    double k = - scaleMatrix.get(i,j); // k = -A(i, j)
                    for (int c = cols - 1; c > 0; c--){
                        double elementLine = scaleMatrix.get(i, c);
                        scaleMatrix.set(i, c, elementLine + k * scaleMatrix.get(j, c));
                    }
                }
            }
        }



        return scaleMatrix;
    }

}
