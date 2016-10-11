package com.mdzy.xqbadmin.common.poi;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateConverter implements Converter {

    public Object convert(Class type, Object value) {
        if(value == null) {
            return null;
        }

        if(value instanceof Date) {
            return value;
        }

        if(value instanceof String){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = (String)value;
            try {
                return df.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}