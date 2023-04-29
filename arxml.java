public class arxml implements Comparable <arxml>{
    private String uuid;
    private String shortName;
    private String longName;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    @Override
    public String toString() {
        return
                /*"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<AUTOSAR>\n"+
                */"    <CONTAINER UUID="+ uuid+">\n"+
                "         <SHORT-NAME>Container"+shortName+"</SHORT-NAME>\n"+
                "         <LONG-NAME>"+longName+"</LONG-NAME>\n"+
                "    </CONTAINER>\n";
                ///////////////;
    }

    @Override
    public int compareTo(arxml o) {
        if(this.getShortName().charAt(0)>o.getShortName().charAt(0)){return 1;}
        else if (this.getShortName().charAt(0)<o.getShortName().charAt(0)){return -1;}
        else
            return 0;
}}
