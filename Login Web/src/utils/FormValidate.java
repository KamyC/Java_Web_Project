package utils;

import java.util.HashMap;
import java.util.regex.Pattern;

public class FormValidate {
    private String username;
    private String password;
    private String confirm;
    private String email;
    private HashMap<String,String> error=new HashMap<>();

    public HashMap<String, String> getError() {
        return error;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FormValidate{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirm='" + confirm + '\'' +
                ", email='" + email + '\'' +
                ", error=" + error +
                '}';
    }

    public boolean validate(){
        /*User name not empty, length (5-15)*/
        String username=this.username.trim();

        if(username.length()<5||username.length()>15){
            error.put("username","username length should be between 5 to 15 characters");
        }
        /*password not empty, length(6-9)*/
        String password=this.password;
//        System.out.println("password: "+password);

        if(password.length()<6 || password.length()>9){
            error.put("password","password length should be between 6 to 9 characters ");
        }
        /*confirm*/
        String confirm=this.confirm.trim();
//        System.out.println("confirm: "+confirm);
        if(!confirm.equals(password)){
            error.put("confirm","confirm the password match");
        }
        /*email format correct*/

        String regex="^\\w+((-\\w+)|(\\.\\w+))*@\\w+(\\.\\w{2,3}){1,3}$";
        boolean emailFormat=Pattern.matches(regex, email);
        if(!emailFormat){
            error.put("email","format should be correct");
        }

        if (this.error.size()>0){
            return false;
        }else {
            return true;
        }
    }
}
