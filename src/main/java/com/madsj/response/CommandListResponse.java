package com.madsj.response;

public class CommandListResponse implements Response {
    @Override
    public void print() {
        System.out.println("Available Commands:");
        System.out.println("HELP");
        System.out.println("LIST <'Zones'|'Exits'>");
        System.out.println("GOTO <Zone|Room>");
        System.out.println("INSPECT <'Room'|'Zone'|Item>");
        System.out.println("USE <Item>");
        System.out.println("USE <Item> ON <Object>");
        System.out.println("QUIT");
    }
}
