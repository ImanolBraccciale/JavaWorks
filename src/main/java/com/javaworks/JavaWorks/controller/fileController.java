package com.javaworks.JavaWorks.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/files")
public class fileController {
    private static final Logger logger = LoggerFactory.getLogger(fileController.class);

    //ObjectMapper una clase de Jackson que permite convertir entre JSON y objetos de Java.
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {

        try {
            // Leer el contenido del archivo como cadena
            String fileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
            logger.debug("File content as text: {}", fileContent);



            // Verificar si el archivo tiene texto
            if (fileContent.trim().isEmpty()) {
                logger.error("El archivo está vacío.");
                return ResponseEntity.badRequest().body("El archivo está vacío.");
            }


            ObjectNode jsonResponse = objectMapper.createObjectNode();
            jsonResponse.put("content", fileContent); // Agregar el contenido del archivo al campo "content"

            // Devolver el objeto JSON con el contenido del archivo
            logger.info("Archivo convertido correctamente a JSON.");
            return ResponseEntity.ok().body(jsonResponse);

        } catch (IOException e) {
            // Error al leer el archivo
            logger.error("Error leyendo el archivo: {}", e.getMessage());
            return ResponseEntity.status(500).body("Error al leer el archivo.");
        }
    }


}