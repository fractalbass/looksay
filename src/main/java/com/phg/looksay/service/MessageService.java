package com.phg.looksay.service;

import com.phg.looksay.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by milesporter on 2/20/17.
 */
@Component
public class MessageService {

    @Autowired
    MessageDao mDao;

    String getMessage(int id) {
        return mDao.get(id);
    }

    int saveMessage(int id, String message) {
        return mDao.save(id, message);
    }

}
