package com.hrydzina.task2.reader;

import com.hrydzina.task2.exception.TextProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextReader {

  private static final Logger LOGGER = LogManager.getLogger(TextReader.class);

  public String readText(String path)
          throws TextProcessingException {
    try {
      String text = Files.readString(Path.of(path));
      LOGGER.info("Text successfully read from file {}",
              path);
      return text;
    } catch (IOException e) {
      LOGGER.error("Error reading file {}",
              path, e);
      throw new TextProcessingException(
              "Cannot read file: " + path, e);
    }
  }
}
