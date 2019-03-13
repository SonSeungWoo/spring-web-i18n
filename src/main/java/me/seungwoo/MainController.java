package me.seungwoo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

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

    private final MainService mainService;

    private final CustomCollectionValidator customCollectionValidator;

    @GetMapping("/message")
    public ResponseEntity<String> message(HttpServletRequest request) {
        String message = messageSource.getMessage("label.msg", request);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/user")
    public String user(@Valid @ModelAttribute UserDto userDto) {
        return "success";
    }

    @PostMapping("/user")
    public String userTest(@Valid @RequestBody List<UserDto> userDto, BindingResult bindingResult) throws BindException {
        //mainService.testService(userDto);
        // 이것만 추가 - List를 직접 validate
        customCollectionValidator.validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        return "success";
    }

}
