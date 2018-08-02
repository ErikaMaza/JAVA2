package gb.client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    TextField msgField;

    @FXML
    TextArea chatArea;

    @FXML
    HBox bottomPanel;

    @FXML
    HBox upperPanel;

    @FXML
    TextField loginfield;

    @FXML
    PasswordField passwordField;

    @FXML
    ListView<String> clientsList;

    @FXML
    HBox registrPanel;

    @FXML
    TextField regLog;

    @FXML
    TextField regNick;

    @FXML
    PasswordField regPass;


    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    final String IP_ADDRESS = "localhost";
    final int PORT = 8189;
    boolean isAuthohorized;

    public void setAuthohorized(boolean isAuthohorized) {
        this.isAuthohorized = isAuthohorized;
        if (!isAuthohorized) {
            upperPanel.setVisible(true);
            upperPanel.setManaged(true);
            bottomPanel.setVisible(false);
            bottomPanel.setManaged(false);
            clientsList.setVisible(false);
            clientsList.setManaged(false);
            registrPanel.setVisible(true);
            registrPanel.setManaged(true);
        } else {
            upperPanel.setVisible(false);
            upperPanel.setManaged(false);
            bottomPanel.setVisible(true);
            bottomPanel.setManaged(true);
            clientsList.setVisible(true);
            clientsList.setManaged(true);
            registrPanel.setVisible(false);
            registrPanel.setManaged(false);
        }
    }

    public void connect() {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            setAuthohorized(false);
            Thread thread = new Thread(() -> {
                try {

                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/authok")) {
                            setAuthohorized(true);
                            break;
                        } else {
                            chatArea.appendText(str + "\n");
                        }
                    }
                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/serverclosed")) break;
                        if (str.startsWith("/clientlist")) {
                            String[] tokens = str.split(" ");
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    clientsList.getItems().clear();
                                    for (int i = 1; i < tokens.length; i++) {
                                        clientsList.getItems().add(tokens[i]);
                                    }
                                }
                            });
                        } else {
                            chatArea.appendText(str + "\n");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    setAuthohorized(false);
                }
            });
            thread.setDaemon(true);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg() {
        try {
            out.writeUTF(msgField.getText());
            msgField.clear();
            msgField.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tryToAuth() {
        if(socket == null || socket.isClosed()) {
            connect();
        }
        try {
            out.writeUTF("/auth " + loginfield.getText() + " " + passwordField.getText());
            loginfield.clear();
            passwordField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addNewUser(ActionEvent actionEvent) {
        if(socket == null || socket.isClosed()) {
            connect();
        }

        try {
            out.writeUTF("/addUser " + regLog.getText() + " " + regPass.getText() + " " + regNick.getText());
            regNick.clear();
            regPass.clear();
            regLog.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
