package alex.s5l1Bend;

import alex.s5l1Bend.entities.Menu;
import alex.s5l1Bend.entities.Ordine;
import alex.s5l1Bend.entities.Tavolo;
import alex.s5l1Bend.entities.statoOrdine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Cassa implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Cassa.class);

    @Autowired
    private Menu menu;

    @Override
    public void run(String... args) throws Exception {

        Tavolo tavolo = new Tavolo(1, 4);
        tavolo.occupa();

        Ordine ordine = new Ordine(1, tavolo, 4);

        // PIZZE
        ordine.addPizza(menu.getPizzas().get(0)); // Margherita
        ordine.addPizza(menu.getPizzas().get(1)); // Hawaiana
        ordine.addPizza(menu.getPizzas().get(3)); // XL pr e funghi

        //DRINKS
        ordine.addDrink(menu.getDrinks().get(0)); // Limonata
        ordine.addDrink(menu.getDrinks().get(2)); //vino x2
        ordine.addDrink(menu.getDrinks().get(2));

        // STAMPA
        logger.info(ordine.toString());
        ordine.setStatus(statoOrdine.PRONTO);
        logger.info(ordine.toString());
    }

}
