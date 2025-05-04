package Matrices;

public interface MatrixIdentity {
   static Matrix generateIdentity(int row, int col){
      Matrix matrix = new Matrix(row, col, new float[row * col]);

      for(int i = 0; i < row; i++){
        matrix.set(i, i, 1);
      }

      return  matrix;
  }

}
