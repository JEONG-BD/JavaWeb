package org.zerock.w05.controller.formatter;

import jdk.vm.ci.meta.Local;
import org.springframework.format.Formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {

    @Override
    public LocalDate parse(String text, Locale locale){
       return LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


    @Override
    public String print(LocalDate object, Locale locale) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(object);
    }
}
