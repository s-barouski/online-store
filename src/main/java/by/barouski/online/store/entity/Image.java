package by.barouski.online.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Image {
    @Id
    private UUID id;
    private String pathToFile;
    private String originalName;
    private String contentType;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;


}
