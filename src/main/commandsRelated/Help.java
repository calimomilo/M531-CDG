package main.commandsRelated;

import java.util.Map;

public class Help extends Command {
    public Help(String verb, String description) {
        super(verb, description);
    }

    @Override
    public void execute(String[] args) {
        if(args[0].isEmpty()){
            for (Map.Entry<String, Command> entry : )
        }
    }
}
