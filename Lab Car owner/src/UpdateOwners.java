import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateOwners extends Container {
    public static JTextArea text;
    private JScrollPane scrollPane;
    private JLabel id;
    private JLabel attributeLabel;
    private JLabel updateLabel;

    private JTextField idText;
    private String[] attributes = {"Name", "Surname", "Brand", "Color", "Number", "Reg.num", "Year of issue"};
    private JComboBox attributeBox;
    private JTextField updateField;
    private JButton updateButton;
    private JButton backButton;

    public UpdateOwners(){
        setSize(500, 450);
        setLayout(null);

        text = new JTextArea();
        text.setBounds(90, 20, 300, 150);
        add(text);

        scrollPane = new JScrollPane(text);
        scrollPane.setBounds(90,20, 300,150);
        add(scrollPane);

        id = new JLabel("Enter id");
        id.setBounds(90, 190, 80, 30);
        add(id);

        idText = new JTextField();
        idText.setBounds(170, 190, 150, 30);
        add(idText);

        attributeLabel = new JLabel("What you want to change?");
        attributeLabel.setBounds(90, 230, 300, 30);
        add(attributeLabel);

        attributeBox = new JComboBox(attributes);
        attributeBox.setBounds(90, 260, 300, 30);
        add(attributeBox);

        updateLabel = new JLabel("enter the changed value ");
        updateLabel.setBounds(90, 300, 300, 30);
        add(updateLabel);

        updateField = new JTextField();
        updateField.setBounds(90, 330, 300, 30);
        add(updateField);

        updateButton = new JButton("UPDATE");
        updateButton.setBounds(90, 370, 145, 30);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                int id = Integer.parseInt(idText.getText());
                String attribute = (String) attributeBox.getSelectedItem();
                String updatedValue = updateField.getText();
                PackageData pd = new PackageData("UPDATE", id, attribute, updatedValue);
                Main.connect(pd);

                idText.setText("");
                updateField.setText("");
            }
        });
        add(updateButton);

        backButton = new JButton("BACK");
        backButton.setBounds(245, 370, 145, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.updateWindow.setVisible(false);
                Main.frame.mainWindow.setVisible(true);
            }
        });
        add(backButton);
    }

}
