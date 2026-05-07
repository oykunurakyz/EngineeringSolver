public class PhysicsSolvers {
    public static String format(double value, String unit) {
        if (value == 0)
            return "0.00 " + unit;
        if (Math.abs(value) < 0.001)
            return String.format("%.6f %s", value, unit);
        if (Math.abs(value) < 0.1)
            return String.format("%.4f %s", value, unit);
        return String.format("%.2f %s", value, unit);
    }
}

// 1. Coulomb's Law
class Physics01 extends Problem {
    public String getQuestion() {
        return "1. Coulomb's Law: Two charges (q1=2C, q2=5C) are 3m apart. Find force.";
    }

    public String[] getLabels() {
        return new String[] { "q1 (C):", "q2 (C):", "r (m):" };
    }

    public String solve(double... p) {
        double res = (8.99e9 * Math.abs(p[0] * p[1])) / (p[2] * p[2]);
        return "Step 1: Formula F = (k * |q1 * q2|) / r²\nStep 2: F = (8.99e9 * " + p[0] + " * " + p[1] + ") / " + p[2]
                + "²\nResult: " + PhysicsSolvers.format(res, "N");
    }
}

// 2. Electric Field
class Physics02 extends Problem {
    public String getQuestion() {
        return "2. E-Field: Find E at 2m from a 4C charge.";
    }

    public String[] getLabels() {
        return new String[] { "q (C):", "r (m):" };
    }

    public String solve(double... p) {
        double res = (8.99e9 * Math.abs(p[0])) / (p[1] * p[1]);
        return "Step 1: Formula E = (k * |q|) / r²\nResult: " + PhysicsSolvers.format(res, "N/C");
    }
}

// 3. Electric Potential
class Physics03 extends Problem {
    public String getQuestion() {
        return "3. Potential: Potential at 0.5m from 10C charge.";
    }

    public String[] getLabels() {
        return new String[] { "q (C):", "r (m):" };
    }

    public String solve(double... p) {
        double res = (8.99e9 * p[0]) / p[1];
        return "Step 1: Formula V = (k * q) / r\nResult: " + PhysicsSolvers.format(res, "V");
    }
}

// 4. Electric Flux
class Physics04 extends Problem {
    public String getQuestion() {
        return "4. Flux: Flux through A=2m² with E=100 N/C at 30°.";
    }

    public String[] getLabels() {
        return new String[] { "E (N/C):", "A (m²):", "Theta (°):" };
    }

    public String solve(double... p) {
        double res = p[0] * p[1] * Math.cos(Math.toRadians(p[2]));
        return "Step 1: Formula Phi = E * A * cos(θ)\nResult: " + PhysicsSolvers.format(res, "V.m");
    }
}

// 5. Potential Energy
class Physics05 extends Problem {
    public String getQuestion() {
        return "5. Pot. Energy: Energy between q1=1C, q2=1C at 1m.";
    }

    public String[] getLabels() {
        return new String[] { "q1 (C):", "q2 (C):", "r (m):" };
    }

    public String solve(double... p) {
        double res = (8.99e9 * p[0] * p[1]) / p[2];
        return "Step 1: Formula U = (k * q1 * q2) / r\nResult: " + PhysicsSolvers.format(res, "J");
    }
}

// 6. Gauss Law (Sphere)
class Physics06 extends Problem {
    public String getQuestion() {
        return "6. Gauss Sphere: Sphere flux enclosing 4C charge.";
    }

    public String[] getLabels() {
        return new String[] { "Q_enclosed (C):" };
    }

    public String solve(double... p) {
        double res = p[0] / 8.854e-12;
        return "Step 1: Formula Phi = Q / ε₀\nResult: " + PhysicsSolvers.format(res, "V.m");
    }
}

// 7. Gauss Law (Cylinder)
class Physics07 extends Problem {
    public String getQuestion() {
        return "7. Gauss Cyl: Field of line λ=2C/m at 0.1m.";
    }

    public String[] getLabels() {
        return new String[] { "Lambda (C/m):", "r (m):" };
    }

    public String solve(double... p) {
        double res = p[0] / (2 * Math.PI * 8.854e-12 * p[1]);
        return "Step 1: Formula E = λ / (2π*ε₀*r)\nResult: " + PhysicsSolvers.format(res, "N/C");
    }
}

// 8. Gauss Law (Plane)
class Physics08 extends Problem {
    public String getQuestion() {
        return "8. Gauss Plane: Field near sheet with σ=3C/m².";
    }

    public String[] getLabels() {
        return new String[] { "Sigma (C/m²):" };
    }

    public String solve(double... p) {
        double res = p[0] / (2 * 8.854e-12);
        return "Step 1: Formula E = σ / (2*ε₀)\nResult: " + PhysicsSolvers.format(res, "N/C");
    }
}

// 9. Ohm's Law
class Physics09 extends Problem {
    public String getQuestion() {
        return "9. Ohm's Law: Voltage for R=10Ω and I=2A.";
    }

    public String[] getLabels() {
        return new String[] { "Current I (A):", "Resistance R (Ω):" };
    }

    public String solve(double... p) {
        return "Step 1: Formula V = I * R\nResult: " + PhysicsSolvers.format(p[0] * p[1], "V");
    }
}

// 10. Electrical Power
class Physics10 extends Problem {
    public String getQuestion() {
        return "10. Power: Power for V=12V and I=0.5A.";
    }

    public String[] getLabels() {
        return new String[] { "Voltage V (V):", "Current I (A):" };
    }

    public String solve(double... p) {
        return "Step 1: Formula P = V * I\nResult: " + PhysicsSolvers.format(p[0] * p[1], "W");
    }
}

// 11. Resistance (Dinamik Çarpanlı)
class Physics11 extends Problem {
    public String getQuestion() {
        return "11. Resistance: ρ=1.7x10⁻⁸, L=100m, A=1x10⁻⁶.";
    }

    public String[] getLabels() {
        return new String[] { "rho (x 10⁻⁸):", "L (m):", "A (x 10⁻⁶):" };
    }

    public String solve(double... p) {
        double realRho = p[0] * 1e-8;
        double realA = p[2] * 1e-6;
        double res = (realRho * p[1]) / realA;
        return "Step 1: R = (ρ * L) / A\nStep 2: (" + realRho + " * " + p[1] + ") / " + realA + "\nResult: "
                + PhysicsSolvers.format(res, "Ω");
    }
}

// 12. Capacitance (Hassas Hesaplama)
class Physics12 extends Problem {
    public String getQuestion() {
        return "12. Capacitance: Q=0.01C, V=5V. Find C.";
    }

    public String[] getLabels() {
        return new String[] { "Charge Q (C):", "Voltage V (V):" };
    }

    public String solve(double... p) {
        double res = p[0] / p[1];
        return "Step 1: Formula C = Q / V\nStep 2: " + p[0] + " / " + p[1] + "\nResult: "
                + PhysicsSolvers.format(res, "F");
    }
}

// 13. Magnetic Field
class Physics13 extends Problem {
    public String getQuestion() {
        return "13. Mag. Field: B-field at 0.05m from 10A wire.";
    }

    public String[] getLabels() {
        return new String[] { "Current I (A):", "Distance r (m):" };
    }

    public String solve(double... p) {
        double res = (2e-7 * p[0]) / p[1];
        return "Step 1: Formula B = (μ₀ * I) / (2π * r)\nResult: " + PhysicsSolvers.format(res, "T");
    }
}

// 14. Magnetic Force
class Physics14 extends Problem {
    public String getQuestion() {
        return "14. Mag. Force: Force on q=1C, v=20m/s, B=0.5T.";
    }

    public String[] getLabels() {
        return new String[] { "q (C):", "v (m/s):", "B (T):" };
    }

    public String solve(double... p) {
        double res = p[0] * p[1] * p[2];
        return "Step 1: Formula F = q * v * B\nResult: " + PhysicsSolvers.format(res, "N");
    }
}

// 15. Transformer
class Physics15 extends Problem {
    public String getQuestion() {
        return "15. Transformer: V2 if V1=220V, N2=10, N1=100.";
    }

    public String[] getLabels() {
        return new String[] { "V1 (V):", "N2 (Turns):", "N1 (Turns):" };
    }

    public String solve(double... p) {
        double res = (p[0] * p[1]) / p[2];
        return "Step 1: Formula V2 = (V1 * N2) / N1\nResult: " + PhysicsSolvers.format(res, "V");
    }
}