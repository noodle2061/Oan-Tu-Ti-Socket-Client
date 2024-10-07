/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.DeleteAccountFrm;
import view.LoginFrm;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import view.ChangePasswordFrm;
import view.RegisterFrm;

/**
 *
 * @author admin
 */
public class Client {

    public static LoginFrm loginFrm;
    public static ClientSocketHandle socketHandle;
    public static Socket socket;
    public static RegisterFrm registerFrm;
    public static DeleteAccountFrm deleteAccountFrm;
    public static ChangePasswordFrm changePasswordFrm;

    public Client() {
        try {
            socket = new Socket("localhost", 9989);
            loginFrm = new LoginFrm();
            loginFrm.setVisible(true);
            socketHandle = new ClientSocketHandle(socket);
            socketHandle.run();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public enum View {
        LOGIN,
        REGISTER,
        DELETEACCOUNT,
        CHANGEPASSSWORD
    }

    public static void OpenView(View viewName) {
        switch (viewName) {
            case LOGIN:
                loginFrm = new LoginFrm();
                loginFrm.setVisible(true);
                break;
            case REGISTER:
                registerFrm = new RegisterFrm();
                registerFrm.setVisible(true);
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public static void OpenView(View viewName, int x, int y) { // mở một view ở vị trí x,y trên màn hình
        switch (viewName) {
            case LOGIN:
                loginFrm = new LoginFrm();
                loginFrm.setLocation(x, y);
                loginFrm.setVisible(true);
                break;
            case REGISTER:
                registerFrm = new RegisterFrm();
                registerFrm.setLocation(x, y);
                registerFrm.setVisible(true);
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public static void OpenView(View viewName, String adminName) {
        switch (viewName) {
            case DELETEACCOUNT:
                deleteAccountFrm = new DeleteAccountFrm(adminName);
                deleteAccountFrm.setVisible(true);
                break;
            case CHANGEPASSSWORD:
                changePasswordFrm = new ChangePasswordFrm(adminName);
                changePasswordFrm.setVisible(true);
                break;
            default:
                throw new AssertionError();
        }
    }

    public static void OpenView(View viewName, String adminName, int x, int y) {
        switch (viewName) {
            case DELETEACCOUNT:
                deleteAccountFrm = new DeleteAccountFrm(adminName);
                deleteAccountFrm.setLocation(x, y);
                deleteAccountFrm.setVisible(true);
                break;
            case CHANGEPASSSWORD:
                changePasswordFrm = new ChangePasswordFrm(adminName);
                changePasswordFrm.setLocation(x, y);
                changePasswordFrm.setVisible(true);
                break;

            default:
                throw new AssertionError();
        }
    }
    
    public static void CloseView(View viewName) { // closeView(view.LOGIN)
        switch (viewName) {
            case LOGIN:
                loginFrm.dispose();
                break;
            case REGISTER:
                registerFrm.dispose();
                break;
            case DELETEACCOUNT:
                deleteAccountFrm.dispose();
                break;
            case CHANGEPASSSWORD:
                changePasswordFrm.dispose();
                break;
            default:
                throw new AssertionError();
        }
    }

    

    public static void main(String[] args) {
        new Client();
    }
}
