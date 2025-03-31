package by.barouski.online.store.service.dto;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class OrderHistoryDTO {

    private Long orderHistoryId;

    private List<OrderDTO> orderingList;


}
