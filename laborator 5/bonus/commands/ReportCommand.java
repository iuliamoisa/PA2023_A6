package org.example.commands;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.example.Catalog;

public class ReportCommand extends Command {
    Catalog catalog;
    private String reportPath;
    public ReportCommand(Catalog catalog, String path){
        this.catalog = catalog;
        this.reportPath = path;
    }
    @Override
    public void execute()
    {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(ReportCommand.class, "/");
        try
        {
            Map<String, Object> data = new HashMap<>();
            Template template = cfg.getTemplate("report.ftl");
            cfg.setDefaultEncoding("UTF-8");
            data.put("catalog", catalog);
            data.put("documents", catalog.getDocuments());

            FileWriter writer = new FileWriter(reportPath);
            template.process(data, writer);
            writer.flush();
            writer.close();

        }
        catch (TemplateException | IOException e) {
            System.err.println("Couldn't generate report...");
        }
    }
}
