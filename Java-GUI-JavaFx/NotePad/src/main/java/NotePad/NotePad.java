package NotePad;

import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;


public class NotePad extends BorderPane {
    MenuBar menuBar = new MenuBar();
    Menu fileMenu = new Menu("File");
    Menu editMenu = new Menu("Edit");
    Menu helpMenu = new Menu("About");
    MenuItem newItem = new MenuItem("new");
    MenuItem openItem = new MenuItem("Open");
    MenuItem saveItem = new MenuItem("Save");
    MenuItem exitItem = new MenuItem("Exit");
    MenuItem cutItem = new MenuItem("Cut");
    MenuItem copyItem = new MenuItem("Copy");
    MenuItem pasteItem = new MenuItem("Paste");
    MenuItem deleteItem = new MenuItem("Delete");
    MenuItem selectAllItem = new MenuItem("Select All");
    MenuItem aboutItem = new MenuItem("About");
    TextArea note = new TextArea();
    Stage stage;
    String fileName;
    File file;

    public NotePad(Stage stage) {
        this.stage = stage;
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
        fileMenu.getItems().addAll(newItem, openItem, saveItem, exitItem);
        editMenu.getItems().addAll(cutItem, copyItem, pasteItem, deleteItem, selectAllItem);
        helpMenu.getItems().addAll(aboutItem);
        fileMenu.setMnemonicParsing(true);
        fileMenu.setText("_File");
        editMenu.setMnemonicParsing(true);
        editMenu.setText("_Edit");
        helpMenu.setMnemonicParsing(true);
        helpMenu.setText("_Help");
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+n"));
        openItem.setAccelerator(KeyCombination.keyCombination("Ctrl+o"));
        saveItem.setAccelerator(KeyCombination.keyCombination("Ctrl+s"));
        exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+e"));
        StackPane stackpane = new StackPane(note);
        newItem.addEventHandler(ActionEvent.ACTION, (e) -> {
            note.setText("");
            stage.setTitle("untitled");
        });
        openItem.addEventHandler(ActionEvent.ACTION, (e) -> {
            FileChooser filechooser = new FileChooser();
            filechooser.setTitle("open text file");
            filechooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text files", "*.txt", "*.java", "*.c", "*.xml")
            );
            file = filechooser.showOpenDialog(stage);
            stage.setTitle(file.getName());
            note.setText("");
            readFileByCharacter();
            //readFileByByte();
        });
        saveItem.addEventHandler(ActionEvent.ACTION, (e) -> {
            if (file == null) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("choose directory to save the file");
                file = fileChooser.showSaveDialog(stage);
                if(file==null)
                    return;
                stage.setTitle(file.getName());

            }
            //writeFileByByte();
            writeFileByCharacter();

        });
        exitItem.addEventHandler(ActionEvent.ACTION, (e) -> System.exit(0));
        cutItem.addEventHandler(ActionEvent.ACTION, (e) -> note.cut());
        copyItem.addEventHandler(ActionEvent.ACTION, (e) -> note.copy());
        pasteItem.addEventHandler(ActionEvent.ACTION, (e) -> note.paste());
        deleteItem.addEventHandler(ActionEvent.ACTION, (e) -> {
            String selectedText = note.getSelectedText();
            note.setText(note.getText().replace(selectedText, ""));
        });
        selectAllItem.addEventHandler(ActionEvent.ACTION, (e) -> {
            note.selectAll();
        });
        aboutItem.addEventHandler(ActionEvent.ACTION, (e) -> {
            Stage newWindow = new Stage();
            Image image = new Image("baz.jpg");
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(200);
            imageView.setFitWidth(300);
            Text text = new Text("This notepad app is implemented using javafx \nDuring the introduction to java Gui course");
            Text name = new Text("Hadeer Ashraf Elnaggar");
            Label label = new Label("", imageView);
            FlowPane flowPane = new FlowPane(label, text, name);
            flowPane.setStyle("-fx-background-color: white;");
            flowPane.setOrientation(Orientation.VERTICAL);
            BorderPane border = new BorderPane();
            border.setCenter(flowPane);
            Scene scene = new Scene(border, 400, 400);
            newWindow.setScene(scene);
            newWindow.show();
        });
        this.setTop(menuBar);
        this.setCenter(stackpane);
    }

    public void readFileByCharacter() {
        try {
            FileReader fileReader = new FileReader(file);
            int n = fileReader.read();
            while (n != -1) {
                note.setText(note.getText() + (char) n);
                n = fileReader.read();
            }
            fileReader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readFileByByte() {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int n = fileInputStream.read();
            while (n != -1) {
                note.setText(note.getText() + (char) n);
                n = fileInputStream.read();
            }
            fileInputStream.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeFileByCharacter() {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(note.getText());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFileByByte() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(note.getText().getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
