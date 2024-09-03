package alex.s5l1Bend.entities;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Ordine {
    private int orderNumber;
    private Tavolo tavolo;
    private List<Pizza> pizzas;
    private List<Drink> drinks;
    private statoOrdine status;
    private int coperti;
    private LocalDateTime oraOrdine;
    @Value("${costo.coperto}")
    private double costoCoperto;

    public Ordine(int orderNumber, Tavolo table, int coperti) {
        this.orderNumber = orderNumber;
        this.tavolo = table;
        this.coperti = coperti;
        this.pizzas = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.status = statoOrdine.IN_CORSO;
        this.oraOrdine = LocalDateTime.now();
    }

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }

    public double getTotalAmount() {
        double total = pizzas.stream().mapToDouble(Pizza::getTotalPrice).sum() +
                drinks.stream().mapToDouble(Drink::getPrice).sum();
        total += coperti * costoCoperto;
        return total;
    }

    @Override
    public String toString() {
        StringBuilder orderDescription = new StringBuilder("Ordine #" + orderNumber + " - " + status + "\n");
        orderDescription.append("Tavolo: ").append(tavolo.getNTavolo()).append("\n");
        orderDescription.append("Coperti: ").append(coperti).append("\n");
        orderDescription.append("Ora Ordine: ").append(oraOrdine).append("\n");
        orderDescription.append("Piatti:\n");
        pizzas.forEach(pizza -> orderDescription.append(pizza.toString()).append("\n"));
        orderDescription.append("Bevande:\n");
        drinks.forEach(drink -> orderDescription.append(drink.toString()).append("\n"));
        orderDescription.append("Prezzo totale: €").append(String.format("%.2f", getTotalAmount())).append("\n");
        return orderDescription.toString();
    }
}
