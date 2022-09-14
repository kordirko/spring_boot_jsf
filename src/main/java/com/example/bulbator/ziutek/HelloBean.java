package com.example.bulbator.ziutek;

import org.springframework.stereotype.Component;

import javax.faces.bean.ViewScoped;
import java.util.Random;

@Component
@ViewScoped
public class HelloBean {
    public String getMsg() {
        Random random = new Random();
        return "Hello bubba: " + random.nextInt(30);
    }
}
