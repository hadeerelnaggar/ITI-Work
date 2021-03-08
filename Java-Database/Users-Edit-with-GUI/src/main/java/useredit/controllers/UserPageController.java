package useredit.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import useredit.server.daos.UserDao;
import useredit.models.User;
import java.net.URL;
import java.util.ResourceBundle;

public class UserPageController implements Initializable {
    @FXML
    TextField id;
    @FXML
    TextField firstName;
    @FXML
    TextField middleName;
    @FXML
    TextField lastName;
    @FXML
    TextField email;
    @FXML
    TextField phone;
    @FXML
    Button newUser;
    @FXML
    Button updateUser;
    @FXML
    Button deleteUser;
    @FXML
    Button firstUser;
    @FXML
    Button previousUser;
    @FXML
    Button nextUser;
    @FXML
    Button lastUser;
    User user=null;
    UserDao userDao = UserDao.getInstance();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user=userDao.getFirst();
        previousUser.setDisable(true);
        id.setEditable(false);
        if(user==null){
            addingCase();
        }
        else if(!userDao.hasnext()){
            nextUser.setDisable(true);
        }
            binding();


    }
    public void addUser(){
        if(newUser.getText().equals("New")){
            addingCase();
        }
        else if (newUser.getText().equals("Add")){
            firstUser.setDisable(false);
            lastUser.setDisable(false);
            deleteUser.setDisable(false);
            updateUser.setDisable(false);
            nextUser.setDisable(true);
            System.out.println(user.getFirstName()+"kkk");
            userDao.addUser(user);
            user=userDao.getLast();
            checkPrev();
            binding();
            newUser.setText("New");
        }
    }
    public void updateUser(){
        userDao.updateUser(user);
        user=userDao.getFirst();
        checkPrev();
        checkNext();
        binding();
    }
    public void deleteUser(){
        if(!userDao.hasnext() && !userDao.hasprev()){
            addingCase();
        }
        userDao.deleteUser(user);
        getFirstUser();
    }
    public void getFirstUser(){
        previousUser.setDisable(true);
        user=userDao.getFirst();
        if(user==null){
            user=new User();
            addingCase();
        }
        else
            checkNext();
        binding();
    }
    public void getPreviousUser(){
        nextUser.setDisable(false);
        user=userDao.getPrevious();
        binding();
        checkPrev();
    }
    public void getNextUser(){
        previousUser.setDisable(false);
        user=userDao.getNext();
        binding();
        checkNext();
    }
    public void getLastUser(){
        nextUser.setDisable(true);
        user=userDao.getLast();
        checkPrev();
        binding();
    }
    private void addingCase(){
        user = new User();
        binding();
        newUser.setText("Add");
        deleteUser.setDisable(true);
        updateUser.setDisable(true);
        nextUser.setDisable(true);
        previousUser.setDisable(true);
        firstUser.setDisable(true);
        lastUser.setDisable(true);
        id.setVisible(false);
    }
    private void checkNext(){
        if(!userDao.hasnext()){
            nextUser.setDisable(true);
        }
        else
            nextUser.setDisable(false);
    }
    private void checkPrev(){
        if(!userDao.hasprev()){
            previousUser.setDisable(true);
        }
        else
            previousUser.setDisable(false);
    }
    private void binding(){
        id.textProperty().bindBidirectional(user.idProperty());
        firstName.textProperty().bindBidirectional(user.firstNameProperty());
        middleName.textProperty().bindBidirectional(user.middleNameProperty());
        lastName.textProperty().bindBidirectional(user.lastNameProperty());
        email.textProperty().bindBidirectional(user.emailProperty());
        phone.textProperty().bindBidirectional(user.phoneProperty());
    }
}
