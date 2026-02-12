package com.cron_email.cron_email.core.enums;

public enum FileTypeEnum {
    PDF("Portable Document Format"),
    DOC("Microsoft Word Document"),
    DOCX("Microsoft Word Open XML Document"),
    XLS("Microsoft Excel Spreadsheet"),
    XLSX("Microsoft Excel Open XML Spreadsheet"),
    PPT("Microsoft PowerPoint Presentation"),
    PPTX("Microsoft PowerPoint Open XML Presentation"),
    TXT("Plain Text File"),
    CSV("Comma Separated Values"),
    JPG("Joint Photographic Experts Group"),
    JPEG("Joint Photographic Experts Group"),
    PNG("Portable Network Graphics"),
    GIF("Graphics Interchange Format"),
    BMP("Bitmap Image File"),
    ZIP("ZIP Archive"),
    RAR("RAR Archive"),
    OTHER("Unknown File Type");

    private final String internalName;

    private FileTypeEnum(String internalName) {
        this.internalName = internalName;
    }

    public String getFullName() {
        return internalName;
    }

    }
