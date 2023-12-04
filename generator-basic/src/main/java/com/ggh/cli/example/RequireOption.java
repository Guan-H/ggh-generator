package com.ggh.cli.example;


import picocli.CommandLine.Option;

public class RequireOption {

    @Option(names= " -a ",required = true)
    String author;
}
