package com.summerboot.restservice.controller;

import com.summerboot.restservice.dto.Greeting;
import com.summerboot.restservice.dto.TemplateIdMapDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) throws Exception {
        if (name.equals("error")) {
            throw new Exception("error");
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/maps")
    public void addMaps(@RequestBody TemplateIdMapDto templateIdMapDto){
        System.out.println(templateIdMapDto.getTemplateMap() + " " + templateIdMapDto.isAppend());
    }

    @GetMapping("/error")
    public Greeting error() {

        return new Greeting(counter.incrementAndGet(), "you meet an error!");
    }

    @PostMapping("/upSMS")
    public void receiveHWSms(@RequestParam String smsMsgId,    //	上行短信的唯一标识。
                             @RequestParam String from,    //	上行短信发送方的号码。
                             @RequestParam String to,    //	上行短信接收方的号码。
                             @RequestParam String body,    //	上行短信发送的内容。

                             //	上行短信创建时间，即短信平台接收到用户发送的上行短信的时间（采用标准UTC格式，例如：2018-02-12T15:30:20Z。不同编程语言中的时间格式转换方式不同，部分语言可参考表 不同编程语言的时间格式）。
                             //	在控制台创建应用时配置需要“接收上行短信回复时间”后，平台才会在Body中附带此字段，该字段只对http协议的短信生效。
                             @RequestParam(required = false) String createTime) {
        System.out.println(smsMsgId);
        System.out.println(from);
        System.out.println(to);
        System.out.println(body);
        System.out.println(createTime);
    }

    /**
     * 同步短信回执
     */
    @PostMapping("/smsStatusReport")
    public void smsHWReport(@RequestParam String smsMsgId,  //	发送短信成功时返回的短信唯一标识。
                            @RequestParam(required = false) String total,     //	长短信拆分后的短信条数。当短信未拆分时该参数取值为1。
                            @RequestParam(required = false) String sequence,  //	长短信拆分后的短信序号，当total参数取值大于1时，该参数才有效。当短信未拆分时该参数取值为1。
                            @RequestParam String status,    //	短信状态报告枚举值，常见取值请参考表4，处理方法请参考状态报告错误码。
                            @RequestParam(required = false) String source,    //	短信状态报告来源：1：短信平台自行产生的状态报告。2：短信中心返回的状态报告。3：华为平台产生的状态报告。
                            @RequestParam(required = false) String updateTime,//	短信资源的更新时间，通常为短信平台接收短信状态报告的时间，为UTC时间，格式为：yyyy-MM-dd'T'HH:mm:ss'Z'，该时间会通过urlencode转义为%3a。//	当短信平台未收到短信中心上报的状态报告时，会自行构造状态报告，该状态报告中不携带“updateTime”参数。
                            @RequestParam(required = false) String orgCode,   //	透传南向网元状态码，仅国际/港澳台短信状态报告携带，国内短信不涉及。//	当南向网元未返回状态码时不携带该参数。
                            @RequestParam(required = false) String extend,    //	扩展字段，由用户在发送短信的请求中携带。若用户发送短信时未携带extend参数，则状态报告中也不会携带extend参数。
                            @RequestParam(required = false) String to) {      //	本条状态报告对应的短信的接收方号码，仅当状态报告中携带了extend参数时才会同时携带该参数。
        String formattedTime = getFormattedTime(updateTime);
        System.out.println(formattedTime);
        System.out.println(total);
        System.out.println(smsMsgId);
        System.out.println(status);
        System.out.println(to);
        System.out.println(sequence);
    }

    //将带有T的时间字符串转换成yyyy-MM-dd HH:mm:ss
    public static String getFormattedTime(String strDate) {
        try {
            //创建对应的pattern，注意T和Z两个字符使用单引号引起来，毫秒值使用大写S表示
            DateTimeFormatter inputPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
            DateTimeFormatter outputPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            //字符串时间转换成时间类型
            LocalDateTime date = LocalDateTime.parse(strDate, inputPattern);
            Instant instant = date.toInstant(ZoneOffset.UTC);
            LocalDateTime time = LocalDateTime.ofInstant(instant, ZoneId.of("GMT+08:00"));
            return time.format(outputPattern);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return strDate;
    }
}
