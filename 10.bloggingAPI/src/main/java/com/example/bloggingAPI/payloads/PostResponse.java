package com.example.bloggingAPI.payloads;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostResponse {
    List<PostDto> contents;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPage;
    private boolean isLastPage;


}
