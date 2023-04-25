package kz.intertop.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ColorDto {
    private Long id;
    private String name;
    private String hashCode;
    private int red;
    private int green;
    private int blue;
}
