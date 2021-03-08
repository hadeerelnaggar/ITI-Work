package program;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

import java.util.Scanner;

public class MessageReceiver extends Thread {
    Scanner in;
    ChatPageUtilities chatPageUtilities;

    MessageReceiver(Scanner in) {
        this.in = in;
        chatPageUtilities = ChatPageUtilities.getInstance();
    }

    @Override
    public void run() {
        String receivedLine = "";
        while (!receivedLine.equals("End")) {
            String received = in.nextLine();
            System.out.println(receivedLine);
            Platform.runLater(() -> {
                chatPageUtilities.addMessage(new UserInfo("user",null),received);
            });
            receivedLine = received;

        }
    }
}
