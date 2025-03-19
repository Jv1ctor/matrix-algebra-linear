public class LinearAlgebra {
    // Metodo para transpor uma matriz. A transposição troca as linhas pelas colunas.
    public static Matrix transpose(Matrix a) {
        Matrix result = new Matrix(a.getColumns(), a.getRows(), new float [a.getColumns() * a.getRows()]);

        // Percorre a matriz e troca os índices para fazer a transposição
        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getColumns(); j++) {
                result.set(j, i, a.get(i, j));
            }
        }
        return result;
    }

    // Metodo para somar duas matrizes.
    public static Matrix sum(Matrix a, Matrix b) {
        if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
            System.out.println("Erro: As matrizes devem ter as mesmas dimensões.");
            return null; // Ou qualquer outro valor que indique erro
        }

        Matrix result = new Matrix(a.getRows(), a.getColumns(), new float [a.getRows() * a.getColumns()]);

        // Percorre cada elemento da matriz e soma os valores correspondentes
        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getColumns(); j++) {
                result.set(i, j, a.get(i, j) + b.get(i, j));
            }
        }
        return result;




    }
