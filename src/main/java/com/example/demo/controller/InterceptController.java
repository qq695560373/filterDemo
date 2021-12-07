package com.example.demo.controller;

import com.example.demo.filter.CustomerFilter;
import com.example.demo.filter.FilterConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laogao
 * @date 2021/12/6 14:39
 */

@RestController
@RequestMapping("/intercept")
public class InterceptController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerFilter.class);
    @PostMapping(value = "/body", consumes = { MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String body(@RequestBody MsgBody msg) {
        logger.info("msg:{}", msg);
        return msg == null ? "<EMPTY>" : msg.getContent();
    }

    public static class MsgBody {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}
