import javax.swing.*;
import java.awt.*;

public class TemperatureConverter {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Temperature Converter");

        JLabel title = new JLabel("Temperature Converter");
        title.setHorizontalAlignment(JLabel.CENTER);

        JLabel tempLabel = new JLabel("Enter Temperature:");
        JTextField tempField = new JTextField();

        JLabel fromLabel = new JLabel("From:");
        String[] units = { "Celsius", "Fahrenheit", "Kelvin" };
        JComboBox<String> fromBox = new JComboBox<>(units);

        JLabel toLabel = new JLabel("To:");
        JComboBox<String> toBox = new JComboBox<>(units);

        JButton convertButton = new JButton("Convert");

        JLabel resultLabel = new JLabel("Result: ");
        resultLabel.setHorizontalAlignment(JLabel.CENTER);

        convertButton.addActionListener(e -> {

            try {

                double temp = Double.parseDouble(tempField.getText());

                String from = (String) fromBox.getSelectedItem();
                String to = (String) toBox.getSelectedItem();

                double celsius;

                // Convert to Celsius
                if (from.equals("Celsius")) {
                    celsius = temp;
                } else if (from.equals("Fahrenheit")) {
                    celsius = (temp - 32) * 5 / 9;
                } else {
                    celsius = temp - 273.15;
                }

                double result;

                // Convert Celsius to required unit
                if (to.equals("Celsius")) {
                    result = celsius;
                } else if (to.equals("Fahrenheit")) {
                    result = (celsius * 9 / 5) + 32;
                } else {
                    result = celsius + 273.15;
                }

                resultLabel.setText(
                        String.format("Result: %.2f %s", result, to));

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter a valid temperature!",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));

        panel.add(title);
        panel.add(new JLabel(""));

        panel.add(tempLabel);
        panel.add(tempField);

        panel.add(fromLabel);
        panel.add(fromBox);

        panel.add(toLabel);
        panel.add(toBox);

        panel.add(new JLabel(""));
        panel.add(convertButton);

        panel.add(new JLabel(""));
        panel.add(resultLabel);

        frame.add(panel);

        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
