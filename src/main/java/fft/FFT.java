package fft;

import org.jtransforms.fft.DoubleFFT_2D;

public class FFT {

       public static void main(String[] args) {
        new FFT();
    }

    public FFT() {
        int rg = 200, col = 200;
        DoubleFFT_2D dFFT2D = new DoubleFFT_2D(rg, col);
        int XM = 100, YM = 100;
        double[][] F = new double[100][100];
        for (int x = 0; x < XM; x += 1) {
            for (int y = 0; y < YM; y += 1) {
                double r = Math.pow(Math.pow(x, 2) + Math.pow(y, 2), 0.5);
                F[x][y] = 1 / r;
            }
        }

        dFFT2D.complexForward(F);
    }

}
