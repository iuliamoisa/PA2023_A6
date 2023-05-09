import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())) ) {
            // Send a request to the server
            System.out.println("   >> Write command :");
            Scanner scanner = new Scanner(System.in);
            String command = "";
            while (!command.equals("exit")  && !command.equals("stop") ) {
                command = scanner.nextLine();
                out.println(command);
                // Wait the response from the server
                if(!command.equals("exit")) {
                    String response = in.readLine();
                    System.out.println(response + '\n');
                }
            }

        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}
