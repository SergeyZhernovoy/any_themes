package spring_boot.utils;/**
 * @author Sergey Zhernovoy
 * create on 22.11.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import spring_boot.entity.Isbn;

import java.beans.PropertyEditorSupport;

public class IsbnEditor extends PropertyEditorSupport {
    private static final Logger logger = LoggerFactory.getLogger(IsbnEditor.class);

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(StringUtils.hasText(text)){
            setValue(new Isbn(text.trim()));
        } else {
            setValue(null);
        }
    }

    @Override
    public String getAsText() {
        String result = "";
        Isbn isbn = (Isbn) getValue();
        if(isbn != null){
            result = isbn.getIsbn();
        }

        return result;
    }



}

    