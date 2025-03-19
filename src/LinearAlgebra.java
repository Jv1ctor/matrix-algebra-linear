public class LinearAlgebra {

    // Metodo para transpor uma matriz. A transposição troca as linhas pelas colunas.
    public static Matrix transpose(Matrix a) {
        Matrix result = new Matrix(a.getColumns(), a.getRows(), new double[a.getColumns() * a.getRows()]);

        // Percorre a matriz e troca os índices para fazer a transposição
        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getColumns(); j++) {
                result.set(j, i, a.get(i, j));
            }
        }
        return result;
    }

    public static Vector transpose(Vector a) {
        return new Vector(a.getDim(), a.getElements());
    }


    // Metodo para somar duas matrizes.
    public static Matrix sum(Matrix a, Matrix b) {
        if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
            System.out.println("Erro: As matrizes devem ter as mesmas dimensões.");
            return null; // Ou qualquer outro valor que indique erro
        }

        Matrix result = new Matrix(a.getRows(), a.getColumns(), new double[a.getColumns() * a.getRows()]);

        // Percorre cada elemento da matriz e soma os valores correspondentes
        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getColumns(); j++) {
                result.set(i, j, a.get(i, j) + b.get(i, j));
            }
        }
        return result;
    }

    // Metodo para somar dois vetores
    public static Vector sum(Vector a, Vector b) {
        if (a.getDim() != b.getDim()) {
            System.out.println("Erro: Os vetores devem ter o mesmo tamanho.");
            return null; // Ou qualquer outro valor que indique erro
        }

        // Cria um novo vetor para armazenar o resultado
        double[] resultElements = new double[a.getDim()];

        // Percorre os vetores e soma os elementos correspondentes
        for (int i = 0; i < a.getDim(); i++) {
            resultElements[i] = a.getElements()[i] + b.getElements()[i];
        }

        // Cria e retorna o vetor resultante
        return new Vector(a.getDim(), resultElements);
    }
}
