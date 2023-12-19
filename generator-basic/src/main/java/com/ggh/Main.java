package com.ggh;

import com.ggh.cli.CommandExecutor;
import com.ggh.generator.StaticGenerator;

import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        CommandExecutor command = new CommandExecutor();
        command.doExecute(args);
    }
}