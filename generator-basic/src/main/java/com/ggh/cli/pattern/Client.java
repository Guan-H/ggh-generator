package com.ggh.cli.pattern;

public class Client {

    public static void main(String[] args) {
        Device tv = new Device("MiTV");
        Device stereo = new Device("stereo");

        TurnOffCommand turnOff = new TurnOffCommand(tv);
        TurnOnCommand turnOn = new TurnOnCommand(stereo);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(turnOff);
        remote.pressButton();

        remote.setCommand(turnOn);
        remote.pressButton();
    }


}
