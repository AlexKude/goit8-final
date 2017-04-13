package goit.group8.finalproject.service;

public interface SecurityService {

    int getCurrentUserId();

    String findLoggedInUsername();

    void autoLogin(String login, String password);
}
