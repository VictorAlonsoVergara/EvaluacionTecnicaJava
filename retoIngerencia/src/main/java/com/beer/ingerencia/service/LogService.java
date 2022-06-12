package com.beer.ingerencia.service;

import com.beer.ingerencia.dao.LogDAO;
import com.beer.ingerencia.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    @Autowired
    private LogDAO logDAO;

    public Log insertLog(Log log)
    {
        return logDAO.save(log);
    }
}
