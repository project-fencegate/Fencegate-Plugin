package cc.fencegate.plugin.lang;

public enum Language {
    SQL_FAIL ("sql.fail");

    private String msg="";
    Language(String key) {
    }

    public String g(){
        return msg;
    }
}
