public class LinearAlgebra {

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


}
