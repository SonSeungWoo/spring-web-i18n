package me.seungwoo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-02-21
 * Time: 15:00
 */
public class AcceptLocaleResolver extends AcceptHeaderLocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        if (StringUtils.isBlank(request.getHeader("locale"))) {
            return Locale.getDefault();
        }
        request.setAttribute("Accept-Language", request.getHeader("locale"));
        Locale locale = new Locale(request.getHeader("locale"));
        System.out.println(locale.getLanguage());
        return locale;
    }
}
