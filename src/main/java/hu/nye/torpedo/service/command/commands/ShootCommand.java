package hu.nye.torpedo.service.command.commands;

import hu.nye.torpedo.model.GameState;
import hu.nye.torpedo.service.command.Command;
import hu.nye.torpedo.service.game.GameCycle;
import hu.nye.torpedo.service.game.GameManager;
import hu.nye.torpedo.service.input.DataReader;
import hu.nye.torpedo.service.util.CpuPointGeneratorUtil;
import hu.nye.torpedo.service.util.PointValidatorUtil;
import hu.nye.torpedo.service.util.ShipReferenceUtil;

/**
 * This class managing the user's shots. The user can shoot at a location of the cpu's map.
 */
public class ShootCommand implements Command {

    private final GameState gameState;
    private final GameManager gameManager;
    private final DataReader reader;
    private final ShipReferenceUtil shipReferenceUtil;
    private final CpuPointGeneratorUtil cpuPointGenerator;
    private final PointValidatorUtil pointValidator;
    private final GameCycle gameCycle;
    private final ShowCommand showCommand;

    public ShootCommand(GameState gameState, GameManager gameManager, DataReader reader, ShipReferenceUtil
            shipReferenceUtil, CpuPointGeneratorUtil cpuPointGenerator,
                        PointValidatorUtil pointValidator, GameCycle gameCycle, ShowCommand showCommand) {
        this.gameState = gameState;
        this.gameManager = gameManager;
        this.reader = reader;
        this.shipReferenceUtil = shipReferenceUtil;
        this.cpuPointGenerator = cpuPointGenerator;
        this.pointValidator = pointValidator;
        this.gameCycle = gameCycle;
        this.showCommand = showCommand;
    }

    public static final String COMMAND = "SHOOT";

    @Override
    public boolean canProcess(String input) {
        return COMMAND.equalsIgnoreCase(input);
    }

    @Override
    public void process(String input) {

        int[] userChoice;
        do {
            showCommand.process("String");
            do {
                System.out.println("Please enter a location to fire at: ");
                String choice = reader.readInput();
                userChoice = shipReferenceUtil.formatOption(choice);

            } while (!pointValidator.isContinue(userChoice, gameState.getCurrentUserMap()));
        } while (gameManager.fireAtPoint(userChoice));

        //cpu's turn
        int[] cpuChoice;
        do {
            cpuChoice = cpuPointGenerator.generate();
        } while (gameManager.cpuShoot(cpuChoice));

        showCommand.process("String");

        gameState.setShouldExit(!gameCycle.isInGame());
    }
}
