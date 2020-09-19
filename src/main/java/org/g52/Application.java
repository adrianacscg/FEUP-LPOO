package org.g52;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.g52.data.ArenaModel;
import org.g52.data.CubeModel;
import org.g52.data.OverlayModel;
import org.g52.data.PlayerModel;
import org.g52.gui.ArenaView;
import org.g52.gui.ViewFactory;
import org.g52.rules.*;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        PlayerModel playerModel = new PlayerModel(0,0);
        CubeModel cubeModel = new CubeModel();
        ArenaModel arena = new ArenaModel(60, 30, playerModel, cubeModel, new OverlayModel());

        ViewFactory viewFactory = new ViewFactory();
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(60, 30));
        Terminal terminal = terminalFactory.createTerminal();
        ArenaView gui = new ArenaView(new TerminalScreen(terminal), viewFactory);

        ControllerFactory controllerFactory = new ControllerFactory();
        ArenaController controller = new ArenaController(gui, arena, controllerFactory);
        controller.start();
    }
}
