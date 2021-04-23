import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddOwner extends Container {
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel brandLabel;
    private JLabel colorLabel;
    private JLabel numberLabel;
    private JLabel regNumLabel;
    private JLabel yearOfIssueLabel;

    private JTextField nameText;
    private JTextField surnameText;
    private String[] brands = {"Toyota", "Audi", "Bugatti", "Chevrolet", "Lamborghini", "Tesla"};
    private JComboBox brandBox;
    private String[] colors = {"white", "blue","yellow", "pink", "purple", "orange", "green", "black", "red"};
    private JComboBox colorBox;
    private JTextField numberText;
    private JTextField regNumText;
    private JTextField yearOfIssieText;

    private JButton addButton;
    private JButton backButton;

    public AddOwner(){
        setSize(500, 450);
        setLayout(null);

        //name
        nameLabel = new JLabel("NAME ");
        nameLabel.setBounds(90, 30, 80, 30);
        add(nameLabel);

        nameText = new JTextField();
        nameText.setBounds(170, 30, 150, 30);
        add(nameText);

        //surname
        surnameLabel = new JLabel("SURNAME ");
        surnameLabel.setBounds(90, 70, 80, 30);
        add(surnameLabel);

        surnameText = new JTextField();
        surnameText.setBounds(170, 70, 150, 30);
        add(surnameText);

        //brand
        brandLabel = new JLabel("BRAND ");
        brandLabel.setBounds(90, 110, 80, 30);
        add(brandLabel);

        brandBox = new JComboBox(brands);
        brandBox.setBounds(170, 110, 150, 30);
        add(brandBox);

        //color
        colorLabel = new JLabel("COLOR ");
        colorLabel.setBounds(90, 150, 80, 30);
        add(colorLabel);

        colorBox = new JComboBox(colors);
        colorBox.setBounds(170, 150, 150, 30);
        add(colorBox);

        //number
        numberLabel = new JLabel("NUMBER ");
        numberLabel.setBounds(90, 190, 80, 30);
        add(numberLabel);

        numberText = new JTextField();
        numberText.setBounds(170, 190, 150, 30);
        add(numberText);

        //regNum
        regNumLabel = new JLabel("REGISTRATION NUMBER ");
        regNumLabel.setBounds(90, 230, 80, 30);
        add(regNumLabel);

        regNumText = new JTextField();
        regNumText.setBounds(170, 230, 150, 30);
        add(regNumText);

        //yearOfIssue
        yearOfIssueLabel = new JLabel("YEAR OF ISSUE ");
        yearOfIssueLabel.setBounds(90, 270, 80, 30);
        add(yearOfIssueLabel);

        yearOfIssieText = new JTextField();
        yearOfIssieText.setBounds(170, 270, 150, 30);
        add(yearOfIssieText);

        addButton = new JButton("ADD");
        addButton.setBounds(90, 310, 230, 30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String surname = surnameText.getText();
                String brand = (String) brandBox.getSelectedItem();
                String color = (String) colorBox.getSelectedItem();
                String number = numberText.getText();
                String regNum = regNumText.getText();
                int year = Integer.parseInt(yearOfIssieText.getText());

                CarOwner carOwner = new CarOwner(null, name, surname, brand, color, number, regNum, year);

                PackageData pd = new PackageData("ADD", carOwner);
                Main.connect(pd);

                nameText.setText("");//очищает поле
                surnameText.setText("");
                numberText.setText("");
                regNumText.setText("");
                yearOfIssieText.setText("");
            }
        });
        add(addButton);

        //backButt
        backButton = new JButton("BACK");
        backButton.setBounds(90, 350, 230, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addWindow.setVisible(false);
                Main.frame.mainWindow.setVisible(true);
            }
        });
        add(backButton);
    }

}
