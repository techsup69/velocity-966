package com.abc.velocity.example.v966_17;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.runtime.RuntimeInstance;
import org.apache.velocity.runtime.parser.ParseException;
import org.apache.velocity.runtime.parser.node.SimpleNode;

import java.io.StringWriter;

public class App17 {

    public static void main(String[] args) throws ParseException {
        final RuntimeInstance runtimeInstance = new RuntimeInstance();
        final VelocityContext context         = new VelocityContext();
        context.put("user", "abc");

        final SimpleNode parsedTemplate = runtimeInstance.parse("Hello $user !!!", "a_template");

        //first time using parsed template
        final StringWriter writer = new StringWriter();
        runtimeInstance.render(context, writer, "logTag", parsedTemplate);
        System.out.println(writer);

        //second time using parsed template
        final StringWriter writer2 = new StringWriter();
        runtimeInstance.render(context, writer2, "logTag", parsedTemplate);
        System.out.println(writer2);
    }

}
