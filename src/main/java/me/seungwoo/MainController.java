package me.seungwoo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-02-21
 * Time: 15:41
 */
@RestController
@RequiredArgsConstructor
public class MainController {

    private final MessageByLocale messageSource;

    @GetMapping("/message")
    public ResponseEntity<String> message(HttpServletRequest request) {
        String message = messageSource.getMessage("label.msg", request);
        return ResponseEntity.ok(message);
    }
}
