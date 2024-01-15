package es.intricom.pruebaconcepto.ejb.facade;


import es.intricom.pruebaconcepto.ejb.interceptor.ExceptionTranslate;
import es.intricom.pruebaconcepto.ejb.interceptor.Logged;
import es.intricom.pruebaconcepto.service.facade.HotelBookingServiceFacade;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Logged
@ExceptionTranslate
@Stateless
@Local( HotelBookingServiceFacade.class)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class HotelBookingServiceFacadeBean implements  HotelBookingServiceFacade{
}
