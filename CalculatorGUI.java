import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class CalculatorGUI {
private JTextField output;
private double num1;
private double num2;
private char operator;
    public CalculatorGUI(){}

    //https://stackoverflow.com/questions/4298716/simple-gui-java-calculator
    Boolean BooleanAdd = false;
    Boolean BooleanSubtract = false;
    Boolean BooleanMultiply = false;
    Boolean BooleanDivide = false;

    public void start() {
    EventQueue.invokeLater(() -> {
        try {
            JFrame frame = new JFrame();

            frame.setSize(800,800);
            frame.setTitle("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            try{
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            frame.add(createMainPanel(), BorderLayout.CENTER);
            frame.setVisible(true);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    );
}

    public JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));


        // make top panel
        JPanel topPanel = new JPanel();
        output = new JTextField(12);
        output.setMaximumSize(new Dimension(800,200));
        output.setFont(new Font(Font.SERIF, Font.PLAIN, 84));
        output.setHorizontalAlignment(JTextField.RIGHT);
        output.setEditable(false);
        topPanel.add(output);

        // make bottom panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(0,3));

        //buttons for bottom panel
        JButton clear = new JButton("C");
        JButton delete = new JButton("DEL");
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton zero = new JButton("0");
        JButton decimal = new JButton(".");
        JButton add = new JButton("+");
        JButton subtract = new JButton("-");
        JButton multiply = new JButton("*");
        JButton divide = new JButton("/");
        JButton equals = new JButton("=");


        bottomPanel.add(clear);
        bottomPanel.add(delete);
        bottomPanel.add(one);
        bottomPanel.add(two);
        bottomPanel.add(three);
        bottomPanel.add(four);
        bottomPanel.add(five);
        bottomPanel.add(six);
        bottomPanel.add(seven);
        bottomPanel.add(eight);
        bottomPanel.add(nine);
        bottomPanel.add(zero);
        bottomPanel.add(decimal);
        bottomPanel.add(add);
        bottomPanel.add(subtract);
        bottomPanel.add(multiply);
        bottomPanel.add(divide);
        bottomPanel.add(equals);

        add.addActionListener(e -> {
            operator = '+';
            num1 = Double.parseDouble(output.getText());
            output.setText("");
        });
        subtract.addActionListener(e -> {
            operator = '-';
            num1 = Double.parseDouble(output.getText());
            output.setText("");
        });
        divide.addActionListener(e -> {
            operator = '/';
            num1 = Double.parseDouble(output.getText());
            output.setText("");
        });
        multiply.addActionListener(e -> {
            operator = '*';
            num1 = Double.parseDouble(output.getText());
            output.setText("");
        });
        clear.addActionListener(e -> {
            operator = 'C';
            output.setText(" ");


        });


        equals.addActionListener(e -> {
            num2 = Double.parseDouble(output.getText());
            double result = calculate(num1, num2, operator);
            output.setText(String.valueOf(result));
        });

        ActionListener numberListener = e -> {
            JButton button = (JButton) e.getSource();
            output.setText(output.getText() + button.getText());
        };
        one.addActionListener(numberListener);
        two.addActionListener(numberListener);
        three.addActionListener(numberListener);
        four.addActionListener(numberListener);
        five.addActionListener(numberListener);
        six.addActionListener(numberListener);
        seven.addActionListener(numberListener);
        eight.addActionListener(numberListener);
        nine.addActionListener(numberListener);
        zero.addActionListener(numberListener);
        decimal.addActionListener(numberListener);



        mainPanel.add(topPanel);
        mainPanel.add(bottomPanel);
        return mainPanel;
    }

    private double calculate(double num1, double num2, char operator){
        switch (operator){
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
            case '/':
                if (num2 != 0)
                    return num1/num2;
        }
        return num1;
    }

    }

