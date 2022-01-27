package com.sparta.homework001.domain;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class BoardRequestDto {
    private String title;
    private String name;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
