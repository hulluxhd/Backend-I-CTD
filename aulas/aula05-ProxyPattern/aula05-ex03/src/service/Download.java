package service;

import model.DownloadInterface;
import user.User;

public class Download implements DownloadInterface {

    @Override
    public void verifyPremium(User user) {
        user.downloadMusic();
    }
}
