package mathlab;

import org.apache.commons.math3.linear.*;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;

public class MathExperimenting
{
    public static void main(String[] args)
    {
        double[][] matrixData = { {1d,2d,3d}, {2d,5d,3d}};
        RealMatrix m = MatrixUtils.createRealMatrix(matrixData);

        // Δημιουργία Μηδενικού πίνακα από έτοιμα δίνοντας τις επιθυμητές διαστάσεις
        RealMatrix zeroMatrix = MatrixUtils.createRealMatrix(20, 200);

        // Δημιουργία πίνακα τυχαίων τιμών, μπορούμε να το κάνουμε πιο γρήγορα?
        RandomGenerator randomGenerator = new JDKRandomGenerator();
        randomGenerator.setSeed(1);
        for(int i=0 ; i<zeroMatrix.getRowDimension() ; i++)
        {
            for(int j=0 ; j < zeroMatrix.getColumnDimension(); j++)
            {
                zeroMatrix.setEntry(i, j, randomGenerator.nextDouble());
            }
        }

        // Δεν θέλουμε μηδενικά

        zeroMatrix = zeroMatrix.scalarAdd(0.01);

        // Δημιουργία Διαγώνιου Πίνακα
        double[] diag_elems = zeroMatrix.getColumn(0);
        RealMatrix diag = MatrixUtils.createRealDiagonalMatrix(diag_elems);

        double[][] matrixData2 = { {1d,2d}, {2d,5d}, {1d,7d}};
        RealMatrix n = MatrixUtils.createRealMatrix(matrixData2);

        // Πολλαπλασιασμός m.dot(n)
        RealMatrix p = m.multiply(n);
        System.out.println(p.getRowDimension()); // 2
        System.out.println(p.getColumnDimension()); //2
        System.out.println(p.toString());

        // Invert p, using LU and QR decomposition
        RealMatrix pInverse = new LUDecomposition(p).getSolver().getInverse();
        RealMatrix qrInverse = new QRDecomposition(p).getSolver().getInverse();

        // Δημιουργία Sparse Πίνακα,
        // ο πίνακας αυτός μπορεί
        // να χρησιμοποιειθεί ακριβώς όπως οι dense πίνακες
        OpenMapRealMatrix sparse_m =
                new OpenMapRealMatrix(20000, 20000);

        System.out.print(sparse_m.getRowDimension() + " " + sparse_m.getColumnDimension());
    }
}
