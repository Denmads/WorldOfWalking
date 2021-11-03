package com.madsj;

import com.madsj.response.Response;

public abstract class Room {
    private String id;
    private String name;


    public abstract Response processCommand();
}
