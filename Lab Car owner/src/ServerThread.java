import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DBManager manager = new DBManager();
            manager.connect();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            PackageData packageData = null;
            while((packageData = (PackageData)inputStream.readObject())!=null){
                if(packageData.getOperationType().equals("ADD")){
                    CarOwner fromClient = packageData.getCarOwner();
                    manager.addOwner(fromClient);
                }
                else if(packageData.getOperationType().equals("LIST BY YEAR")){
                    ArrayList<CarOwner> infoForClient = manager.getListOwners(1);
                    PackageData toClient = new PackageData(infoForClient);
                    outputStream.writeObject(toClient);
                }
                else if(packageData.getOperationType().equals("LIST TESLA")){
                    ArrayList<CarOwner> infoForClient = manager.getListOwners(3);
                    PackageData toClient = new PackageData(infoForClient);
                    outputStream.writeObject(toClient);
                }
                else if(packageData.getOperationType().equals("LIST ALL WHITE TOYOTA")){
                    ArrayList<CarOwner> infoForClient = manager.getListOwners(2);
                    PackageData toClient = new PackageData(infoForClient);
                    outputStream.writeObject(toClient);
                }
                else if(packageData.getOperationType().equals("LIST")){
                    ArrayList<CarOwner> infoForClient = manager.getListOwners(4);
                    PackageData toClient = new PackageData(infoForClient);
                    outputStream.writeObject(toClient);
                }
                else if(packageData.getOperationType().equals("DELETE")){
                    manager.deleteOwner(packageData.getId());
                }
                else if(packageData.getOperationType().equals("UPDATE")){
                    manager.updateOwner(packageData.getId(), packageData.getCategory(), packageData.getText());
                    ArrayList<CarOwner> infoForClient = manager.getListOwners(4);
                    PackageData toClient = new PackageData(infoForClient);
                    outputStream.writeObject(toClient);
                }
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
