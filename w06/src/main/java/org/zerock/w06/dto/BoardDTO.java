package org.zerock.w06.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private Long bno ;

    private String title;

    private String content ;

    private String writer ;

    private LocalDateTime regDate ;

    private LocalDateTime modDate;
}
