package web.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "series", nullable = false)
    private int series;

    @Column(name = "color", nullable = false)
    private String color;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
        this.color = "light grey"; //because I like this color!
    }

    @Override
    public String toString() {

        return "model: " + model + ", series: " + series + ", color (are you ready?): " + color + " (surprised by the color?)";
    }
}
