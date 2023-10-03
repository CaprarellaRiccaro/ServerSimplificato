import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            System.out.println("Server attivato");
            ServerSocket server = new ServerSocket(3000);

            Socket s = server.accept();
            System.out.println("Un client si è connesso");
    
            BufferedReader inDalClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream outVersoClient = new DataOutputStream(s.getOutputStream());
            
            String stringaRicevuta = inDalClient.readLine();
            System.out.println("Il cliente ha inviato" + stringaRicevuta);
    
            String stringaModificata = stringaRicevuta.toUpperCase();
            outVersoClient.writeBytes(stringaModificata + '\n');
    
            server.close();
            s.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println();
            System.exit(1);
        }
        

    }
}
