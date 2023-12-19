package com.ggh.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

public class Login implements Callable<Integer> {

    @Option(names = {"-u","--user"},description = "UserName")
    String user;

    @Option(names = {"-p","--password"},arity = "0..1",description = "Passphrase",interactive = true)
    String password;


    @Option(names = {"-cp","--checkPassword"},description = "check password",interactive = true)
    String checkPassword;
    @Override
    public Integer call() throws Exception {
        System.out.println("user = " + user + " password = " + password);
        if(password == null || checkPassword == null ){
            password = System.console().readLine("Enter password for --interactive: ");
        }
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new Login()).addSubcommand("status");
        new CommandLine(new Login()).execute("-u","user123","-p","-cp");
    }
}
