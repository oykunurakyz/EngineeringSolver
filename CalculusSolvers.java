public class CalculusSolvers {
    public static String format(double value) {
        return String.format("%.2f", value);
    }
}

// 1. Power Rule
class Calc01 extends Problem {
    public String getQuestion() {
        return "1. Power Rule: Find the integral of f(x) = xⁿ. Example: n=3.";
    }

    public String[] getLabels() {
        return new String[] { "Power (n):" };
    }

    public String solve(double... p) {
        int n = (int) p[0];
        int nextN = n + 1;
        String pChar = (nextN == 2) ? "²" : (nextN == 3) ? "³" : (nextN == 4) ? "⁴" : "^" + nextN;
        return "Step 1: Formula ∫xⁿ dx = (xⁿ⁺¹)/(n+1) + C\n" +
                "Step 2: Substitute n=" + n + " -> (x" + pChar + ") / " + nextN + "\n" +
                "Result: x" + pChar + " / " + nextN + " + C";
    }
}

// 2. Integration of Sine Functions
class Calc02 extends Problem {
    public String getQuestion() {
        return "2. Trigonometric: Find the integral of f(x) = sin(ax). Example: a=2.";
    }

    public String[] getLabels() {
        return new String[] { "Constant (a):" };
    }

    public String solve(double... p) {
        double a = p[0];
        return "Step 1: Formula ∫sin(ax) dx = -(1/a)cos(ax) + C\n" +
                "Step 2: a = " + a + " -> -(1/" + a + ")cos(" + a + "x)\n" +
                "Result: -" + CalculusSolvers.format(1 / a) + "cos(" + a + "x) + C";
    }
}

// 3. Area Under Curve
class Calc03 extends Problem {
    public String getQuestion() {
        return "3. Area: Area under x² from a to b. Example: a=0, b=2.";
    }

    public String[] getLabels() {
        return new String[] { "Start (a):", "End (b):" };
    }

    public String solve(double... p) {
        double res = (Math.pow(p[1], 3) / 3) - (Math.pow(p[0], 3) / 3);
        return "Step 1: Integral of x² is x³ / 3\n" +
                "Step 2: Evaluate [x³ / 3] from " + p[0] + " to " + p[1] + "\n" +
                "Result: " + CalculusSolvers.format(res);
    }
}

// 4. Surface Area: Rotation of y=x around x-axis from 0 to b.
class Calc04 extends Problem {
    public String getQuestion() {
        return "4. Surface Area: Area of y = x rotated around x-axis from 0 to b. Example: b=3.";
    }

    public String[] getLabels() {
        return new String[] { "Limit (b):" };
    }

    public String solve(double... p) {
        double b = p[0];
        // Formula: S = π * b² * √2
        double res = Math.PI * Math.pow(b, 2) * Math.sqrt(2);
        return "Step 1: Formula S = ∫2π * y * √(1 + [y']²) dx\n" +
                "Step 2: Evaluate 2π * ∫x * √2 dx from 0 to " + b + "\n" +
                "Result: " + CalculusSolvers.format(res) + " square units";
    }
}
// 5. Arc Length
class Calc05 extends Problem {
    public String getQuestion() {
        return "5. Arc Length: y = mx from 0 to x. Example: m=1, x=5.";
    }

    public String[] getLabels() {
        return new String[] { "Slope (m):", "x boundary:" };
    }

    public String solve(double... p) {
        double res = p[1] * Math.sqrt(1 + p[0] * p[0]);
        return "Step 1: L = ∫√(1 + [f'(x)]²) dx\n" +
                "Result: " + CalculusSolvers.format(res);
    }
}

// 6. Integration by Parts
class Calc06 extends Problem {
    public String getQuestion() {
        return "6. Parts: Integral of x * eᵃˣ. Example: a=1.";
    }

    public String[] getLabels() {
        return new String[] { "a:" };
    }

    public String solve(double... p) {
        return "Step 1: Formula ∫u dv = uv - ∫v du\n" +
                "Result: (e^" + p[0] + "x / " + p[0] + ") * (x - 1/" + p[0] + ") + C";
    }
}

// 7. Improper Integral
class Calc07 extends Problem {
    public String getQuestion() {
        return "7. Improper: Integral of 1/xᵖ from 1 to ∞. Example: p=2.";
    }

    public String[] getLabels() {
        return new String[] { "Power (p):" };
    }

    public String solve(double... p) {
        if (p[0] <= 1)
            return "Step 1: Convergence check (p > 1)\nResult: Divergent";
        return "Result: " + CalculusSolvers.format(1 / (p[0] - 1));
    }
}

// 8. Geometric Series
class Calc08 extends Problem {
    public String getQuestion() {
        return "8. Geo Series: Sum of a * rⁿ from 0 to ∞.";
    }

    public String[] getLabels() {
        return new String[] { "a:", "r:" };
    }

    public String solve(double... p) {
        if (Math.abs(p[1]) >= 1)
            return "Step 1: |r| must be < 1\nResult: Divergent";
        return "Result: " + CalculusSolvers.format(p[0] / (1 - p[1]));
    }
}

// 9. Taylor Series
class Calc09 extends Problem {
    public String getQuestion() {
        return "9. Taylor: eˣ terms up to degree n at x=0.";
    }

    public String[] getLabels() {
        return new String[] { "n:" };
    }

    public String solve(double... p) {
        return "Step 1: Σ (xᵏ / k!)\nResult: 1 + x + x²/2! + ... + x^" + (int) p[0] + "/" + (int) p[0] + "!";
    }
}

// 10. Maclaurin sin(x)
class Calc10 extends Problem {
    public String getQuestion() {
        return "10. Maclaurin: First n terms of sin(x).";
    }

    public String[] getLabels() {
        return new String[] { "n:" };
    }

    public String solve(double... p) {
        return "Step 1: sin(x) ≈ x - x³ / 3! + x⁵ / 5!...\nResult: Displayed for " + (int) p[0] + " terms.";
    }
}

// 11. Work
class Calc11 extends Problem {
    public String getQuestion() {
        return "11. Work: Work by F(x) = kx from 0 to d.";
    }

    public String[] getLabels() {
        return new String[] { "k:", "d:" };
    }

    public String solve(double... p) {
        double res = 0.5 * p[0] * p[1] * p[1];
        return "Step 1: W = ∫F(x) dx = ½kd²\nResult: " + CalculusSolvers.format(res) + " J";
    }
}

// 12. Average Value
class Calc12 extends Problem {
    public String getQuestion() {
        return "12. Avg Value: f(x) = x² on [a, b].";
    }

    public String[] getLabels() {
        return new String[] { "a:", "b:" };
    }

    public String solve(double... p) {
        double integral = (Math.pow(p[1], 3) / 3) - (Math.pow(p[0], 3) / 3);
        return "Step 1: [1/(b-a)] * ∫x² dx\nResult: " + CalculusSolvers.format(integral / (p[1] - p[0]));
    }
}

// 13. Polar Area
class Calc13 extends Problem {
    public String getQuestion() {
        return "13. Polar Area: Area of r = a.";
    }

    public String[] getLabels() {
        return new String[] { "a:" };
    }

    public String solve(double... p) {
        return "Step 1: A = π * r²\nResult: " + CalculusSolvers.format(Math.PI * p[0] * p[0]);
    }
}

// 14. Log Integration
class Calc14 extends Problem {
    public String getQuestion() {
        return "14. Log Int: Integral of 1/(ax+b).";
    }

    public String[] getLabels() {
        return new String[] { "a:", "b:" };
    }

    public String solve(double... p) {
        return "Step 1: (1/a) * ln|ax+b| + C\nResult: (1/" + p[0] + ") * ln|" + p[0] + "x + " + p[1] + "| + C";
    }
}

// 15. Convergence Radius
class Calc15 extends Problem {
    public String getQuestion() {
        return "15. Radius: Radius of Σ(cⁿ * xⁿ).";
    }

    public String[] getLabels() {
        return new String[] { "c:" };
    }

    public String solve(double... p) {
        return "Step 1: R = 1 / c\nResult: " + CalculusSolvers.format(1 / p[0]);
    }
}