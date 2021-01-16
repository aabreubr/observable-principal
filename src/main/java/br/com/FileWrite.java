package br.com;

import org.springframework.stereotype.Component;

@Component
public class FileWrite implements WriteCommand {
    @Override
    public void write(String value) {
        System.out.println(value);
    }
}
