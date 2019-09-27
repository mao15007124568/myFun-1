package edu.hubu.myfun.dto;

import lombok.Data;

@Data
public class GithubUser {

    private String name;
    private Long id;
    private String avatarUrl;
    private String bio;

}
