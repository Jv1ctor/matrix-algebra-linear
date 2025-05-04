public class LinearTransform implements HomogeneousTransform, MatrixIdentity {

    public static Vector translate2D(Vector vector, double dx, double dy){
        Matrix inputMatrix = HomogeneousTransform.toHomogeneousVector(vector, 1);
        Matrix identity = Matrix.identity(2, 2);

        Matrix hTranslateMatrix = HomogeneousTransform.toHomogenousOperatorLinear(identity, new Vector(2, new double[]{dx, dy}));
        Matrix result = LinearAlgebra.dot(hTranslateMatrix, inputMatrix);

        return HomogeneousTransform.fromHomogenousVector(result);
    }

    public static Vector translate3D(Vector vector, double dx, double dy, double dz){
        Matrix inputMatrix = HomogeneousTransform.toHomogeneousVector(vector, 1);
        Matrix identity = Matrix.identity(3, 3);
        Matrix hTranslateMatrix = HomogeneousTransform.toHomogenousOperatorLinear(identity, new Vector(3, new double[]{dx, dy, dz}));

        Matrix result = LinearAlgebra.dot(hTranslateMatrix, inputMatrix);

        return HomogeneousTransform.fromHomogenousVector(result);
    }


}
