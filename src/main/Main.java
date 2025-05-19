package main;


import examples.ConsoleStylingExample;
import examples.StringManipulation;
import examples.UserInputExample;
import utils.Color;
import utils.StringStyling;
import utils.Style;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // you can safely remove those examples lines
//        StringManipulation.Example();
//        ConsoleStylingExample.Example();
//        UserInputExample.Example();

        System.out.println(StringStyling.StyleString("Starting...", Style.ITALIC, Color.BLACK));

        
        Game game = new Game();
        game.run();
        System.out.println(StringStyling.StyleString("Terminating...", Style.ITALIC, Color.BLACK));

        /* ZONE POUR LES TESTS */
        Map map = new Map();
        Location l1 = new Location("kitcehn", "oewifji", false);
        Location l2 = new Location("kitcehn", "oewifji", true);

        map.addLocation(l1, 2, 2);
        map.addLocation(l2, 2, 3);
        System.out.println(Arrays.toString(map.getLocationCoords(l2, map.getAllLocations())));
        System.out.println(map.getAllLocations().get(2).size());

        /* FIN DE LA ZONE POUR LES TESTS */
    }
}
// TODO : créer les classes, pour l'instant Map, Location, Player, et tout ce qu'il faut pour Move en priorité
// TODO : voir aussi pour l'organisation des fichiers (créer des packages, dossiers?)
