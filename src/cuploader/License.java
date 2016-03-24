package cuploader;

public enum License {

    CC_BY_SA_4("Creative Commons BY-SA 4.0", "{{cc-by-sa-4.0|%ATTRIB%}}"),
    CC_BY_SA_3("Creative Commons BY-SA 3.0", "{{cc-by-sa-3.0|%ATTRIB%}}"),
    CC_BY_3("Creative Commons BY 3.0", "{{cc-by-3.0|%ATTRIB%}}"),
    CC_ZERO_1("Creative Commons Zero 1.0", "{{cc-zero}}"),
    GFDL_CC_BY_SA_ALL(Data.text("license-gfdl-cc-by-sa-all"), "{{GFDL|migration=redundant}}{{cc-by-sa-all|%ATTRIB%}}"),
    GFDL_CC_BY_SA_3(Data.text("license-gfdl-cc-by-sa-3"), "{{GFDL|migration=redundant}}{{cc-by-sa 3.0|%ATTRIB%}}"),
    GFDL_CC_BY_3(Data.text("license-gfdl-cc-by-3"), "{{GFDL|migration=redundant}}{{cc-by 3.0|%ATTRIB%}}"),
    OTHER(Data.text("license-other"), ""),;

    final String name;
    final String template;

    License(String name, String template) {
        this.name = name;
        this.template = template;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getTemplate() {
        return template;
    }
}
