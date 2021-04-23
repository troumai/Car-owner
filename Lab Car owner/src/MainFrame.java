import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainMenu mainWindow;
    public static AddOwner addWindow;
    public static ListOwners listWindow;
    public static UpdateOwners updateWindow;
    public static DeleteOwner deleteWindow;

    public MainFrame(){
        setSize(500, 450);
        setTitle("CAR OWNER APPLICATION");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWindow = new MainMenu();
        setLocation(0,0);
        add(mainWindow);

        addWindow = new AddOwner();
        setLocation(0, 0);
        addWindow.setVisible(false);
        add(addWindow);

        listWindow = new ListOwners();
        setLocation(0, 0);
        listWindow.setVisible(false);
        add(listWindow);

        updateWindow = new UpdateOwners();
        setLocation(0, 0);
        updateWindow.setVisible(false);
        add(updateWindow);

        deleteWindow = new DeleteOwner();
        setLocation(0, 0);
        deleteWindow.setVisible(false);
        add(deleteWindow);
    }
}
