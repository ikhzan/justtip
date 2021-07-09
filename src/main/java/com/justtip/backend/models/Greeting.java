package com.justtip.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Greeting {
    private String msg;
    private String name;

    public Greeting(String msg, String name) {
        this.msg = msg;
        this.name = name;
    }

    @Override
    public String toString() {
        return msg + ", " + name + "!";
    }
}
