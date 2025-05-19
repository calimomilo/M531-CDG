package main;


import examples.ConsoleStylingExample;
import examples.StringManipulation;
import examples.UserInputExample;
import utils.Array2Dprinter;
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
        Location l1 = new Location("kitchen", "oewifji", false);
        Location l2 = new Location("Living Room", "oewifji", false);
        Location l3 = new Location("Bedroom", "oewifji", false);
        Location l4 = new Location("Entrance Hall", "oewifji", false);
        Location l5 = new Location("Bathroom", "oewifji", false);
        Location l6 = new Location("Hallway", "oewifji", false);
        Location l7 = new Location("Hallway", "oewifji", false);

        map.addLocation(l1, 2, 3);
        map.addLocation(l2, 2, 2);
        map.addLocation(l3, 0, 1);
        map.addLocation(l4, 1, 0);
        map.addLocation(l5, 2, 0);
        map.addLocation(l6, 1, 1);
        map.addLocation(l7, 1, 2);
        System.out.println(Arrays.toString(map.getLocationCoords(l2, map.getAllLocations())));
        System.out.println(map.getAllLocations().get(0).size());
        System.out.println(map.getAllLocations().get(1).size());
        System.out.println(map.getAllLocations().get(2).size());

        System.out.println(map.getLocationCoords(l5, map.getAllLocations())[0]);
        System.out.println(map.getLocationCoords(l5, map.getAllLocations())[1]);

        System.out.println(Array2Dprinter.print2DArray(Array2Dprinter.convert2DArray(map.getAllLocations()), map.getLocationCoords(l5, map.getAllLocations())[0], map.getLocationCoords(l5, map.getAllLocations())[1]));

        /* FIN DE LA ZONE POUR LES TESTS */
    }
}
// TODO : créer les classes, pour l'instant Map, Location, Player, et tout ce qu'il faut pour Move en priorité
// TODO : voir aussi pour l'organisation des fichiers (créer des packages, dossiers?)
