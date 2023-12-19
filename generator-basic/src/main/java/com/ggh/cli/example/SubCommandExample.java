package com.ggh.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;

@Command(name = "main",mixinStandardHelpOptions = true)
public class SubCommandExample implements Runnable{

    @Override
    public void run() {
        System.out.println("Main的run方法");
    }

    @Command(name="add", description="新增",mixinStandardHelpOptions = true)
    static class AddCommand implements Runnable{

        @Option(names = {"-id","--ids"}, description="id",arity = "0..1",interactive = true)
        String id;
        @Override
        public void run() {
            System.out.println("add:新增");
            System.out.println("id = " + id);
        }
    }

    @Command(name="delete", description="删除",mixinStandardHelpOptions = true)
    static class DeleteCommand implements Runnable{
        @Override
        public void run() {
            System.out.println("delete:删除");
        }
    }

    @Command(name="update", description="更新",mixinStandardHelpOptions = true)
    static class UpdateCommand implements Runnable{
        @Override
        public void run() {
            System.out.println("update:更新");
        }
    }

    public static void main(String[] args) {
//        String[] myArgs = new String[]{};

//        String[] myArgs = new String[]{"add","-id"};

//        String[] myArgs = new String[]{"add","--help"};
        String[] myArgs = new String[]{"update"};
        CommandLine commandLine = new CommandLine(new SubCommandExample())
                .addSubcommand(new AddCommand())
                .addSubcommand(new DeleteCommand())
                .addSubcommand(new UpdateCommand());
        commandLine.execute(myArgs);
    }

}
