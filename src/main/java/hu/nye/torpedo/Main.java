package hu.nye.torpedo;

import hu.nye.torpedo.service.game.GameController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main class, that holds the main method.
 */
public class Main {
    /**
     * The main method.
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("hu.nye.torpedo");
        GameController gameController = context.getBean(GameController.class);
        gameController.start();
    }
}
