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
public class RawData {
    private long id;
    private float alpha;
    private float beta;
    private float gamma;
    private float ax;
    private float ay;
    private float az;
    private int hr;
    private float proximity;
    private long timestamp;
    private long synced_at;
}
