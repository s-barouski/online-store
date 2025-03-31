package by.barouski.online.store.service;

import by.barouski.online.store.entity.Delivery;
import by.barouski.online.store.entity.DeliveryType;

public interface DeliveryService {
    Delivery createDelivery (DeliveryType deliveryType, String address);
}
