package com.apress.prospring4.ch5AOP.securebeen;

public class SecurityManager {
    private static ThreadLocal<UserINfo> threadLocal =
            new ThreadLocal<>();
    public void login(String userName, String password){
        threadLocal.set(new UserINfo(userName,password));
    }
    public void logout(){
        threadLocal.set(null);
    }
    public UserINfo getLoggedOnUser(){
        return threadLocal.get();
    }
}
