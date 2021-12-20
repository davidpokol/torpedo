package hu.nye.torpedo.configuration;

import hu.nye.torpedo.model.player.Players;
import hu.nye.torpedo.persistance.xml.XmlHighScoreManager;
import hu.nye.torpedo.persistance.xml.XmlHighScoreRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for XML manager classes.
 */
@Configuration
public class XmlRepositoryConfig {

    @Bean
    XmlHighScoreManager xmlHighScoreManager(Players players) {
        return new XmlHighScoreManager(players);
    }

    @Bean
    XmlHighScoreRepository highScoreRepository(Players players, Marshaller marshaller, Unmarshaller unmarshaller,
                                               XmlHighScoreManager xmlHighScoreManager) {
        return new XmlHighScoreRepository(players, marshaller, unmarshaller, xmlHighScoreManager);
    }

    @Bean
    Marshaller marshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Players.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        return marshaller;
    }

    @Bean
    Unmarshaller unmarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Players.class);

        return jaxbContext.createUnmarshaller();
    }
}
