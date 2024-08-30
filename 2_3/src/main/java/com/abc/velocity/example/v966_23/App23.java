package com.abc.velocity.example.v966_23;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.runtime.RuntimeInstance;
import org.apache.velocity.runtime.parser.ParseException;
import org.apache.velocity.runtime.parser.node.SimpleNode;

import java.io.StringReader;
import java.io.StringWriter;

public class App23 {

    public static void main(String[] args) throws ParseException {
        final RuntimeInstance runtimeInstance = new RuntimeInstance();
        final VelocityContext context         = new VelocityContext();
        context.put("user", "abc");

        final Template aTemplate = new Template();
        aTemplate.setName("a_template");
        final SimpleNode parsedTemplate = runtimeInstance.parse(new StringReader("Hello $user !!!"), aTemplate);

        //first time using parsed template
        final StringWriter writer = new StringWriter();
        runtimeInstance.render(context, writer, "logTag", parsedTemplate);
        System.out.println(writer);

        //second time using parsed template - IT WILL FAIL :(
        final StringWriter writer2 = new StringWriter();
        runtimeInstance.render(context, writer2, "logTag", parsedTemplate);
        System.out.println(writer2);
    }

}
