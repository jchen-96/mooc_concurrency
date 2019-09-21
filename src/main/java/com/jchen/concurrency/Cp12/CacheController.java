package com.jchen.concurrency.Cp12;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cache")
public class CacheController {
    @Autowired
    private RedisClient redisClient;

    @ResponseBody
    @RequestMapping("/set")
    public String set(@RequestParam("k")String k,@RequestParam("v")String value) throws Exception{
        redisClient.set(k, value);
        return "success write";
    }

    @ResponseBody
    @RequestMapping("/get")
    public String set(@RequestParam("k")String k) throws Exception{
        return redisClient.get(k);
    }




}
