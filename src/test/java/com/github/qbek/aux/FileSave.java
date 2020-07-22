package com.github.qbek.aux;

import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static java.lang.String.format;
import static java.lang.Thread.currentThread;
import static java.nio.charset.Charset.forName;
import static org.apache.commons.io.FileUtils.writeStringToFile;

public class FileSave {

    public static void saveToFile(Response response) throws IOException {
        String filename = currentThread().getStackTrace()[2].getMethodName();
        File file = new File(format("target/%s.json", filename));
        String body = response.prettyPrint();
        writeStringToFile(file, body, forName("UTF-8"));
    }
}
