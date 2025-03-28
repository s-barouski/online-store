package by.barouski.online.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "path_to_file")
    private String pathToFile;
    @Column(name = "original_file_name")
    private String originalName;
    @Column(name = "content_type")
    private String contentType;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}
