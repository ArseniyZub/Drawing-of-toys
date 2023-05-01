import java.util.UUID;

public class Toys {
    
    private final UUID id;
    private String name;
    private int quantity;
    private int chance;

    public Toys(String name, int quantity, int chance) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.quantity = quantity;
        this.chance = chance;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getChance() {
        return chance;
    }

    @Override
    public String toString() {
        return String.format("\n-----------------------------\n" +
                             "Id - " + id +
                             "\nName - " + name +
                             "\nChance - " + chance);
    }
}