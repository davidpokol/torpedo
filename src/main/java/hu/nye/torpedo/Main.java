package hu.nye.torpedo;

import hu.nye.torpedo.service.exeption.FileDataException;
import hu.nye.torpedo.service.exeption.FileReadException;
import hu.nye.torpedo.service.game.GameController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Entry point.
 **/
public class Main {

    public static void main(String[] args) throws FileReadException, FileDataException {

        ApplicationContext context = new AnnotationConfigApplicationContext("hu.nye.torpedo");
        GameController gameController = context.getBean(GameController.class);
        gameController.start();
    }

}
