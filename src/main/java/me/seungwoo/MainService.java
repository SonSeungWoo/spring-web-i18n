package me.seungwoo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;


/**
 * Created by Leo.
 * User: sonseungwoo
 * Date: 2019-03-13
 * Time: 21:48
 */
@Service
@Transactional(readOnly = true)
public class MainService {

    public void testService(@Valid UserDto userDto){
        System.out.println("test2");
    }
}
