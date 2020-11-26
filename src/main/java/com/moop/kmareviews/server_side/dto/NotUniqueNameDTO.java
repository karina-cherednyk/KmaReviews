package com.moop.kmareviews.server_side.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class NotUniqueNameDTO {
    List<String> names;
    String message;
}
