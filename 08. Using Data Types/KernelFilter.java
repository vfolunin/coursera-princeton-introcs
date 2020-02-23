import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    private static Picture kernel(Picture picture, double[][] k) {
        Picture res = new Picture(picture.width(), picture.height());
        for (int i = 0; i < res.height(); i++) {
            for (int j = 0; j < res.width(); j++) {
                double r = 0, g = 0, b = 0;
                for (int ki = 0; ki < k.length; ki++) {
                    for (int kj = 0; kj < k.length; kj++) {
                        int pi = (i + (ki - k.length / 2) + picture.height()) % picture.height();
                        int pj = (j + (kj - k.length / 2) + picture.width()) % picture.width();
                        Color c = picture.get(pj, pi);
                        r += c.getRed() * k[ki][kj];
                        g += c.getGreen() * k[ki][kj];
                        b += c.getBlue() * k[ki][kj];
                    }
                }
                r = Math.max(0, Math.min(r, 255));
                g = Math.max(0, Math.min(g, 255));
                b = Math.max(0, Math.min(b, 255));
                Color resC = new Color((int) Math.round(r), (int) Math.round(g),
                                       (int) Math.round(b));
                res.set(j, i, resC);
            }
        }
        return res;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] k = {
                { 1.0 / 16, 2.0 / 16, 1.0 / 16 },
                { 2.0 / 16, 4.0 / 16, 2.0 / 16 },
                { 1.0 / 16, 2.0 / 16, 1.0 / 16 }
        };
        return kernel(picture, k);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] k = {
                { 0, -1, 0 },
                { -1, 5, -1 },
                { 0, -1, 0 }
        };
        return kernel(picture, k);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] k = {
                { -1, -1, -1 },
                { -1, 8, -1 },
                { -1, -1, -1 }
        };
        return kernel(picture, k);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] k = {
                { -2, -1, 0 },
                { -1, 1, 1 },
                { 0, 1, 2 }
        };
        return kernel(picture, k);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] k = new double[9][9];
        for (int i = 0; i < 9; i++) {
            k[i][i] = 1.0 / 9;
        }
        return kernel(picture, k);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture p = new Picture("baboon.png");
        p.show();
        motionBlur(p).show();
    }

}
