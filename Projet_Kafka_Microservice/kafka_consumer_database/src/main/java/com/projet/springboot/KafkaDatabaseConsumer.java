package com.projet.springboot;

import com.projet.springboot.entity.ProjetData;
import com.projet.springboot.repository.ProjetDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private ProjetDataRepository dataRepository;

    public KafkaDatabaseConsumer(ProjetDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(
            topics = "projet_recentchange",
            groupId = "myGroup"
    )
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event message received -> %s", eventMessage));

        ProjetData projetData = new ProjetData();
        projetData.setProjetEventData(eventMessage);
        dataRepository.save(projetData);

    }
}
