import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request = "";
            while (!request.equals("exit") && !currentThread().isInterrupted()) {
                request = in.readLine();
                System.out.println("Request is : " + request);
                if (request.equals("stop")){
                    System.out.println("Stopping server...");
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    String response = "Server stopped";
                    out.println(response);
                    out.flush();
                    GameServer.running = false;
System.exit(0);
                    //socket.close();
                    //break;
                }else {
                    // Send the response to the oputput stream: server → client
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    String raspuns = "Server received the request: " + request;
                    out.println(raspuns);
                    out.flush();
                }
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }

}
