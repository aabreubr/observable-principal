package br.com;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ServiceTransfer {

    private ReadListener readListener;
    private WriteCommand writeCommand;

    public ServiceTransfer(ReadListener readListener, WriteCommand writeCommand) {
        this.readListener = readListener;
        this.writeCommand = writeCommand;
    }

    public String readCommandListener() throws IOException {
        return readListener.read();
    }

    public void writeCommandListener(String value) {
        writeCommand.write(value);
    }
}

