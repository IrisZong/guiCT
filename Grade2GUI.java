import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Iris zong 2023-5-25
//calculate act and sat score and conmpare
public class Grade2GUI {

    private JFrame frame;
    private JComboBox<String> examComboBox;
    private JTextField s1MathField;
    private JTextField s1CriticalReadingField;
    private JTextField s1WritingField;
    private JTextField s1EnglishField;
    private JTextField s1MathFieldACT;
    private JTextField s1ReadingField;
    private JTextField s1ScienceField;
    private JTextField s1OverallGPAField;
    private JTextField s1MaxGPAField;
    private JTextField s1TranscriptMultiplierField;
    private JTextField s2MathField;
    private JTextField s2CriticalReadingField;
    private JTextField s2WritingField;
    private JTextField s2EnglishField;
    private JTextField s2MathFieldACT;
    private JTextField s2ReadingField;
    private JTextField s2ScienceField;
    private JTextField s2OverallGPAField;
    private JTextField s2MaxGPAField;
    private JTextField s2TranscriptMultiplierField;
    private JTextArea resultArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Grade2GUI().createAndShowGUI();
            }
        });
    }

    public void createAndShowGUI() {
        frame = new JFrame("Grade2 Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(23, 2));
        inputPanel.add(new JLabel("Choose Exam Type:"));
        examComboBox = new JComboBox<>(new String[]{"SAT", "ACT"});
        inputPanel.add(examComboBox);

        // SAT input fields
        inputPanel.add(new JLabel("SAT Math:"));
        s1MathField = new JTextField();
        inputPanel.add(s1MathField);
        inputPanel.add(new JLabel("SAT Critical Reading:"));
        s1CriticalReadingField = new JTextField();
        inputPanel.add(s1CriticalReadingField);
        inputPanel.add(new JLabel("SAT Writing:"));
        s1WritingField = new JTextField();
        inputPanel.add(s1WritingField);

        // ACT input fields
        inputPanel.add(new JLabel("ACT English:"));
        s1EnglishField = new JTextField();
        inputPanel.add(s1EnglishField);
        inputPanel.add(new JLabel("ACT Math:"));
        s1MathFieldACT = new JTextField();
        inputPanel.add(s1MathFieldACT);
        inputPanel.add(new JLabel("ACT Reading:"));
        s1ReadingField = new JTextField();
        inputPanel.add(s1ReadingField);
        inputPanel.add(new JLabel("ACT Science:"));
        s1ScienceField = new JTextField();
        inputPanel.add(s1ScienceField);

        // GPA input fields
        inputPanel.add(new JLabel("Student 1 Overall GPA:"));
        s1OverallGPAField = new JTextField();
        inputPanel.add(s1OverallGPAField);
        inputPanel.add(new JLabel("Student 1 Max GPA:"));
        s1MaxGPAField = new JTextField();
        inputPanel.add(s1MaxGPAField);
        inputPanel.add(new JLabel("Student 1 Transcript Multiplier:"));
        s1TranscriptMultiplierField = new JTextField();
        inputPanel.add(s1TranscriptMultiplierField);

        // Separator
        inputPanel.add(new JSeparator());
        inputPanel.add(new JSeparator());

        // SAT input fields for student 2
        inputPanel.add(new JLabel("SAT Math:"));
        s2MathField = new JTextField();
        inputPanel.add(s2MathField);
        inputPanel.add(new JLabel("SAT Critical Reading:"));
        s2CriticalReadingField = new JTextField();
        inputPanel.add(s2CriticalReadingField);
        inputPanel.add(new JLabel("SAT Writing:"));
        s2WritingField = new JTextField();
        inputPanel.add(s2WritingField);

        // ACT input fields for student 2
        inputPanel.add(new JLabel("ACT English:"));
        s2EnglishField = new JTextField();
        inputPanel.add(s2EnglishField);
        inputPanel.add(new JLabel("ACT Math:"));
        s2MathFieldACT = new JTextField();
        inputPanel.add(s2MathFieldACT);
        inputPanel.add(new JLabel("ACT Reading:"));
        s2ReadingField = new JTextField();
        inputPanel.add(s2ReadingField);
        inputPanel.add(new JLabel("ACT Science:"));
        s2ScienceField = new JTextField();
        inputPanel.add(s2ScienceField);

        // GPA input fields for student 2
        inputPanel.add(new JLabel("Student 2 Overall GPA:"));
        s2OverallGPAField = new JTextField();
        inputPanel.add(s2OverallGPAField);
        inputPanel.add(new JLabel("Student 2 Max GPA:"));
        s2MaxGPAField = new JTextField();
        inputPanel.add(s2MaxGPAField);
        inputPanel.add(new JLabel("Student 2 Transcript Multiplier:"));
        s2TranscriptMultiplierField = new JTextField();
        inputPanel.add(s2TranscriptMultiplierField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);

        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private void calculateGrade() {
        try {
            String examType = (String) examComboBox.getSelectedItem();

            // Student 1 scores
            double s1Exam;
            double s1GPA;

            if (examType.equals("SAT")) {
                double s1Math = Double.parseDouble(s1MathField.getText());
                double s1CriticalReading = Double.parseDouble(s1CriticalReadingField.getText());
                double s1Writing = Double.parseDouble(s1WritingField.getText());

                s1Exam = calculateSatExamScore(s1Math, s1CriticalReading, s1Writing);
            } else {
                double s1English = Double.parseDouble(s1EnglishField.getText());
                double s1MathACT = Double.parseDouble(s1MathFieldACT.getText());
                double s1Reading = Double.parseDouble(s1ReadingField.getText());
                double s1Science = Double.parseDouble(s1ScienceField.getText());

                s1Exam = calculateActExamScore(s1English, s1MathACT, s1Reading, s1Science);
            }

            double s1OverallGPA = Double.parseDouble(s1OverallGPAField.getText());
            double s1MaxGPA = Double.parseDouble(s1MaxGPAField.getText());
            double s1TranscriptMultiplier = Double.parseDouble(s1TranscriptMultiplierField.getText());

            s1GPA = calculateGpaInfo(s1OverallGPA, s1MaxGPA, s1TranscriptMultiplier);

            // Student 2 scores
            double s2Exam;
            double s2GPA;

            if (examType.equals("SAT")) {
                double s2Math = Double.parseDouble(s2MathField.getText());
                double s2CriticalReading = Double.parseDouble(s2CriticalReadingField.getText());
                double s2Writing = Double.parseDouble(s2WritingField.getText());

                s2Exam = calculateSatExamScore(s2Math, s2CriticalReading, s2Writing);
            } else {
                double s2English = Double.parseDouble(s2EnglishField.getText());
                double s2MathACT = Double.parseDouble(s2MathFieldACT.getText());
                double s2Reading = Double.parseDouble(s2ReadingField.getText());
                double s2Science = Double.parseDouble(s2ScienceField.getText());

                s2Exam = calculateActExamScore(s2English, s2MathACT, s2Reading, s2Science);
            }

            double s2OverallGPA = Double.parseDouble(s2OverallGPAField.getText());
            double s2MaxGPA = Double.parseDouble(s2MaxGPAField.getText());
            double s2TranscriptMultiplier = Double.parseDouble(s2TranscriptMultiplierField.getText());

            s2GPA = calculateGpaInfo(s2OverallGPA, s2MaxGPA, s2TranscriptMultiplier);

            double overallScore1 = s1Exam + s1GPA;
            double overallScore2 = s2Exam + s2GPA;

            String result = "First applicant overall score: " + overallScore1
                    + "\nSecond applicant overall score: " + overallScore2 + "\n";

            if (overallScore1 > overallScore2) {
                result += "The first applicant seems to be better";
            } else if (overallScore1 < overallScore2) {
                result += "The second applicant seems to be better";
            } else {
                result += "The two applicants seem to be equal";
            }

            resultArea.setText(result);
        } catch (NumberFormatException ex) {
            resultArea.setText("Invalid input. Please enter numeric values.");
        }
    }

    private double calculateSatExamScore(double math, double criticalReading, double writing) {
        return (math * 2 + criticalReading + writing) / 32;
    }

    private double calculateActExamScore(double english, double math, double reading, double science) {
        return (english * 2 + math + reading + science) / 1.8;
    }

    private double calculateGpaInfo(double overallGPA, double maxGPA, double transcriptMultiplier) {
        return (overallGPA / maxGPA * 100 * transcriptMultiplier);
    }
}
