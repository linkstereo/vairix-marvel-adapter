package com.vairix.marveladapter;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;
import org.springframework.boot.SpringApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Genera el modelo de clases basandonos en el modelo del json, el cual a su vez es tomado directamente de
 * la API de Marvel
 */
public class GenerateModelFromJSON {

    private static String ROOT_CLASS_NAME = "GetCharactersResponse";
    private static String PACKAGE_NAME = "com.vairix.marveladapter.model";
    private static String INPUT_JSON_PATH = "src/main/java/com/vairix/marveladapter/model/modelexample.json";
    private static String OUTPUT_CLASS_DIRECTORY = "src/main/java";
    public static void main(String[] args) throws IOException {
        JCodeModel jcodeModel = new JCodeModel();

        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() {
                return true;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSON;
            }
        };

        Path filePath = Path.of(INPUT_JSON_PATH);
        String content = Files.readString(filePath);

        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        mapper.generate(jcodeModel, ROOT_CLASS_NAME, PACKAGE_NAME, content);

        var fileOut = new File(OUTPUT_CLASS_DIRECTORY);
        jcodeModel.build(fileOut);

        SpringApplication.run(GenerateModelFromJSON.class, args);
    }

}
