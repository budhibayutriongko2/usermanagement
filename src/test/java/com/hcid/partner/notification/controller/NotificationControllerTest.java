package com.hcid.partner.notification.controller;

import com.usermanagement.controller.UserController;
import com.usermanagement.dto.FirebaseResponse;
import com.usermanagement.dto.Request;
import com.usermanagement.entity.User;
import com.usermanagement.service.UserService;
import com.usermanagement.service.SmsQueueService;
import com.usermanagement.service.messaging.SMSQueueSenderService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class NotificationControllerTest {

    @InjectMocks
    UserController notificationController;

    @Mock
    UserService notificationService;
    @Mock
    SmsQueueService smsQueueService;
    @Mock
    SMSQueueSenderService senderService;

    Request request = new Request();
    FirebaseResponse firebaseResponse = new FirebaseResponse();
    User sms2  = new User();

    @Test
    public void sendEmail_Success() throws Exception {
        notificationService.sendEmail(request);
        notificationController.sendEmail(request);
    }

    @Test
    public void sendEmail_Failed() throws Exception {
        Mockito.doNothing().doThrow(new Exception());
        notificationController.sendEmail(request);
    }

    @Test
    public void sendSMS_MSS() throws Exception {
        Mockito.when(notificationService.sendSmsMSS(request)).thenReturn(sms2);
        notificationController.sendSMS(request);
    }

    @Test
    public void pushNotification_Success() throws Exception {
        Mockito.when(notificationService.sendNotificationIncentive()).thenReturn(firebaseResponse);
        notificationController.pushNotification();
    }

    @Test
    public void pushNotification_Failed() throws Exception {
        Mockito.doNothing().doThrow(new Exception());
        notificationController.pushNotification();
    }

    @Test
    public void sendNotification_Success() throws Exception {
        Mockito.when(notificationService.sendNotificationSpecific(request)).thenReturn(firebaseResponse);
        notificationController.sendNotification(request);
    }

    @Test
    public void sendNotification_Failed() throws Exception {
        Mockito.doNothing().doThrow(new Exception());
        notificationController.sendNotification(request);
    }
    
    @Test
    public void sendSmsJms_Success() throws Exception {
    	senderService.sendSmsMessage(request);
        notificationController.sendSmsJms(request);
    }
}