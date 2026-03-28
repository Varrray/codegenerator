package com.project.codegenerator.dto.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(
        @JsonProperty("name")
        @NotBlank String name) {

}
