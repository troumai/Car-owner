import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListOwners extends Container {
    public static JTextArea text;
    private JButton listByYearButton;
    private JButton listByWhiteToyotaButton;
    private JButton listByTeslaButton;
    private JButton backButton;
    private JScrollPane scrollPane;

    public ListOwners(){
        setSize(500, 450);
        setLayout(null);

        text = new JTextArea();
        text.setBounds(20, 20, 410, 280);
        add(text);

        scrollPane = new JScrollPane(text);
        scrollPane.setBounds(20,20, 410,280);
        add(scrollPane);

        listByYearButton = new JButton("BY YEAR");
        listByYearButton.setBounds(75, 310, 160, 30);
        listByYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                PackageData pd = new PackageData("LIST BY YEAR");
                Main.connect(pd);
            }
        });
        add(listByYearButton);

        listByWhiteToyotaButton = new JButton("ALL WHITE TOYOTA");
        listByWhiteToyotaButton.setBounds(245, 310, 160, 30);
        listByWhiteToyotaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                PackageData pd = new PackageData("LIST ALL WHITE TOYOTA");
                Main.connect(pd);
            }
        });
        add(listByWhiteToyotaButton);

        listByTeslaButton = new JButton("TESLA 2019-2020");
        listByTeslaButton.setBounds(75, 350, 160, 30);
        listByTeslaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                PackageData pd = new PackageData("LIST TESLA");
                Main.connect(pd);
            }
        });
        add(listByTeslaButton);

        backButton = new JButton("BACK");
        backButton.setBounds(245, 350, 160, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.listWindow.setVisible(false);
                Main.frame.mainWindow.setVisible(true);
            }
        });
        add(backButton);


    }
}
