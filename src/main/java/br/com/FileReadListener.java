package br.com;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileReadListener implements ReadListener {

    @Override
    public String read() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File("fileTest.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder result = new StringBuilder("");
        String line = "";
        while((line = br.readLine()) != null) {
            result.append(line).append("\n");
            System.out.println("mensagem recebida: " + line);
        }
        return result.toString();
    }

}
