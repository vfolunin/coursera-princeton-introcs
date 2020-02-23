public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int res = 0, cur = 0;
        for (int i = 0; i + 3 <= dna.length(); ) {
            if (dna.substring(i, i + 3).equals("CAG")) {
                cur++;
                i += 3;
            }
            else {
                cur = 0;
                i++;
            }
            res = Math.max(res, cur);
        }
        return res;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        return s.replace(" ", "").replace("\t", "").replace("\n", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9)
            return "not human";
        if (maxRepeats <= 35)
            return "normal";
        if (maxRepeats <= 39)
            return "high risk";
        if (maxRepeats <= 180)
            return "Huntington's";
        return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String filename = args[0];
        In file = new In(filename);
        String dna = removeWhitespace(file.readAll());
        int repeats = maxRepeats(dna);
        System.out.println("max repeats = " + repeats);
        System.out.println(diagnose(repeats));
    }

}
