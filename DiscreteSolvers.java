public class DiscreteSolvers {
    public static double factorial(int n) {
        double f = 1;
        for (int i = 2; i <= n; i++)
            f *= i;
        return f;
    }
}

class Disc01 extends Problem {
    public String getQuestion() {
        return "1. Permutation: Calculate P(n, r). Example: n=5, r=2.";
    }

    public String[] getLabels() {
        return new String[] { "n:", "r:" };
    }

    public String solve(double... p) {
        double res = DiscreteSolvers.factorial((int) p[0]) / DiscreteSolvers.factorial((int) (p[0] - p[1]));
        return "Step 1: Formula P(n, r) = n! / (n-r)!\nStep 2: Calculate " + (int) p[0] + "! / " + (int) (p[0] - p[1])
                + "!\nResult: " + (int) res;
    }
}

class Disc02 extends Problem {
    public String getQuestion() {
        return "2. Combination: Calculate C(n, r). Example: n=5, r=2.";
    }

    public String[] getLabels() {
        return new String[] { "n:", "r:" };
    }

    public String solve(double... p) {
        double res = DiscreteSolvers.factorial((int) p[0])
                / (DiscreteSolvers.factorial((int) p[1]) * DiscreteSolvers.factorial((int) (p[0] - p[1])));
        return "Step 1: Formula C(n, r) = n! / (r! * (n-r)!)\nResult: " + (int) res;
    }
}

class Disc03 extends Problem {
    public String getQuestion() {
        return "3. Inclusion-Exclusion: Find |A ∩ B|.";
    }

    public String[] getLabels() {
        return new String[] { "|A|:", "|B|:", "|A ∪ B|:" };
    }

    public String solve(double... p) {
        return "Step 1: |A| + |B| - |A ∪ B|\nResult: " + (int) (p[0] + p[1] - p[2]);
    }
}

class Disc04 extends Problem {
    public String getQuestion() {
        return "4. Power Set: Size of P(A) for |A|=n.";
    }

    public String[] getLabels() {
        return new String[] { "n:" };
    }

    public String solve(double... p) {
        return "Step 1: 2^n\nResult: " + (int) Math.pow(2, p[0]);
    }
}

class Disc05 extends Problem {
    public String getQuestion() {
        return "5. Logic: p AND q (1=T, 0=F).";
    }

    public String[] getLabels() {
        return new String[] { "p:", "q:" };
    }

    public String solve(double... p) {
        return "Step 1: Check p==1 && q==1\nResult: " + (p[0] == 1 && p[1] == 1);
    }
}

class Disc06 extends Problem {
    public String getQuestion() {
        return "6. Pigeonhole: n pigeons, m holes.";
    }

    public String[] getLabels() {
        return new String[] { "n:", "m:" };
    }

    public String solve(double... p) {
        return "Step 1: ceil(n/m)\nResult: " + (int) Math.ceil(p[0] / p[1]);
    }
}

class Disc07 extends Problem {
    public String getQuestion() {
        return "7. Summation: Sum of 1..n.";
    }

    public String[] getLabels() {
        return new String[] { "n:" };
    }

    public String solve(double... p) {
        return "Step 1: n(n+1)/2\nResult: " + (int) (p[0] * (p[0] + 1) / 2);
    }
}

class Disc08 extends Problem {
    public String getQuestion() {
        return "8. Handshake: n people shake hands.";
    }

    public String[] getLabels() {
        return new String[] { "n:" };
    }

    public String solve(double... p) {
        return "Step 1: n(n-1)/2\nResult: " + (int) (p[0] * (p[0] - 1) / 2);
    }
}

class Disc09 extends Problem {
    public String getQuestion() {
        return "9. Modulo: a mod m.";
    }

    public String[] getLabels() {
        return new String[] { "a:", "m:" };
    }

    public String solve(double... p) {
        return "Step 1: a % m\nResult: " + (int) (p[0] % p[1]);
    }
}

class Disc10 extends Problem {
    public String getQuestion() {
        return "10. Relations: Total relations from A to B.";
    }

    public String[] getLabels() {
        return new String[] { "|A|:", "|B|:" };
    }

    public String solve(double... p) {
        return "Step 1: 2^(n*m)\nResult: 2^" + (int) (p[0] * p[1]);
    }
}