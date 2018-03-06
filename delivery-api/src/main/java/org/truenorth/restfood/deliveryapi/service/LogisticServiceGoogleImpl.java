package org.truenorth.restfood.deliveryapi.service;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.Duration;
import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.truenorth.restfood.deliveryapi.entity.OrderEntity;
import org.truenorth.restfood.deliveryapi.entity.RestaurantEntity;
import org.truenorth.restfood.deliveryapi.exception.LogisticServiceException;
import org.truenorth.restfood.deliveryapi.exception.OrderServiceException;
import org.truenorth.restfood.deliveryapi.repository.OrderRepository;
import org.truenorth.restfood.deliveryapi.repository.RestaurantRepository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Date;

@Service
public class LogisticServiceGoogleImpl implements LogisticService {

    private GeoApiContext context;

    @PostConstruct
    public void init(){
        if(context==null) {
            synchronized (this) {
                if(context==null) {
                    context = new GeoApiContext.Builder()
                            .apiKey("AIzaSyBU6sSVUzpGim-aRdPjpzWWrFtDpDLR_cM")
                            .build();
                }
            }
        }
    }

    @Override
    public String calculateETA(OrderEntity order) throws LogisticServiceException {
        if(validateOrder(order)){
            try {
                LatLng latlonOrigin = new LatLng();
                latlonOrigin.lat = order.getRestaurant().getLatitud();
                latlonOrigin.lng = order.getRestaurant().getLongitud();
                LatLng latlonDestination = new LatLng();
                latlonDestination.lat = order.getRestaurant().getLatitud();
                latlonDestination.lng = order.getRestaurant().getLongitud();
                DistanceMatrix distanceMatrix = DistanceMatrixApi.newRequest(context).origins(latlonOrigin).destinations(latlonDestination).await();
                if(distanceMatrix.rows.length>0 && distanceMatrix.rows[0].elements.length>0){
                    Duration duration = distanceMatrix.rows[0].elements[0].duration;
                    return duration.humanReadable;
                }else{
                    throw new LogisticServiceException("Distance couldn't be calculated");
                }
            }catch(IOException e){
                throw new LogisticServiceException(e.getMessage(),e);
            } catch (InterruptedException e) {
                throw new LogisticServiceException(e.getMessage(),e);
            } catch (ApiException e) {
                throw new LogisticServiceException(e.getMessage(),e);
            }
        }
        return "";
    }

    private boolean validateOrder(OrderEntity order) throws LogisticServiceException {
        if(order!=null){
            //No delivery for Greenwich and Ecuador ;)
            if(order.getLatitud() != 0 && order.getLongitud() != 0){
                if(order.getRestaurant().getLatitud() != 0 && order.getRestaurant().getLongitud() != 0) {
                    return true;
                }else{
                    throw new LogisticServiceException("Restaurant error, no lat,lon: " + order);
                }
            }else{
                throw new LogisticServiceException("Order error, no lat,lon: " + order);
            }
        }else{
            throw new LogisticServiceException("Order is null or empty: " + order);
        }
    }
}