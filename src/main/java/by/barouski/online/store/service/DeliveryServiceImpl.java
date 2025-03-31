package by.barouski.online.store.service;

import by.barouski.online.store.entity.Delivery;
import by.barouski.online.store.entity.DeliveryType;
import by.barouski.online.store.repo.DeliveryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Slf4j
@Service
public class DeliveryServiceImpl implements DeliveryService{
    private final DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public Delivery createDelivery (DeliveryType deliveryType, String address){
        Delivery delivery = new Delivery();
       // delivery.setDelivery_date(Date.from(Instant.now().plus(Duration.ofDays(3))));
        delivery.setDeliveryCost(0L);
        delivery.setDeliveryType(deliveryType);// сделать энам
        delivery.setAddress(address);
        deliveryRepository.save(delivery);
        return delivery;
    }
}
