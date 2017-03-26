package goit.group8.finalproject.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
