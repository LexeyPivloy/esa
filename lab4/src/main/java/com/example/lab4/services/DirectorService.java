package com.example.lab4.services;

import com.example.lab4.models.AuditEvent;
import com.example.lab4.models.DirectorEntity;
import com.example.lab4.models.dto.DirectorRequest;
import com.example.lab4.repositories.DirectorRepository;
import com.example.lab4.utils.ObjectToDomTransformer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import com.example.lab4.utils.EventLogger;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class DirectorService {

    private final ObjectMapper objectMapper;

    private final EventLogger eventLogger;

    private final DirectorRepository directorRepository;

    @SneakyThrows
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(directorRepository.findAll()), HttpStatus.OK);
    }

    public ResponseEntity<String> create(DirectorRequest directorRequest){
        DirectorEntity director = new DirectorEntity(randomUUID(), directorRequest.getName());
        directorRepository.save(director);
        eventLogger.log(director, AuditEvent.CREATE);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public ResponseEntity<String> delete(UUID director_id) {
        DirectorEntity director = new DirectorEntity(director_id, directorRepository.getReferenceById(director_id).getName());
        eventLogger.log(director, AuditEvent.DELETE);
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
