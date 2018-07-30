package org.nankong.igniteweb.controller;

import org.nankong.igniteweb.dao.repository.CustRepository;
import org.nankong.igniteweb.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private CustRepository custRepo;
    //映射一个action
    @RequestMapping("/index")
    public  String index(){
        //输出日志文件
        logger.info("the first jsp pages");
        //返回一个index.jsp这个视图
        Customer customer = custRepo.getCustomerByCustName("miwutkjgmp");
        logger.info(customer.toP9String());
        return "index";
    }
}
