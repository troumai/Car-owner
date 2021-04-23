import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static MainFrame frame;
    public static void connect(PackageData pd){
        try {
            Socket socket = new Socket("127.0.0.1", 1111);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            if(pd.getOperationType().equals("ADD")){
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("LIST BY YEAR")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<CarOwner> listFromServer = infoFromServer.getCarOwners();
                String s ="";
                for(int i=0;i<listFromServer.size();i++){
                    s+=listFromServer.get(i)+"\n";
                }
                ListOwners.text.append(s);
            }
            else if(pd.getOperationType().equals("LIST TESLA")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<CarOwner> listFromServer = infoFromServer.getCarOwners();
                String s ="";
                for(int i=0;i<listFromServer.size();i++){
                    s+=listFromServer.get(i)+"\n";
                }
                ListOwners.text.append(s);
            }
            else if(pd.getOperationType().equals("LIST ALL WHITE TOYOTA")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<CarOwner> listFromServer = infoFromServer.getCarOwners();
                String s ="";
                for(int i=0;i<listFromServer.size();i++){
                    s+=listFromServer.get(i)+"\n";
                }
                ListOwners.text.append(s);
            }
            else if(pd.getOperationType().equals("LIST")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<CarOwner> listFromServer = infoFromServer.getCarOwners();
                String s ="";
                for(int i=0;i<listFromServer.size();i++){
                    s+=listFromServer.get(i)+"\n";
                }
                DeleteOwner.text.append(s);
                UpdateOwners.text.append(s);
            }
            else if(pd.getOperationType().equals("DELETE")){
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("UPDATE")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<CarOwner> listFromServer = infoFromServer.getCarOwners();
                String s ="";
                for(int i=0;i<listFromServer.size();i++){
                    s+=listFromServer.get(i)+"\n";
                }
                UpdateOwners.text.append(s);
            }
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        frame = new MainFrame();
        frame.setVisible(true);
    }
}
