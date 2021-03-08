package program;

import javafx.scene.layout.VBox;

public class MessageHandler extends Thread {
    String message;


    public MessageHandler(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        ClientSocket clientSocket =ClientSocket.getInstance();
        clientSocket.sendMessage(message);

    }
}
