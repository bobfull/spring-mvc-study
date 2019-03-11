package controller;

public class ChangePwdCommand {
    private String currentPassword;
    private String newPassWord;

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassWord;
    }

    public void setNewPassword(String newPassWord) {
        this.newPassWord = newPassWord;
    }
}
