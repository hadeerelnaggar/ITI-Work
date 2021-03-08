package DirectoryStructure;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.util.Callback;
import org.kordamp.ikonli.javafx.FontIcon;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class PageController implements Initializable {
    @FXML
    private TreeView treeView;
    @FXML
    private Button fileChooserButton;
    @FXML
    private ListView listView;
    @FXML
    private TextField pathText;
    File file;
    File [] directoryList;
    TreeItem<File> rootItem= new TreeItem<>();
    ObservableList<File> underSelectedList=FXCollections.observableArrayList();
    File[] underSelectedFile=null;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setItems(underSelectedList);
        rootItem.setExpanded(true);
        treeView.setRoot(rootItem);
        fileChooserButton.setOnAction((e)->{
            DirectoryChooser directoryChooser = new DirectoryChooser();
            file = directoryChooser.showDialog(fileChooserButton.getScene().getWindow());
            if(file!=null) {
                pathText.setText(file.getAbsolutePath());
                rootItem.setValue(file);
                listFiles(file, rootItem, file.listFiles());
            }
        });
        pathText.setOnKeyPressed((e)->{
            if(e.getCode()== KeyCode.ENTER){
                if(pathText.getText().equals("")){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please Enter Path");
                    alert.show();
                }
                else {
                    file = new File(pathText.getText());
                    if(!file.exists()){
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Please Enter Valid Path");
                        alert.show();
                    }
                    else {
                        rootItem.setValue(file);
                        listFiles(file, rootItem, file.listFiles());
                    }
                }
            }
        });
        treeView.setCellFactory(new Callback<TreeView, TreeCell>() {
            @Override
            public TreeCell call(TreeView treeView) {
                return new TreeCell<File>(){
                    @Override
                    protected void updateItem(File file, boolean b) {
                        super.updateItem(file, b);
                        if(file==null){
                            setText("");
                            setGraphic(null);
                        }
                        if(file!=null){
                            setText(file.getName());
                            String icon;
                            if(file.isDirectory()) icon="mdi2f-folder";
                            else icon="mdi2f-file";
                            setGraphic(new FontIcon(icon));
                    }}
                };
            }
        });
        treeView.addEventHandler(MouseEvent.MOUSE_CLICKED,(e)->{
            TreeItem selected = (TreeItem)treeView.getSelectionModel().getSelectedItem();
            if(selected!=null){
            System.out.println(selected.getValue());
            File selectedFile = (File)selected.getValue();
            if(selectedFile.isDirectory()) {
                if(underSelectedFile!=null)
                    underSelectedList.removeAll(underSelectedFile);
                for(int i=0;i<underSelectedList.size();i++){
                    System.out.println("aaaa"+underSelectedList.get(i));
                }
                listView.refresh();
                underSelectedFile = selectedFile.listFiles();
                underSelectedList.addAll(underSelectedFile);
                for(int i=0;i<underSelectedList.size();i++){
                    System.out.println("llll"+underSelectedList.get(i));
                }
                //ObservableList<File> underSelectedList = FXCollections.observableList(List.of(underSelectedFile));
                listView.refresh();}
            else{
                if(underSelectedFile!=null)
                    underSelectedList.removeAll(underSelectedFile);
                listView.refresh();
                underSelectedFile = new File[1];
                underSelectedFile[0]=selectedFile;
                underSelectedList.add(selectedFile);
                listView.refresh();
            }
            }
        });
        listView.setCellFactory(new Callback<ListView, ListCell>() {
            @Override
            public ListCell call(ListView listView) {
                return new ListCell<File>() {
                    @Override
                    protected void updateItem(File f, boolean b) {
                        super.updateItem(f, b);
                        if(f==null) {
                            setText("");
                            setGraphic(null);
                        }
                        if(f!=null) {
                            setText(f.getName());
                            setGraphic(new FontIcon(f.isDirectory() ? "mdi2f-folder" : "mdi2f-file"));
                        }
                    }
                };
            }

        });
    }
    public void listFiles(File file,TreeItem treeItem,File[] directoryList){
        if(file!=null){
            if(file.isDirectory()){
                treeItem.setExpanded(true);
                for(int i=0;i<directoryList.length;i++){
                    String icon;
                    if(directoryList[i].isDirectory()) icon="mdi2f-folder";
                    else icon="mdi2f-file";
                    TreeItem<File> item = new TreeItem<>(directoryList[i],new FontIcon(icon));
                    treeItem.getChildren().add(item);
                    listFiles(directoryList[i],item,directoryList[i].listFiles());
                }
            }
        }
    }
}
