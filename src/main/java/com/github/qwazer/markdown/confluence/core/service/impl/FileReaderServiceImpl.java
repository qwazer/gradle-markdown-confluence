package com.github.qwazer.markdown.confluence.core.service.impl;

import com.github.qwazer.markdown.confluence.core.ConfluenceConfig;
import com.github.qwazer.markdown.confluence.core.service.FileReaderService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Anton Reshetnikov on 15 Nov 2016.
 */
@Service
public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public String readFile(ConfluenceConfig confluenceConfig) throws IOException {

        String content=null;

        File file = confluenceConfig.getBaseFile();
        FileReader fileReader = new FileReader(file);
        char[] chars = new char[(int) file.length()];
        try {
            fileReader.read(chars);
            content = new String(chars);
        }
        finally {
            fileReader.close();
        }

        return content;

    }
}