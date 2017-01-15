package com.maslick.activesyncer;


import lombok.*;

/**
 * Created by maslick on 15/01/17.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Message {
    String status;
    String message;
}
