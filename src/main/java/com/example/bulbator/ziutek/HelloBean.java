package com.example.bulbator.ziutek;

import org.springframework.stereotype.Component;

import javax.faces.bean.ViewScoped;

@Component
@ViewScoped
public class HelloBean {
    public String getMsg() {
        return "Hello bubba";
    }
}
