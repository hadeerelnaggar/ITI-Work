package program;

import javafx.scene.image.Image;

public class UserInfo {
    private String userName;
    private Image userImage;

    public UserInfo(String userName, Image userImage) {
        this.userName = userName;
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Image getUserImage() {
        return userImage;
    }

    public void setUserImage(Image userImage) {
        this.userImage = userImage;
    }
}
