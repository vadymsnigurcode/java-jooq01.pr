package org.example;

import org.jooq.codegen.GenerationTool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Generate {
    public static void main(String[] args) throws Exception {
        GenerationTool.generate(
                Files.readString(
                        Path.of("/home/vadym/dev/jooq01.pr/src/main/resources/jooq-config.xml")
                )
        );
    }
}
