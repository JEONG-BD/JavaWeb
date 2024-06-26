package org.zerock.w03.listener;


import lombok.extern.log4j.Log4j2;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
@Log4j2
public class LoginLinstener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event){

        String name = event.getName();

        Object obj = event.getValue();

        if(name.equals("loginInfo")) {
            log.info("A User Logined...");
            log.info(obj);
        }
    }

}
