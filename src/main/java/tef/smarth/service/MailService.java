package tef.smarth.service;

import tef.smarth.entity.UserEntity;


public interface MailService {
    void sendMailWithAttachment( UserEntity user) ;
}
