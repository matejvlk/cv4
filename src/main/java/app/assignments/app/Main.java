package app.assignments.app;

import app.assignments.configuration.AppConfig;
import app.assignments.message.Message;
import app.assignments.writer.ListWriter;
import app.assignments.writer.Writer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Message ping = (Message) applicationContext.getBean("pingMessage");
        Message hello = (Message) applicationContext.getBean("customMessage");
        Message pingReply = (Message) applicationContext.getBean("replyMessage");

        Writer stdoutWriter = (Writer) applicationContext.getBean("stdoutWriter");
        Writer listWriter = (Writer) applicationContext.getBean("listWriter");
        stdoutWriter.write(ping);
        stdoutWriter.write(hello);
        stdoutWriter.write(pingReply);


        listWriter.write(ping);
        ((ListWriter) listWriter).listWrittenMessages().forEach(stdoutWriter::write);

    }

}
