public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] res = new double[a.length];
        for (int i = 0; i < a.length; i++)
            res[i] = a[i] * alpha;
        return res;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] res = new double[a.length];
        for (int i = 0; i < a.length; i++)
            res[i] = a[a.length - 1 - i];
        return res;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] res = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++)
            res[i] = a[i];
        for (int i = 0; i < b.length; i++)
            res[a.length + i] = b[i];
        return res;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int mx = Math.max(a.length, b.length);
        int mn = Math.min(a.length, b.length);
        double[] res = new double[mx];
        for (int i = 0; i < mn; i++)
            res[i] = a[i] + b[i];
        for (int i = mn; i < a.length; i++)
            res[i] = a[i];
        for (int i = mn; i < b.length; i++)
            res[i] = b[i];
        return res;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int n = (int) (a.length / alpha);
        double[] res = new double[n];
        for (int i = 0; i < n; i++)
            res[i] = a[(int) (i * alpha)];
        return res;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] beatbox = amplify(StdAudio.read("beatbox.wav"), 0.5);
        double[] chimes = reverse(StdAudio.read("chimes.wav"));
        double[] harp = changeSpeed(StdAudio.read("harp.wav"), 1.1);
        double[] piano = StdAudio.read("piano.wav");
        double[] silence = StdAudio.read("silence.wav");
        double[] tune = merge(beatbox, silence);
        tune = merge(tune, harp);
        tune = mix(tune, piano);
        tune = merge(tune, chimes);
        StdAudio.play(tune);
    }
}
