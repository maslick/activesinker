package com.maslick.activesyncer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by maslick on 15/01/17.
 */
@RestController
public class SynContra {

    @PostMapping("post")
    Message haha(@RequestBody List<Datum> list) {

        list.stream()
            .forEach(datum -> System.out.println(datum.getAlpha() + ", " + datum.getHr()));

        return Message.builder()
                .status("success")
                .message("data received")
                .build();
    }
}
