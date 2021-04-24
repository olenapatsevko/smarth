package tef.smarth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tef.smarth.entity.RecordEntity;
import tef.smarth.entity.UserEntity;
import tef.smarth.repository.RecordRepository;
import tef.smarth.service.MailService;

import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static tef.smarth.utils.DateUtil.getFormattedCurrentDate;

@Service
public class MailServiceImpl implements MailService {


    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private JavaMailSender emailSender;

    public void sendMailWithAttachment(UserEntity user) {
        try {
            emailSender.send(createMailForUser(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private SimpleMailMessage createMailForUser(UserEntity userEntity) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(userEntity.getEmail());
        message.setSubject("Smarth summary from " + getFormattedCurrentDate());
        message.setText(MessageFormat.format("{0} {1} \nborn: {2} \nsex: {3}\nhas such records and calculations {4}",
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getBirthday().toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
                userEntity.getSex().displayName,
                getCalculations(userEntity))
        );
        return message;
    }

    private String getCalculations(UserEntity userEntity) {
        List<RecordEntity> records = recordRepository.findAllByUserId(userEntity.getId());
        StringBuilder result = new StringBuilder();
        records.forEach(record -> result.append(MessageFormat.format("\n {0} {1} {2} {3}", record.getName(), record.getValue(), record.getMeasurement(), record.getDate().toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE))));
        return result.toString();
    }
}
