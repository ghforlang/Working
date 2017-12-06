package jsr303.test;

import jsr303.annotation.Matches;

/**
 * @author fanwh
 * @version v1.0
 * @decription
 * @create on 2017/12/3 15:49
 */
@Matches(field = "newPassword",verifyField = "confirmNewPassword",message = "{constraint.confirmNewPassword.not.match.newPassword}")
public class TwoPassword {
    private String newPassword;
    private String confirmNewPassword;


    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }
}
