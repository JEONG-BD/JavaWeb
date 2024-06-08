package org.zerock.w05.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoVO {
   private Long tno;
   private String title;
   private LocalDate dueDate;
   private String writer;
   private boolean finished;

}
