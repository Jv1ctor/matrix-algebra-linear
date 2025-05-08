import Linear.Transforms.Rotation;
import Linear.Transforms.Shearing;
import Linear.Transforms.Translate;
import Matrices.Matrix;
import Vectors.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector2d = new Vector(2, new float[]{1, 2});
        System.out.println("Vetor 2d: " +"\n"+vector2d);

        Vector resultTranslate2d = Translate.translate2D(vector2d, 5, 6);
        Vector resultRotation2d = Rotation.rotation2D(vector2d, 90);
        Vector resultShearing2d = Shearing.shearing2D(vector2d, 1.5f, 2.5f);

        Vector vector3d = new Vector(3, new float[]{1, 2, 3});
        System.out.println("Vetor 3d: " +"\n"+vector3d);

        Vector resultTranslate3d = Translate.translate3D(vector3d, 5, 6, 7);
        Vector resultRotation3dX = Rotation.rotation3DX(vector3d, 60);
        Vector resultRotation3dY = Rotation.rotation3DY(vector3d, 60);
        Vector resultRotation3dZ = Rotation.rotation3DZ(vector3d, 60);


        System.out.println("Translate 2D: " + resultTranslate2d);
        System.out.println("Translate 3D: " + resultTranslate3d);
        System.out.println("Rotation 2D:"+ resultRotation2d);
        System.out.println("Rotation 3DX:"+ resultRotation3dX);
        System.out.println("Rotation 3DY:"+ resultRotation3dY);
        System.out.println("Rotation 3DZ:"+ resultRotation3dZ);
        System.out.println("Shearing 2D" + resultShearing2d);
    }


}

