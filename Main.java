import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame {
    private JComboBox<String> subjectList, problemList;
    private ArrayList<Problem> currentProblems = new ArrayList<>();
    private JTextField in1, in2, in3;
    private JLabel lbl1, lbl2, lbl3;
    private JTextArea questionArea, stepArea;

    public Main() {
        setTitle("ALANYA UNIVERSITY - ENGINEERING SOLVER");
        setSize(550, 850);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        subjectList = new JComboBox<>(new String[] { "Physics II", "Calculus II", "Discrete Math" });
        subjectList.addActionListener(e -> switchSubject());
        topPanel.add(new JLabel("Step 1: Select Subject:"));
        topPanel.add(subjectList);
        add(topPanel, BorderLayout.NORTH);

        add(createCorePanel(), BorderLayout.CENTER);
        switchSubject();
    }

    private void switchSubject() {
        currentProblems.clear();
        String selected = (String) subjectList.getSelectedItem();
        if (selected.equals("Physics II"))
            loadPhysics();
        else if (selected.equals("Calculus II"))
            loadCalculus();
        else
            loadDiscrete();

        problemList.removeAllItems();
        for (int i = 0; i < currentProblems.size(); i++) {
            problemList.addItem((i + 1) + ". Problem");
        }
    }

    private void loadPhysics() {
        currentProblems.add(new Physics01());
        currentProblems.add(new Physics02());
        currentProblems.add(new Physics03());
        currentProblems.add(new Physics04());
        currentProblems.add(new Physics05());
        currentProblems.add(new Physics06());
        currentProblems.add(new Physics07());
        currentProblems.add(new Physics08());
        currentProblems.add(new Physics09());
        currentProblems.add(new Physics10());
        currentProblems.add(new Physics11());
        currentProblems.add(new Physics12());
        currentProblems.add(new Physics13());
        currentProblems.add(new Physics14());
        currentProblems.add(new Physics15());
    }

    private void loadCalculus() {
        currentProblems.add(new Calc01());
        currentProblems.add(new Calc02());
        currentProblems.add(new Calc03());
        currentProblems.add(new Calc04());
        currentProblems.add(new Calc05());
        currentProblems.add(new Calc06());
        currentProblems.add(new Calc07());
        currentProblems.add(new Calc08());
        currentProblems.add(new Calc09());
        currentProblems.add(new Calc10());
        currentProblems.add(new Calc11());
        currentProblems.add(new Calc12());
        currentProblems.add(new Calc13());
        currentProblems.add(new Calc14());
        currentProblems.add(new Calc15());
    }

    private void loadDiscrete() {
        currentProblems.add(new Disc01());
        currentProblems.add(new Disc02());
        currentProblems.add(new Disc03());
        currentProblems.add(new Disc04());
        currentProblems.add(new Disc05());
        currentProblems.add(new Disc06());
        currentProblems.add(new Disc07());
        currentProblems.add(new Disc08());
        currentProblems.add(new Disc09());
        currentProblems.add(new Disc10());
    }

    private JPanel createCorePanel() {
        JPanel p = new JPanel(new GridLayout(14, 1, 5, 5));
        p.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));

        problemList = new JComboBox<>();
        questionArea = new JTextArea(3, 20);
        questionArea.setEditable(false);
        stepArea = new JTextArea(6, 20);
        stepArea.setEditable(false);
        in1 = new JTextField();
        in2 = new JTextField();
        in3 = new JTextField();
        lbl1 = new JLabel();
        lbl2 = new JLabel();
        lbl3 = new JLabel();

        problemList.addActionListener(e -> {
            int s = problemList.getSelectedIndex();
            if (s >= 0) {
                Problem prob = currentProblems.get(s);
                questionArea.setText(prob.getQuestion());
                String[] labels = prob.getLabels();
                lbl1.setText(labels.length > 0 ? labels[0] : "");
                in1.setVisible(labels.length > 0);
                lbl2.setText(labels.length > 1 ? labels[1] : "");
                in2.setVisible(labels.length > 1);
                lbl3.setText(labels.length > 2 ? labels[2] : "");
                in3.setVisible(labels.length > 2);
                revalidate();
                repaint();
            }
        });

        JButton solveBtn = new JButton("Solve Step by Step");
        solveBtn.addActionListener(e -> {
            try {
                int s = problemList.getSelectedIndex();
                double v1 = in1.isVisible() && !in1.getText().isEmpty() ? Double.parseDouble(in1.getText()) : 0;
                double v2 = in2.isVisible() && !in2.getText().isEmpty() ? Double.parseDouble(in2.getText()) : 0;
                double v3 = in3.isVisible() && !in3.getText().isEmpty() ? Double.parseDouble(in3.getText()) : 0;
                stepArea.setText(currentProblems.get(s).solve(v1, v2, v3));
            } catch (Exception ex) {
                stepArea.setText("Error: Enter valid numbers.");
            }
        });

        p.add(new JLabel("Step 2: Select Problem:"));
        p.add(problemList);
        p.add(new JLabel("Example Question:"));
        p.add(new JScrollPane(questionArea));
        p.add(lbl1);
        p.add(in1);
        p.add(lbl2);
        p.add(in2);
        p.add(lbl3);
        p.add(in3);
        p.add(solveBtn);
        p.add(new JScrollPane(stepArea));
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}