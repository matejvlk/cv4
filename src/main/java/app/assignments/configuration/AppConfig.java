package app.assignments.configuration;

import app.assignments.message.CustomMessage;
import app.assignments.message.PingMessage;
import app.assignments.message.ReplyMessage;
import app.assignments.writer.ListWriter;
import app.assignments.writer.StdoutWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("app.assignments")
public class AppConfig {

    @Autowired
    @Qualifier("pingMessage")
    public PingMessage pingMessage;


    @Bean
    public CustomMessage customMessage(){
        return new CustomMessage("Jan", "Josef", "Hello there!");
    }

    @Bean
    public PingMessage pingMessage(){
        return new PingMessage();
    }

    @Bean
    public ReplyMessage replyMessage(){
        return new ReplyMessage(pingMessage, "Reply text");
    }

    @Bean
    public ListWriter listWriter(){
        return new ListWriter();
    }

    @Bean
    public StdoutWriter stdoutWriter(){
        return new StdoutWriter();
    }

}
