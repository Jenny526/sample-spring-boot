package com.tool;

import com.tool.model.*;
import edu.washington.cs.knowitall.extractor.ReVerbExtractor;
import edu.washington.cs.knowitall.extractor.conf.ConfidenceFunction;
import edu.washington.cs.knowitall.extractor.conf.ReVerbOpenNlpConfFunction;
import edu.washington.cs.knowitall.nlp.ChunkedSentence;
import edu.washington.cs.knowitall.nlp.OpenNlpSentenceChunker;
import edu.washington.cs.knowitall.nlp.extraction.ChunkedBinaryExtraction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SampleRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleRestApiApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/reverb")
    public ReverbRes reverb(@RequestBody String sentenceStr) {

        ReverbRes reverbRes = new ReverbRes();

        try {
            // Looks on the classpath for the default model files.
            OpenNlpSentenceChunker chunker = new OpenNlpSentenceChunker();
            ChunkedSentence sent = chunker.chunkSentence(sentenceStr);

            List<Sentence> sentences = new ArrayList<>();
            // (token, tag, chunk-tag) for the sentence
            for (int i = 0; i < sent.getLength(); i++) {
                String token = sent.getToken(i);
                String posTag = sent.getPosTag(i);
                String chunkTag = sent.getChunkTag(i);
                Sentence sentence = new Sentence(token, posTag, chunkTag);
                sentences.add(sentence);
            }
            reverbRes.setSentences(sentences);

            // extractions from the sentence.
            List<Extraction> extractions = new ArrayList<>();
            ReVerbExtractor reverb = new ReVerbExtractor();
            ConfidenceFunction confFunc = new ReVerbOpenNlpConfFunction();
            for (ChunkedBinaryExtraction extr : reverb.extract(sent)) {
                double conf = confFunc.getConf(extr);

				ChunkedArgumentExtraction arg1 = new ChunkedArgumentExtraction();
                if(extr.getArgument1() != null && extr.getArgument1().getRelation() != null) {
					ChunkedExtraction arg1Rel = new ChunkedExtraction(extr.getArgument1().getRelation().getRange(),
							extr.getArgument1().getRelation().getSentence(),
							extr.getArgument1().getRelation().getTokensAsString(),
							extr.getArgument1().getRelation().getOffsets());
					arg1 = new ChunkedArgumentExtraction(arg1Rel, extr.getArgument1().getConfidence());
				}

				ChunkedArgumentExtraction arg2 = new ChunkedArgumentExtraction();
				if(extr.getArgument2() != null && extr.getArgument2().getRelation() != null) {
					ChunkedExtraction arg2Rel = new ChunkedExtraction(extr.getArgument2().getRelation().getRange(),
							extr.getArgument2().getRelation().getSentence(),
							extr.getArgument2().getRelation().getTokensAsString(),
							extr.getArgument2().getRelation().getOffsets());
					arg2 = new ChunkedArgumentExtraction(arg2Rel, extr.getArgument2().getConfidence());
				}

				ChunkedExtraction rel = new ChunkedExtraction();
				if(extr.getRelation() != null) {
					rel = new ChunkedExtraction(extr.getRelation().getRange(), extr.getRelation().getSentence(),
							extr.getRelation().getTokensAsString(), extr.getRelation().getOffsets());
				}
                Extraction extraction = new Extraction(arg1, arg2, rel, conf);
                extractions.add(extraction);
            }
            reverbRes.setExtractions(extractions);
        } catch (Exception e) {
            System.out.println("has exception: " + e);
        }

        return reverbRes;
    }
}
