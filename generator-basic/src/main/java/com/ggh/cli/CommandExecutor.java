package com.ggh.cli;

import com.ggh.cli.command.ConfigCommand;
import com.ggh.cli.command.GenerateCommand;
import com.ggh.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;


@Command(name = "ggh", description = "GGH",mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        System.out.println("请输入具体命令，或者输入 --help查看帮助");
    }
    public Integer doExecute(String[] args){
        return commandLine.execute(args);
    }

}
