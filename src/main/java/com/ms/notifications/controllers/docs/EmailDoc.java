package com.ms.notifications.controllers.docs;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.ms.notifications.dto.EmailDto;
import com.ms.notifications.dto.EmailStatusDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(
    name="Email Controller",
    description ="API exposed for sending email through SMTP"
)
public interface EmailDoc {

    @Operation(summary="Send an email to a destination", description="This operation is for sending an email")
    @ApiResponses(
        value={
            @ApiResponse(
                responseCode="200",
                description="Email sent",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                responseCode="400",
                description="Bad request",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                responseCode="500",
                description="Internal Server Error",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            )
        }
    )
    ResponseEntity<EmailStatusDto> send(@RequestBody @Valid EmailDto emailDto);

}
