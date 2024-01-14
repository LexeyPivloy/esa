package com.example.lab3.services;

import com.example.lab3.utils.ObjectToDomTransformer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.lab3.repositories.DirectorRepository ;
import com.example.lab3.models.DirectorEntity;
import com.example.lab3.models.dto.DirectorRequest;
import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class DirectorService {

    private final ObjectMapper objectMapper;

    private final DirectorRepository directorRepository;

    @SneakyThrows
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(directorRepository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<String> create(DirectorRequest directorRequest){
        DirectorEntity director = new DirectorEntity(randomUUID(), directorRequest.getName());
        directorRepository.save(director);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(UUID director_id) {
        directorRepository.deleteById(director_id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public String getDirectors(Model model) throws Exception {

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element element = document.createElement("directors");
        ObjectToDomTransformer transformer = new ObjectToDomTransformer(document);

        List<DirectorEntity> directors = directorRepository.findAll();
        for (DirectorEntity director : directors) {

            transformer.transform(element, director, "director");
        }

        model.addAttribute("directors", element);
        return "directors";
    }

}
