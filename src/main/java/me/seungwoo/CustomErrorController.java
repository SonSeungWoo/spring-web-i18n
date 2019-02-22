package me.seungwoo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-02-22
 * Time: 09:16
 */
@Slf4j
@Controller
@RequestMapping("/error")
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @Autowired
    private MessageByLocale message;

    @GetMapping
    public String test(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status.equals(HttpStatus.BAD_REQUEST.value())) {
            return "redirect:" + PATH + "/400";
        }else if (status.equals(HttpStatus.FORBIDDEN.value())) {
            return "redirect:" + PATH + "/403";
        }else if (status.equals(HttpStatus.NOT_FOUND.value())) {
            return "redirect:" + PATH + "/404";
        }else if (status.equals(HttpStatus.METHOD_NOT_ALLOWED.value())) {
            return "redirect:" + PATH + "/405";
        }else if (status.equals(HttpStatus.INTERNAL_SERVER_ERROR.value())) {
            return "redirect:" + PATH + "/500";
        }else if (status.equals(HttpStatus.SERVICE_UNAVAILABLE.value())) {
            return "redirect:" + PATH + "/503";
        }
        return "error";
    }

    @GetMapping(value = "/400")
    @ResponseBody
    public ResponseEntity<String> unauthorized(HttpServletRequest request) {
        return ResponseEntity.ok(message.getMessage("badRequest.error.msg", request));
    }

    @GetMapping(value = "/403")
    @ResponseBody
    public ResponseEntity<String> forbidden(HttpServletRequest request) {
        return ResponseEntity.ok(message.getMessage("forbidden.error.msg", request));
    }

    @GetMapping(value = "/404")
    @ResponseBody
    public ResponseEntity<String> notFoundError(HttpServletRequest request) {
        return ResponseEntity.ok(message.getMessage("not.found.error.mag", request));
    }

    @GetMapping(value = "/405")
    @ResponseBody
    public ResponseEntity<String> methodNotAllowed(HttpServletRequest request) {
        return ResponseEntity.ok(message.getMessage("method.not.allowed.err.msg", request));
    }

    @GetMapping(value = "/500")
    @ResponseBody
    public ResponseEntity<String> serverError(HttpServletRequest request) {
        return ResponseEntity.ok(message.getMessage("internal.server.error.msg", request));
    }

    @GetMapping(value = "/503")
    public ResponseEntity<String> serviceUnavailable(HttpServletRequest request) {
        return ResponseEntity.ok(message.getMessage("service.unavailable.error.msg", request));
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}

