package order;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "SimpleOrder")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    @Id
    private UUID id;
    private String location;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", items=" + items +
                '}';
    }
}
