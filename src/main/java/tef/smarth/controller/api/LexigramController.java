package tef.smarth.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tef.smarth.api.lexigram.LexigramClient;

@RestController
@RequestMapping("/api")
public class LexigramController {

    @Autowired
    LexigramClient lexigramClient;

    @GetMapping("/lexigram")
    public Object getLexi() {
        return lexigramClient.exampleConceptAncestors();
    }
    ///error
    @GetMapping("/lexigram1")
    public Object getLexi1() {
        return lexigramClient.exampleEntityExtraction();
    }
///error
    @GetMapping("/lexigram2")
    public Object getLexi2() {
        return lexigramClient.exampleHighlightEntities();
    }

    @GetMapping("/lexigram3")
    public Object getLexi3() {
        return lexigramClient.exampleConcept();
    }

    @GetMapping("/lexigram4")
    public Object getLexi4() {
        return lexigramClient.exampleConceptDescendants();
    }

    @GetMapping("/lexigram5")
    public Object getLexi5() {
        return lexigramClient.exampleSearchConcepts();
    }
}
