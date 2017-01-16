package com.maslick.activesyncer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by maslick on 15/01/17.
 */
@RestController
public class SyncController {

    @PostMapping("post")
    Message haha(@RequestBody List<RawData> list) {

        list.stream()
                .limit(50)
                .forEach(datum -> System.out.println(convertDataToString(datum)));


        System.out.println("-------------\n" +
                new Timestamp(System.currentTimeMillis()) +
                "\nTotal: " + list.size());

        return Message.builder()
                .status("success")
                .message("data received")
                .build();
    }

    private String convertDataToString(RawData data) {
        return String.format("id: %d ; angles: %1.1f, %1.1f, %1.1f ; accel: %.2f, %.2f, %.2f ; hr: %d ; " +
                "timestamp: %d", data.getId(), data.getAlpha(), data.getBeta(), data.getGamma(),
                data.getAx(), data.getAy(), data.getAz(), data.getHr(), data.getTimestamp());
    }
}
