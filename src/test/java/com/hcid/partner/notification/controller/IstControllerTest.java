package com.hcid.partner.notification.controller;

import com.usermanagement.controller.IstProducerController;
import com.usermanagement.dto.FirebaseResponse;
import com.usermanagement.dto.IstRequest;
import com.usermanagement.entity.User;
import com.usermanagement.service.SmsQueueService;
import com.usermanagement.service.messaging.IstServiceProducer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class IstControllerTest {

    @InjectMocks
    IstProducerController istProducerController;

    @Mock
    IstServiceProducer istServiceProducer;
    @Mock
    SmsQueueService smsQueueService;

    IstRequest request = new IstRequest();
    FirebaseResponse firebaseResponse = new FirebaseResponse();
    User sms2  = new User();

    @Test
    public void sendEmail_Success() throws Exception {
    	istServiceProducer.send(request);
    	istProducerController.sendToIst(request);
    }

    @Test
    public void sendEmail_Failed() throws Exception {
        Mockito.doNothing().doThrow(new Exception());
        istProducerController.sendToIst(request);
    }

   
}