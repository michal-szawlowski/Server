import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Server {
    private Scanner scanner;
    private PrintWriter serverPrintOut;
    private Timer timer;
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(9991)) {
            initServer(serverSocket);
            singleCommand(scanner, serverPrintOut);
            serverPrintOut.println("Server was working " + timer.workTimeInSeconds() + " s");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initServer(ServerSocket serverSocket) throws IOException {
        timer = new Timer();
        timer.start();
        Socket connectionSocket = serverSocket.accept();
        InputStream inputToServer = connectionSocket.getInputStream();
        OutputStream outputFromServer = connectionSocket.getOutputStream();
        this.scanner = new Scanner(inputToServer, "UTF-8");
        this.serverPrintOut = new PrintWriter(new OutputStreamWriter(outputFromServer, "UTF-8"), true);
        serverPrintOut.println("Hello World!");
    }

    private  void singleCommand(Scanner scanner, PrintWriter serverPrintOut) {
        serverPrintOut.println("Enter stop to exit");
        boolean done = false;
        while (!done && scanner.hasNextLine()) {
            String input = scanner.nextLine();
            done = executeCommand(input);
        }
    }

    private boolean executeCommand(String input) {
        switch (input.toLowerCase().trim()) {
            case "stop":
                return true;
            case "time_server_active" :
                serverPrintOut.println("Server was working " + timer.workTimeInSeconds() + " s");
                return false;
            case "current_time" :
                serverPrintOut.println("Current time is " + LocalDateTime.now());
                return false;
            default:
                serverPrintOut.println("Do not know command");
                return false;
        }
    }
}