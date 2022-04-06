package service;

import model.DownloadInterface;
import user.User;

public class DownloadProxy implements DownloadInterface {
    @Override
    public void verifyPremium(User user) {
        if (user.getUserType().equalsIgnoreCase("Premium")) {
            DownloadInterface downloadInterface = new Download();
            downloadInterface.verifyPremium(user);

        } else {
            System.out.println("O usuário não tem o perfil premium.");
        }
    }
}
