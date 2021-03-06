package com.yun.nls.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResultStreamHandler implements Runnable {
    private InputStream inputStream;

    ResultStreamHandler(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Throwable t) {
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
            }
        }
    }

}
