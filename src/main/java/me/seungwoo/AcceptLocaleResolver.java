package me.seungwoo;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        if (StringUtils.isBlank(request.getHeader("locale"))) {
            return Locale.getDefault();
        }
        String locale1 = request.getHeader("locale");
        String[] s = locale1.split("_");
        Locale locale = new Locale(s[0]);
        logger.info("locale : {}", locale);
        return locale;
    }
}
